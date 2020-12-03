package com.scholar.profile.controller;

import com.scholar.profile.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @RequestMapping("/register")
    public int register(@RequestParam("/username") String username, @RequestParam("/password") String password) {
        try {
            return profileService.register(username, password);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

}
