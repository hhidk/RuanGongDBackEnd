package com.scholar.literature.service;

import com.scholar.literature.controller.AuthorController;
import com.scholar.literature.dto.SearchItem;
import com.scholar.literature.pojo.Literature;
import org.elasticsearch.action.get.GetRequest;
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
import java.util.Map;

@Service
public class SearchService {
    @Autowired
    RestHighLevelClient client;

    private static final Logger log = LoggerFactory.getLogger(SearchService.class);


    public Map<String, Object> advancedSearch(List<SearchItem> list, int start, int end) {
// TODO: 12/15/20  
        return null;
    }

    public Map<String, Object> search(SearchItem item) {
        //String key = matchKeyword()
        SearchRequest searchRequest = new SearchRequest("literature");
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchRequest.source(searchSourceBuilder);


        return null;
    }

    private String matchKeyword(String s) {
        // TODO: 12/16/20
        switch (s) {
            case "SU": {
                break;
            }
            case "KY": {
                break;
            }
            case "TI": {
                break;
            }
            case "AU": {
                break;
            }
            case "FI": {
                break;
            }
            case "AF": {
                break;
            }
            case "LY": {
                break;
            }
            case "RF": {
                break;
            }
            default: {
            }
        }
        return null;
    }
}
