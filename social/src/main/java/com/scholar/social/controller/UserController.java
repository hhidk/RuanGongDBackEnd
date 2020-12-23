package com.scholar.social.controller;

import com.scholar.social.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import static com.scholar.social.util.ControllerParser.parseUserId;

@RestController
@CrossOrigin
public class UserController {
    private final UserService userService;


    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/getUserIdentity", produces = "application/json;charset=UTF-8")
    public Map<String, Object> getUserIdent(@RequestBody Map<String, Object> body) {
        String userId = parseUserId(body);
        String authorId = userService.getAuthorId(userId);
        int ident = userService.getIdent(userId);
        return Map.of("userIdentity", String.valueOf(ident), "authorID",
                authorId == null ? "" : authorId);
    }
}
