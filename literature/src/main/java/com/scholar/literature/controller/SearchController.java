package com.scholar.literature.controller;

import com.scholar.literature.dto.SearchItem;
import com.scholar.literature.pojo.Literature;
import com.scholar.literature.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
public class SearchController {

    @Autowired
    private SearchService searchService;


    @PostMapping("/search")
    public List<Literature> simpleSearch(@RequestBody List<SearchItem> detail){
    //@todo : fix Search logic
        return null;
    }


    @PostMapping("/advance")
    public List<Literature> advancedSearch(@RequestBody List<SearchItem> detail,
                                           @RequestParam("start") int start, @RequestParam("end") int end){
        try {
            return searchService.advancedSearch(detail, start, end);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}
