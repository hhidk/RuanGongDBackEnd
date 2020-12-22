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

    @RequestMapping("/apply")
    public int apply(@RequestParam("userID") String userID, @RequestParam("authorID") String authorID, @RequestParam("realName") String realName,
                     @RequestParam("emailAddress") String emailAddress, @RequestParam("content") String content) {
        try {
            return gateService.apply(userID, authorID, realName, emailAddress, content);
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

    @RequestMapping("/getApplyStatus")
    public int getApplyStatus(@RequestParam("userID") String userID) {
        try {
            return gateService.getApplyStatus(userID);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @RequestMapping("/reportGate")
    public int reportGate(@RequestParam("userID") String userID, @RequestParam("authorID") String authorID,
                          @RequestParam("content") String content) {
        try {
            return gateService.reportGate(userID, authorID, content);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @RequestMapping("/getIntroFollowStatus")
    public int getIntroFollowStatus(@RequestParam("userID") String userID, @RequestParam("authorID") String authorID) {
        try {
            return gateService.getIntroFollowStatus(userID, authorID);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

}
