package com.scholar.literature.controller;

import com.scholar.literature.pojo.User;
import com.scholar.literature.service.GateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class GateController {

    @Autowired
    private GateService gateService;

    @RequestMapping("/getAuthorInformation")
    public User getAuthorInformation(String authorID) {
        try {
            return gateService.getAuthorInformation(authorID);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
