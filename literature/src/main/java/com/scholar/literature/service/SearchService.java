package com.scholar.literature.service;

import com.scholar.literature.controller.AuthorController;
import com.scholar.literature.dto.SearchItem;
import com.scholar.literature.pojo.LitAuthor;
import com.scholar.literature.pojo.Literature;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.Index;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap.*;
import java.util.*;

@Service
public class SearchService {
    @Autowired
    RestHighLevelClient restHighLevelClient;

    private static final Logger log = LoggerFactory.getLogger(SearchService.class);

    public Map<String, Object> advancedSearch(List<SearchItem> list, int start, int end) {
        try {
            BoolQueryBuilder bq =QueryBuilders.boolQuery();
            SearchRequest searchRequest = new SearchRequest("literature");
            SearchSourceBuilder sb = new SearchSourceBuilder();
            for (SearchItem searchItem : list) {
                parseQuery(bq, searchItem);
            }
            bq=bq.filter(QueryBuilders.rangeQuery("year").gte(start).lte(end));
            sb.from(0);
            sb.query(bq);
            sb.size(10000);
            SearchResponse response = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
            return resultDeal(response);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public Map<String, Object> search(SearchItem item) {
        //String key = matchKeyword()
        try {
            BoolQueryBuilder bq = QueryBuilders.boolQuery();
            SearchRequest searchRequest = new SearchRequest("literature");
            SearchSourceBuilder sb = new SearchSourceBuilder();
            parseQuery(bq, item);
            searchRequest.source(sb);
            sb.from(0);
            sb.query(bq);
            sb.size(10000);
            //parse
            SearchResponse response = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
            return resultDeal(response);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("unknown err");
            return null;
        }
    }

    private Map<String, Object> resultDeal(SearchResponse response) {
        //
        int count = 0;
        int sum = 0;
        Map<String, Object> retmap = new HashMap<>();
        Map<String, Object> answer = new HashMap<>();
        List<Map<String, Object>> author = new ArrayList<>();
        List<Map<String, Object>> venue = new ArrayList<>();
        List<Map<String, Object>> year = new ArrayList<>();
        List<Map<String, Object>> list1 = new ArrayList<>();
        List<Map<String, Object>> list2 = new ArrayList<>();
        List<Map<String, Object>> list3 = new ArrayList<>();
        List<Literature> litsort = new ArrayList<>();
        Map<Integer, Integer> years = new TreeMap<>();
        Map<String, Integer> venues = new TreeMap<>();
        Map<String, Integer> authors = new TreeMap<>();

        /*
         *  into lits to a list ,sort them and
         * */
        long totalhits;
        SearchHits searchHits = response.getHits();
        totalhits = searchHits.getTotalHits().value;
        answer.put("num", totalhits);
        for (SearchHit searchHit : searchHits) {
            list3.add(new Literature(searchHit.getSourceAsMap()).retSearchMap());
            litsort.add(new Literature(searchHit.getSourceAsMap()));
        }
        for (Literature literature : litsort) {
            int y = literature.getYear();
            String v = literature.getVenue().getRaw();
            //count times that years appear
            Integer tmp = years.get(y);
            if (tmp == null) {
                years.put(y, 0);
            } else {
                years.put(y, tmp + 1);
            }
            //count times that venues appear
            tmp = venues.get(v);
            if (tmp == null) {
                venues.put(v, 0);
            } else {
                venues.put(v, tmp + 1);
            }
            //count times that authors appear
            for (LitAuthor literatureAuthor : literature.getAuthors()) {
                String n = literatureAuthor.getName();
                tmp = authors.get(n);
                if (tmp == null) {
                    authors.put(n, 0);
                } else {
                    authors.put(n, tmp + 1);
                }
            }
        }

        List<Map.Entry<String, Integer>> list_venue = new ArrayList<>(venues.entrySet());
        list_venue.sort(Map.Entry.comparingByValue());
        List<Map.Entry<Integer, Integer>> list_year = new ArrayList<>(years.entrySet());
        list_year.sort(Map.Entry.comparingByValue());
        List<Map.Entry<String, Integer>> list_authors = new ArrayList<>(authors.entrySet());
        list_authors.sort(Map.Entry.comparingByValue());

        //package author
        for (Map.Entry<String, Integer> list_author : list_authors) {
            if (count < 5) {
                Map<String, Object> tmp_author = new HashMap<>();
                tmp_author.put(list_author.getKey(), list_author.getValue());
                author.add(tmp_author);
                count++;
            } else {
                sum += list_author.getValue();
            }
        }
        Map<String, Object> tmp_author = new HashMap<>();
        tmp_author.put("others", sum);
        author.add(tmp_author);
        sum = 0;
        count = 0;

        //package venue
        for (Map.Entry<String, Integer> ves : list_venue) {
            if (count < 5) {
                Map<String, Object> tmp_venue = new HashMap<>();
                tmp_venue.put(ves.getKey(), ves.getValue());
                venue.add(tmp_venue);
                count++;
            } else {
                sum += ves.getValue();
            }
        }
        Map<String, Object> tmp_venue = new HashMap<>();
        tmp_venue.put("others", sum);
        venue.add(tmp_venue);
        sum = 0;
        count = 0;

        //package year
        for (Map.Entry<Integer, Integer> entry : list_year) {
            if (count < 5) {
                Map<String, Object> tmp_year = new HashMap<>();
                tmp_year.put(entry.getKey().toString(), entry.getValue());
                year.add(tmp_year);
                count++;
            } else {
                sum += entry.getValue();
            }
        }
        Map<String, Object> tmp_year = new HashMap<>();
        tmp_year.put("others", sum);
        year.add(tmp_year);

        litsort.sort(Comparator.comparing(Literature::getN_citation));
        for (Literature literature : litsort) {
            list1.add(literature.retSearchMap());
        }
        litsort.sort(Comparator.comparing(Literature::getYear));
        for (Literature literature : litsort) {
            list2.add(literature.retSearchMap());
        }

        retmap.put("answer", answer);
        retmap.put("literatureList1", list1);
        retmap.put("literatureList2", list2);
        retmap.put("literatureList3", list3);
        retmap.put("authorList", author);
        retmap.put("yearList", year);
        retmap.put("venueList", venue);
        return retmap;
    }

    private BoolQueryBuilder parseQuery(BoolQueryBuilder qb, SearchItem item) throws Exception {
        String s = matchKeyword(item.getType());
        String value = item.getValue();
        switch (item.getLogical()) {
            case "NOT":
                qb.mustNot(QueryBuilders.matchQuery(s, value));
                return qb;
            case "AND":
                qb.must(QueryBuilders.matchQuery(s, value));
                return qb;
            case "OR":
                qb.should(QueryBuilders.matchQuery(s, value));
                return qb;
            default:
                log.error("illegal logical");
                throw new  Exception("illegal bool keyword") ;
        }
    }

    private String matchKeyword(String s) {
        // TODO: unhandled FI
        switch (s) {
            case "SU": {
                return "keywords";
            }
            case "KY": {
                return "keywords";
            }
            case "TI": {
                return "title";
            }
            case "AU": {
                return "authors.id";
            }
            case "FI": {
                return "unreachable place";
            }
            case "AF": {
                return "authors.org";
            }
            case "LY": {
                return "venue.raw";
            }
            case "RF": {
                return "title";
            }
            default: {
                return "title";
            }
        }
    }
}
