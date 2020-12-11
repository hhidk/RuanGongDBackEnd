package com.scholar.social.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import static com.scholar.social.util.ControllerParser.*;

/**
 * for sector get
 */
@RestController
public class SectorController {
    @RequestMapping(value = "/isFollowed",
            method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public Map<String, String> get(@RequestBody Map<String, Object> body) {
        int userId = parseUserId(body);
        int sectorId = parseSectorId(body);
        // TODO call service
        boolean status = false;
        boolean followed = false;
        Map<String, String> res = response(status);
        res.put("followed", String.valueOf(followed));
        return res;
    }

    @RequestMapping(value = "/followSector",
            method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public Map<String, String> set(@RequestBody Map<String, Object> body) {
        int userId = parseUserId(body);
        int sectorId = parseSectorId(body);
        // TODO call service
        boolean status = false;
        return response(status);
    }
}
