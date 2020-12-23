package com.scholar.social.controller;

import com.scholar.social.service.FollowService;
import com.scholar.social.service.SectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.scholar.social.util.ControllerParser.*;

/**
 * for follow relationship get and set
 */
@RestController
@CrossOrigin
public class FollowController {

    private final FollowService followService;
    private final SectorService sectorService;

    @Autowired
    FollowController(FollowService followService, SectorService sectorService) {
        this.followService = followService;
        this.sectorService = sectorService;
    }

    @RequestMapping(value = "/isFollowed",
            method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public Map<String, String> get(@RequestBody Map<String, Object> body) {
        String userId = parseUserId(body);
        int sectorId = parseSectorId(body);
        boolean followed = followService.get(userId, sectorId);
        Map<String, String> res = new HashMap<>();
        res.put("followed", String.valueOf(followed ? 1 : 0));
        return res;
    }

    @RequestMapping(value = "/followSector",
            method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public Map<String, String> set(@RequestBody Map<String, Object> body) {
        String userId = parseUserId(body);
        int sectorId = parseSectorId(body);
        boolean status = followService.set(userId, sectorId);
        return response(status);
    }

    @PostMapping(value = "/isFollowedAll", produces = "application/json;charset=UTF-8")
    public Map<String, Object> getAll(@RequestBody Map<String, Object> body) {
        String userId = parseUserId(body);
        Map<Integer, String> nameMap = sectorService.getSectorNameMap();
        List<Map<String, Object>> res = new ArrayList<>();
        for (Integer sectorId :
                nameMap.keySet()) {
            boolean status = followService.get(userId, sectorId);
            res.add(Map.of("sectorId", String.valueOf(sectorId), "followed", status ? "1" : "0"));
        }
        return Map.of("sectors", res);
    }
}
