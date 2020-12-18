package com.scholar.social.controller;

import com.scholar.social.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import static com.scholar.social.util.ControllerParser.response;

@RestController
public class MessageController {
    private final MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping(value = "/createConsultation", produces = "application/json;charset=UTF-8")
    public Map<String, String> put(@RequestBody Map<String, Object> body) {
        String senderId = (String) body.get("senderId");
        String receiverId = (String) body.get("receiverId");
        String content = (String) body.get("content");
        boolean result = messageService.put(senderId, receiverId, content);
        return response(result);
    }
}
