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
import java.util.Map;


@RestController
@CrossOrigin(value = "*", maxAge = 3600)
public class LiteratureController {

    private static final Logger log = LoggerFactory.getLogger(LiteratureController.class);

    @Autowired
    LiteratureService literatureService;

    @PostMapping(value = "/getRelation")
    public Map<String, Object> getRelation(@RequestParam String venue) {
        try {
            return literatureService.getRelation(venue);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    @PostMapping(value = "/getLiterature")
    public Map<String, Object> getLiterature(@RequestParam String literatureID) {
        try {
            return literatureService.getLiterature(literatureID);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @PostMapping(value = "/editLiterature")
    public boolean editLiterature(@RequestParam String Lid,@RequestParam String url,@RequestParam String userID) {
        try {
            return literatureService.editLiterature(Lid,url);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @PostMapping(value = "/addLiterature")
    public boolean addLiterature(@RequestBody Literature literature){
        try {
            return literatureService.addLiterature(literature);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @PostMapping(value = "/deleteLiterature")
    public boolean deleteLiterature(@RequestParam String literatureID){
        try {
           return literatureService.deleteLiterature(literatureID);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @PostMapping(value = "/getMyLiterature")
    public List <Map<String,Object>> getMyLiteratureList(@RequestParam String userID){
        try {
            return literatureService.getMyLiterature(userID);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

}
