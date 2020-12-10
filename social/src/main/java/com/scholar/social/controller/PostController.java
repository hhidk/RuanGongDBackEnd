package com.scholar.social.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import static com.scholar.social.util.ControllerParser.*;

/**
 * for posts' CURD
 */
@RestController
public class PostController {

    @RequestMapping(value = "/deletePost",
            method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public Map<String, String> delete(@RequestBody Map<String, String> body) {
        // TODO match front end's body
        int userId = parseUserId(body);
        int commentId = parseCommentId(body);
        // TODO call service
        boolean status = false;
        return response(status);
    }

    @RequestMapping(value = "/reportPost",
            method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public Map<String, String> report(@RequestBody Map<String, String> body) {
        // TODO match front end's body
        int userId = parseUserId(body);
        int commentId = parseCommentId(body);
        String content = parseContent(body);
        // TODO call service
        boolean status = false;
        return response(status);
    }

    @RequestMapping(value = "/createPost",
            method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public Map<String, String> put(@RequestBody Map<String, Map<String, String>> body) {
        // TODO match front end's body
        Map<String, String> form = body.get("createPostForm");
        int userId = parseUserId(form);
        String content = parseContent(form);
        // TODO call service
        boolean status = false;
        return response(status);
    }
}
