package com.scholar.profile.controller;

import com.scholar.profile.service.GateService;
import com.scholar.profile.util.MailClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class GateController {

    @Autowired
    private GateService gateService;
    @Autowired
    private MailClient mailClient;

    @RequestMapping("/follow")
    public int follow(@RequestParam("followerID") String followerID, @RequestParam("userID") String userID,
                      @RequestParam("option") int option) {
        try {
            return gateService.followUser(followerID, userID, option);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @RequestMapping("/applicate")
    public int applicate(@RequestParam("userID") String userID, @RequestParam("authorID") String authorID,
                         @RequestParam("emailAddress") String emailAddress, @RequestParam("content") String content) {
        try {
            return gateService.applicate(userID, authorID, emailAddress, content);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @RequestMapping("/emailVerification")
    public String emailVerification(@RequestParam("emailAddress") String emailAddress){
        try {
            String verificationCode = mailClient.generateVerificationCode();
            mailClient.sendEmailVerificationCode(emailAddress, verificationCode);
            return verificationCode;
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

}
