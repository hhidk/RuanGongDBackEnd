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
@CrossOrigin(value = "*", maxAge = 3600)
public class AuthorController {
    private static final Logger log = LoggerFactory.getLogger(AuthorController.class);

    @Autowired
    AuthorService authorService;

    @PostMapping(value = "/getRelatedAuthor")
    public List<String> getRelatedAuthor(@RequestParam String venue) {
        try {
            return authorService.getRelatedAuthor(venue);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @PostMapping(value = "/getAuthors")
    public List<Map<String, Object>> getAuthors(@RequestParam String name) {
        try {
            return authorService.getAuthors(name);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @PostMapping(value = "/getPublishState")
    public List<Integer>getPublishState(@RequestParam String authorID){
        try {
            return authorService.getPublishState(authorID);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }


}


