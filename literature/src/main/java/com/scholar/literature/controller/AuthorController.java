package com.scholar.literature.controller;

import com.scholar.literature.pojo.Author;
import com.scholar.literature.service.AuthorService;
import org.elasticsearch.client.RestHighLevelClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(value = "*",maxAge = 3600)
public class AuthorController {
    private static final Logger log = LoggerFactory.getLogger(AuthorController.class);

    @Autowired
    AuthorService authorService;

    @RequestMapping(value = "/getAuthors",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public Map<String,Object> getAuthors (@RequestParam String name){
        try {
            return null;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}