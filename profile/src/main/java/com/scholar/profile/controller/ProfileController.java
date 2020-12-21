package com.scholar.profile.controller;

import com.scholar.profile.dto.UserPreview;
import com.scholar.profile.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@RestController
@CrossOrigin
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @RequestMapping("/register")
    public int register(@RequestParam("username") String username, @RequestParam("password") String password,
                        @RequestParam("password2") String password2) {
        try {
            return profileService.register(username, password, password2);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @RequestMapping("/login")
    public UserPreview login(@RequestParam("ID") String ID, @RequestParam("password") String password) {
        try {
            return profileService.login(ID, password);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping("/editProfile")
    public int editProfile(@RequestParam("userID") String userID, @RequestParam("realName") String realName,
                           @RequestParam("image") String image, @RequestParam("userDegree") int userDegree,
                           @RequestParam("phoneNumber") String phoneNumber,
                           @RequestParam("organization") String organization) {
        try {
            return profileService.editProfile(userID, realName, image, userDegree, phoneNumber, organization);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @RequestMapping("/editUserName")
    public int editUserName(@RequestParam("userID") String userID, @RequestParam("username") String username) {
        try {
            return profileService.editUserName(userID, username);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @RequestMapping("/editUserEmailAddress")
    public int editUserEmailAddress(@RequestParam("userID") String userID, @RequestParam("emailAddress") String emailAddress) {
        try {
            return profileService.editUserEmailAddress(userID, emailAddress);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @RequestMapping("/editUserImage")
    public int editUserImage(@RequestParam("userID") String userID, @RequestParam("imgUrl") String image) {
        try {
            return profileService.editUserImage(userID, image);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

}
