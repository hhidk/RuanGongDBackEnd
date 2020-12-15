package com.scholar.literature.service;

import com.scholar.literature.pojo.Author;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    RestHighLevelClient restHighLevelClient;
    public List<Author> getAuthors(String authorName){
        // TODO: 12/15/20
        return null;
    }
}
