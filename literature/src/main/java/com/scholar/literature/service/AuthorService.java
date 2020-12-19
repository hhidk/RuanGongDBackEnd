package com.scholar.literature.service;

import com.scholar.literature.controller.AuthorController;
import com.scholar.literature.pojo.Author;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    private static final Logger log = LoggerFactory.getLogger(AuthorService.class);


    @Autowired
    RestHighLevelClient restHighLevelClient;
    public List<Author> getAuthors(String authorName){
        // TODO: 12/15/20
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        sourceBuilder.query(QueryBuilders.matchQuery("name",authorName));
        sourceBuilder.size(10000);
        SearchRequest searchRequest = new SearchRequest("authors").source(sourceBuilder);


        return null;
    }
}
