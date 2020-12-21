package com.scholar.literature.service;

import com.scholar.literature.controller.AuthorController;
import com.scholar.literature.pojo.Author;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AuthorService {

    private static final Logger log = LoggerFactory.getLogger(AuthorService.class);


    @Autowired
    RestHighLevelClient restHighLevelClient;
    public List<Map<String,Object>> getAuthors(String authorName) throws IOException {
        // TODO: 12/15/20
        try {
            List<Map<String,Object>> maps=new ArrayList<>();
            SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
            sourceBuilder.query(QueryBuilders.matchQuery("name",authorName));
            sourceBuilder.size(10000);
            SearchRequest searchRequest = new SearchRequest("authors").source(sourceBuilder);
            SearchResponse searchResponse = restHighLevelClient.search(searchRequest,RequestOptions.DEFAULT);
            SearchHits searchHits = searchResponse.getHits();
            for (SearchHit searchHit : searchHits) {
            Author author=new Author(searchHit.getSourceAsMap());
            Map<String,Object> map =new HashMap<>();
            map.put("authorID",author.getId());
            map.put("name",author.getName());
            maps.add(map);
            }
            return maps;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public List<String>getRelatedAuthor(String venue){
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
                                .stream()
                                .map(a->a.getId()).collect(Collectors.toList())
                        );
            }
            //delete repeated factors
            authorID=authorID.
                    stream().
                    distinct().
                    collect(Collectors.toList());
            log.info("authors are {}",authorID);
            return authorID;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

}