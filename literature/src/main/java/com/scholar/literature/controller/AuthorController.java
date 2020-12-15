package com.scholar.literature.controller;

import com.scholar.literature.pojo.Author;
import com.scholar.literature.service.AuthorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(value = "*",maxAge = 3600)
public class AuthorController {
    private static final Logger log = LoggerFactory.getLogger(AuthorController.class);

    @Autowired
    AuthorService authorService;

    @PostMapping("/getAuthors")
    public List<Author> getAuthors (@RequestParam String name){
        try {
            return authorService.getAuthors(name);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
