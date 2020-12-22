package com.scholar.literature.controller;

import com.scholar.literature.dto.SearchItem;
import com.scholar.literature.pojo.Literature;
import com.scholar.literature.service.SearchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class SearchController {

    @Autowired
    private SearchService searchService;

    private static final Logger log = LoggerFactory.getLogger(SearchController.class);


    @PostMapping(value = "/search", produces = "application/json;charset=UTF-8")
    public Map<String,Object> simpleSearch(@RequestBody SearchItem detail) {
        try {
            return searchService.search(detail);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    @PostMapping(value = "/advance",produces = "application/json;charset=UTF-8")
    public Map<String,Object> advancedSearch(@RequestBody List<SearchItem> detail,
                                           @RequestParam("start") int start, @RequestParam("end") int end) {
        try {
            return searchService.advancedSearch(detail, start, end);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}
