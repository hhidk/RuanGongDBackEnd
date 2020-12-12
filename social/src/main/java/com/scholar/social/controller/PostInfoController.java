package com.scholar.social.controller;

import com.scholar.social.service.PostService;
import com.scholar.social.util.Post;
import com.scholar.social.util.SortType;
import org.springframework.beans.factory.annotation.Autowired;
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
    private final PostService service;

    @Autowired
    PostInfoController(PostService service) {
        this.service = service;
    }

    @RequestMapping(value = "/getPostInfo",
            method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public Map<String, Object> getInfo(@RequestBody Map<String, Object> body) {
        String userId = parseUserId(body);
        int postId = parsePostId(body);
        Post post = service.get(userId, postId);
        // TODO add view times
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
