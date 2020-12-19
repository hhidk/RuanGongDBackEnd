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

    @PostMapping(value = "/testget", produces = "application/json;charset=UTF-8")
    public Map<String, Object> testget(@RequestBody String literatureID) {
        try {
            return literatureService.getLiterature(literatureID);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    @PostMapping(value = "/getLiterature", produces = "application/json;charset=UTF-8")
    public Map<String, Object> getLiterature(@RequestBody Map<String ,Object> body) {
        log.info("body is {}",body);
        try {
            return literatureService.getLiterature((String) body.get("literatureID"));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @PostMapping(value = "/editLiterature", produces = "application/json;charset=UTF-8")
    public boolean editLiterature(@RequestBody Map<String ,Object> body) {
        try {
            return literatureService.editLiterature((String) body.get("literatureID"),(String)body.get("url"));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @PostMapping(value = "/addLiterature", produces = "application/json;charset=UTF-8")
    public boolean addLiterature(@RequestBody Literature literature){
        try {
            return literatureService.addLiterature(literature);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @PostMapping(value = "/getMyLiterature", produces = "application/json;charset=UTF-8")
    public List <Literature> getMyLiteratureList(@RequestParam String userID){
        try {
            return literatureService.getMyLiterature(userID);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

}
