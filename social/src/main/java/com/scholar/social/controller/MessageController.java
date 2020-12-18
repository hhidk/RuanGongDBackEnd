package com.scholar.social.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class MessageController {
    @PostMapping(value = "/createConsultation", produces = "application/json;charset=UTF-8")
    public Map<String, Object> put(@RequestBody Map<String, Object> body) {
        // TODO send message
        return null;
    }
}
