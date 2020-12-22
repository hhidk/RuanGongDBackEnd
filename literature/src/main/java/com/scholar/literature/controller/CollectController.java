package com.scholar.literature.controller;

import com.scholar.literature.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class CollectController {

    @Autowired
    private CollectService collectService;

    @RequestMapping("/collect")
    public int collect(@RequestParam("userID") String userID, @RequestParam("literatureID") String literatureID,
                       @RequestParam("title") String title, @RequestParam("option") int option,
                       @RequestParam("year") String year, @RequestParam("venue") String venue) {
        try {
            return collectService.collect(userID, literatureID, title, option, year, venue);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

}
