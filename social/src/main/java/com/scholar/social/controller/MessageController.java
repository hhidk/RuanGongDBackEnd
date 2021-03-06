package com.scholar.social.controller;

import com.scholar.social.service.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import static com.scholar.social.util.ControllerParser.response;

@RestController
@CrossOrigin
public class MessageController {
    private static final Logger log = LoggerFactory.getLogger(MessageController.class);
    private final MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping(value = "/createConsultation", produces = "application/json;charset=UTF-8")
    public Map<String, String> put(@RequestBody Map<String, Object> body) {
        log.debug("body: {}", body);
        String senderId = (String) body.get("senderId");
        String receiverId = (String) body.get("receiverId");
        String content = (String) body.get("text");
        boolean result = messageService.put(senderId, receiverId, content);
        return response(result);
    }
}
