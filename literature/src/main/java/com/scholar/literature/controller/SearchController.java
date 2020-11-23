package com.scholar.literature.controller;

import com.scholar.literature.dto.SearchItem;
import com.scholar.literature.pojo.Literature;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
public class SearchController {

    @PostMapping("/advance")
    public List<Literature> advancedSearch(@RequestBody List<SearchItem> detail,
                                           @RequestParam("start") int start, @RequestParam("end") int end){

        System.out.println(start);
        System.out.println(end);
        for (SearchItem item : detail) {
            System.out.println(item.getValue());
        }

        List<Literature> list = new ArrayList();
        list.add(new Literature("hh","hh"));
        return list;
    }

    @RequestMapping("/test")
    public String test(@RequestParam("param") String param){
        return "true";
    }

}
