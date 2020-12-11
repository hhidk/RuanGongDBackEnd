package com.scholar.social.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

import static com.scholar.social.util.ControllerParser.*;

/**
 * for posts' CURD
 */
@RestController
public class PostController {

    @RequestMapping(value = "/deletePost",
            method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public Map<String, String> delete(@RequestBody Map<String, Object> body) {
        int userId = parseUserId(body);
        int postId = parsePostId(body);
        // TODO call service
        boolean status = false;
        return response(status);
    }

    @RequestMapping(value = "/reportPost",
            method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public Map<String, String> report(@RequestBody Map<String, Object> body) {
        int userId = parseUserId(body);
        int postId = parsePostId(body);
        String content = parseContent(body);
        // TODO call service
        boolean status = false;
        return response(status);
    }

    @RequestMapping(value = "/createPost",
            method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public Map<String, String> put(@RequestBody Map<String, Map<String, Object>> body) {
        Map<String, Object> form = body.get("createPostForm");
        int userId = parseUserId(form);
        String name = (String) form.get("postName");
        String content = parseContent(form);
        int sectorId = parseSectorId(form);
        List<String> tags = (List<String>) form.get("postTags");
        int citeId = Integer.parseInt((String) form.get("citeId"));
        // TODO call service
        boolean status = false;
        return response(status);
    }
}
