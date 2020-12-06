package com.scholar.profile.controller;

import com.scholar.profile.dto.UserPreview;
import com.scholar.profile.service.UserSpaceService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class UserSpaceController {

    private UserSpaceService userSpaceService;

    @RequestMapping("/getFollowingList")
    public List<UserPreview> getFollowingList(@RequestParam("userID") String userID) {
        try {
            return userSpaceService.getFollowingList(userID);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping("/getFollowersList")
    public List<UserPreview> getFollowersList(@RequestParam("userID") String userID) {
        try {
            return userSpaceService.getFollowersList(userID);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
