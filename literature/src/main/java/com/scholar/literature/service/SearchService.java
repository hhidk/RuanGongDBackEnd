package com.scholar.literature.service;

import com.scholar.literature.controller.AuthorController;
import com.scholar.literature.dto.SearchItem;
import com.scholar.literature.pojo.Literature;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SearchService {
    @Autowired
    RestHighLevelClient restHighLevelClient;

    private static final Logger log = LoggerFactory.getLogger(SearchService.class);


    public Map<String, Object> advancedSearch(List<SearchItem> list, int start, int end) {
        // TODO: 12/15/20
        return null;
    }

    private Map<String,Object>resultDeal(SearchResponse response){
        Map<String,Object>retmap=new HashMap<>();
        Map<String,Object>answer=new HashMap<>();
        List<Map<String,Object>> author=new ArrayList<>();
        List<Map<String,Object>> venue=new ArrayList<>();
        List<Map<String,Object>> year=new ArrayList<>();
        List<Map<String,Object>>list1 =new ArrayList<>();
        long totalhits=0;
        SearchHits searchHits = response.getHits();
        totalhits=searchHits.getTotalHits().value;
        answer.put("num",totalhits);
        for (SearchHit searchHit : searchHits) {
            list1.add(new Literature(searchHit.getSourceAsMap()).retSearchMap());
        }

        retmap.put("answer",answer);
        retmap.put("literatureList1",list1);
        retmap.put("literatureList2",list1);
        retmap.put("authorList",author);
        retmap.put("yearList",year);
        retmap.put("venueList",venue);
    }


    public Map<String, Object> search(SearchItem item) {
        //String key = matchKeyword()
        try {
            BoolQueryBuilder bq = QueryBuilders.boolQuery();
            SearchRequest searchRequest = new SearchRequest("literature");
            SearchSourceBuilder sb = new SearchSourceBuilder();
            sb.size(10000);
            bq=parseQuery(bq,item);
            searchRequest.source(sb);
            SearchResponse  response = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
            return resultDeal(response);
        }catch (Exception e){
            e.printStackTrace();
            log.error("unknown err");
            return null;
        }
    }

    private BoolQueryBuilder parseQuery(BoolQueryBuilder qb, SearchItem item) {
        BoolQueryBuilder boolQueryBuilder = new BoolQueryBuilder();
        String s = matchKeyword(item.getType());
        String value = item.getValue();
        if (item.getLogical() == "NOT") {
            qb = qb.mustNot(QueryBuilders.matchQuery(s, value));
            return qb;
        } else if (item.getLogical() == "AND") {
            qb = qb.must(QueryBuilders.matchQuery(s, value));
        } else if (item.getLogical() == "OR") {
            qb = qb.should(QueryBuilders.matchQuery(s, value));
        }else {
            log.error("illegal logical");
        }
        return null;
    }

    private String matchKeyword(String s) {
        // TODO: 12/16/20
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
                return null;
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
