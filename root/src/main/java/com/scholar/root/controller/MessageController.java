package com.scholar.root.controller;

import com.scholar.root.dto.CommentMessage;
import com.scholar.root.dto.ConsultMessage;
import com.scholar.root.pojo.Message;
import com.scholar.root.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class MessageController
{

    @Autowired
    private MessageService messageService;

    @PostMapping("/getCommentMsg")
    public List<CommentMessage> getCommentMsg(@RequestParam("userID") String userID) {
        try {
            return messageService.getCommentMsg(userID);
        }
        catch (Exception e)  {
            e.printStackTrace();
            return null;
        }
    }

    @PostMapping("/getSystemMsg")
    public List<Message> getSystemMsg(@RequestParam("userID") String userID) {
        try {
            return messageService.getSystemMsg(userID);
        }
        catch (Exception e)  {
            e.printStackTrace();
            return null;
        }
    }

    @PostMapping("/getConsultMsg")
    public List<ConsultMessage> getConsultMsg(@RequestParam("userID") String userID) {
        try {
            return messageService.getConsultMsg(userID);
        }
        catch (Exception e)  {
            e.printStackTrace();
            return null;
        }
    }

    @PostMapping("/deleteMsg")
    public int deleteMsg(@RequestParam("messageID") int messageID) {
        try {
            return messageService.deleteMsg(messageID);
        }
        catch (Exception e)  {
            e.printStackTrace();
            return 0;
        }
    }

    @PostMapping("/replyMsg")
    public int replyMsg(@RequestParam("messageID") int messageID, @RequestParam("content") String content) {
        try {
            return messageService.replyMsg(messageID, content);
        }
        catch (Exception e)  {
            e.printStackTrace();
            return 0;
        }
    }

    @PostMapping("/sendSysMsg")
    public int sendSysMsg(@RequestParam("content") String content) {
        try {
            return messageService.sendSysMsg(content);
        }
        catch (Exception e)  {
            e.printStackTrace();
            return 0;
        }
    }

}
