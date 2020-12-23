package com.scholar.literature.controller;

import com.scholar.literature.dto.LiteraturePreview;
import com.scholar.literature.pojo.Literature;
import com.scholar.literature.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class CollectController {

    @Autowired
    private CollectService collectService;

    @RequestMapping("/collect")
    public int collect(@RequestParam("userID") String userID, @RequestParam("literatureID") String literatureID,
                       @RequestParam("title") String title, @RequestParam("option") int option,
                       @RequestParam("year") String year, @RequestParam("venue") String venue,
                       @RequestParam("realName") String realName) {
        try {
            return collectService.collect(userID, literatureID, title, option, year, venue, realName);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @RequestMapping("/getHighCollect")
    public List<LiteraturePreview> getHighCollect() {
        try {
            return collectService.getHighCollect();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping("/getcollect")
    public int getcollect(@RequestParam("userID") String userID, @RequestParam("literatureID") String literatureID) {
        try {
            return collectService.getcollect(userID, literatureID);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

}
