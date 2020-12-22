package com.scholar.literature.service;

import com.scholar.literature.controller.AuthorController;
import com.scholar.literature.pojo.Author;
import com.scholar.literature.pojo.LitAuthor;
import com.scholar.literature.pojo.Literature;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class AuthorService {

    private static final Logger log = LoggerFactory.getLogger(AuthorService.class);


    @Autowired
    RestHighLevelClient restHighLevelClient;

    public List<Map<String, Object>> getAuthors(String authorName) {

        try {
            List<Map<String, Object>> maps = new ArrayList<>();
            SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
            sourceBuilder.query(QueryBuilders.matchQuery("name", authorName));
            sourceBuilder.size(10000);
            SearchRequest searchRequest = new SearchRequest("author").source(sourceBuilder);
            SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
            SearchHits searchHits = searchResponse.getHits();
            for (SearchHit searchHit : searchHits) {
                Author author = new Author(searchHit.getSourceAsMap());
                Map<String, Object> map = new HashMap<>();
                map.put("authorID", author.getId());
                map.put("name", author.getName());
                maps.add(map);
            }
            return maps;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    static int stringToSeed(String s) {
        if (s == null) {
            return 0;
        }
        int hash = 0;
        for (char c : s.toCharArray()) {
            hash = 31*hash + c;
        }
        return Math.abs(hash);
    }

    public List<Integer> getPublishState(String authorID) {
        List<Integer> tmp = new ArrayList<>();
        Random random= new Random(stringToSeed(authorID));
        for (int i = 0; i < 12; i++) {
            tmp.add(
                    random.nextInt(3)
            );
        }
        return tmp;
    }


    public List<String> getRelatedAuthor(String venue) {
        log.info("In func:getRelatedAuthor : venue = {}", venue);
        Map<String, Object> ret = new HashMap<>();
        List<String> authorID = new ArrayList<>();
        try {
            SearchRequest searchRequest = new SearchRequest("literature");
            SearchSourceBuilder sb = new SearchSourceBuilder().size(10000);
            sb.size(10000);
            sb.query(QueryBuilders.matchQuery("venue.raw", venue));
            SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
            SearchHits searchHits = searchResponse.getHits();
            for (SearchHit searchHit : searchHits) {
                log.info("get literature, ID = {} ", searchHit.getId());
                authorID.addAll(
                        new Literature(
                                searchHit.getSourceAsMap())
                                .getAuthors()
                                .stream().filter(litAuthor -> litAuthor.getId()!=null)
                                .map(LitAuthor::getId).collect(Collectors.toList())
                );
            }
            //delete repeated factors
            authorID = authorID.
                    stream().
                    distinct().
                    collect(Collectors.toList());
            log.info("authors are {}", authorID);
            return authorID;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

}
