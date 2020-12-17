package com.scholar.literature.controller;

import com.scholar.literature.dto.SearchItem;
import com.scholar.literature.pojo.Literature;
import com.scholar.literature.service.LiteratureService;
import com.scholar.literature.service.SearchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(value = "*", maxAge = 3600)
public class LiteratureController {

    private static final Logger log = LoggerFactory.getLogger(LiteratureController.class);

    @Autowired
    LiteratureService literatureService;

    @PostMapping("/getLiterature")
    public Literature getLiterature(@RequestParam String literatureID) {
        try {
            return literatureService.getLiterature(literatureID);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @PostMapping("/editLiterature")
    public boolean editLiterature(@RequestParam String literatureID, @RequestParam String url) {
        try {
            return literatureService.editLiterature(literatureID, url);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @PostMapping("/addLiterature")
    public boolean addLiterature(@RequestBody Literature literature){
        try {
            return literatureService.addLiterature(literature);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @PostMapping("/getMyLiterature")
    public List <Literature> getMyLiteratureList(@RequestParam String userID){
        try {
            return literatureService.getMyLiterature(userID);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

}
