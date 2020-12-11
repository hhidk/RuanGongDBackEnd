package com.scholar.social.controller;

import com.scholar.social.util.SortType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import static com.scholar.social.util.ControllerParser.*;

/**
 * for post search and get post info
 */
@RestController
public class PostInfoController {
    @RequestMapping(value = "/getPostInfo",
            method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public Map<String, Object> getInfo(@RequestBody Map<String, Object> body) {
        int userId = parseUserId(body);
        int postId = parsePostId(body);
        // TODO call service
        return null;
    }

    @RequestMapping(value = "/search",
            method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public Map<String, Object> search(@RequestBody Map<String, Object> body) {
        int sectorId = parseSectorId(body);
        int start = Integer.parseInt((String) body.get("start"));
        int num = Integer.parseInt((String) body.get("num"));
        SortType sort = SortType.values()[Integer.parseInt((String) body.get("sort"))];
        String keyword = (String) body.get("keyword");
        // TODO call service
        return null;
    }
}
