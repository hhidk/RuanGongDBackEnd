package com.scholar.literature.controller;

import com.scholar.literature.pojo.Literature;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
public class SearchController {

    @PostMapping("/advance")
    public List<Literature> advancedSearch(String detail, int start, int end){
        System.out.println(detail);
        System.out.println(start);
        System.out.println(end);

        List<Literature> list = new ArrayList();
        list.add(new Literature("hh","hh"));
        return list;
    }

    @RequestMapping("/test")
    public String test(@RequestParam("param") String param){
        return "true";
    }

}
