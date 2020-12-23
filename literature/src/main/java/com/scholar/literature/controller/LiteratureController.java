package com.scholar.literature.controller;

import com.scholar.literature.dto.SearchItem;
import com.scholar.literature.mapper.UserMapper;
import com.scholar.literature.pojo.Literature;
import com.scholar.literature.service.LiteratureService;
import com.scholar.literature.service.SearchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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
    public boolean editLiterature(@RequestParam String Lid, @RequestParam String url, @RequestParam String userID) {
        try {
            return literatureService.editLiterature(Lid, url);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @PostMapping(value = "/addLiterature", produces = "application/json;charset=UTF-8")
    public int addLiterature(@RequestParam Map<String,Object> createLiForm, @RequestParam String userID) {
        try {
            return literatureService.addLiterature(createLiForm,userID);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @PostMapping(value = "/deleteLiterature")
    public boolean deleteLiterature(@RequestParam String literatureID) {
        try {
            return literatureService.deleteLiterature(literatureID);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @PostMapping(value = "/getMyLiterature")
    public List<Map<String, Object>> getMyLiteratureList(@RequestParam String authorID) {
        try {
            return literatureService.getMyLiterature(authorID);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping("/getHighCitation")
    public Map<String, Object> getHighCitation() {
        try {
            Map<String, Object> re = new HashMap<>();
            re.put("citationList", literatureService.getHighCitation());
            return re;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    @RequestMapping("/getStats")
    public Map<String, Object> getStats(@RequestParam("literatureID") String literatureID) {
        try {
            return literatureService.getStats(literatureID);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
