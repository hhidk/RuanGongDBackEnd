package com.scholar.social.controller;

import com.scholar.social.service.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import static com.scholar.social.util.ControllerParser.*;

/**
 * for follow relationship get and set
 */
@RestController
public class FollowController {

    private final FollowService service;

    @Autowired
    FollowController(FollowService service) {
        this.service = service;
    }

    @RequestMapping(value = "/isFollowed",
            method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public Map<String, String> get(@RequestBody Map<String, Object> body) {
        String userId = parseUserId(body);
        int sectorId = parseSectorId(body);
        boolean followed = service.get(userId, sectorId);
        Map<String, String> res = new HashMap<>();
        res.put("followed", String.valueOf(followed ? 1 : 0));
        return res;
    }

    @RequestMapping(value = "/followSector",
            method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public Map<String, String> set(@RequestBody Map<String, Object> body) {
        String userId = parseUserId(body);
        int sectorId = parseSectorId(body);
        boolean status = service.set(userId, sectorId);
        return response(status);
    }
}
