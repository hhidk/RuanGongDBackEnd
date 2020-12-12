package com.scholar.social.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import static com.scholar.social.util.ControllerParser.*;

/**
 * for comments' CURD
 */
@RestController
public class CommentController {


    @RequestMapping(value = "/deleteComment",
            method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public Map<String, String> delete(@RequestBody Map<String, String> body) {
        int userId = parseUserId(body);
        int commentId = parseCommentId(body);
        // TODO call service
        boolean status = false;
        return response(status);
    }

    @RequestMapping(value = "/reportComment",
            method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public Map<String, String> report(@RequestBody Map<String, String> body) {
        int userId = parseUserId(body);
        int commentId = parseCommentId(body);
        String content = parseContent(body);
        // TODO call service
        boolean status = false;
        return response(status);
    }

    @RequestMapping(value = "/commentPost",
            method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public Map<String, String> put(@RequestBody Map<String, String> body) {
        int userId = parseUserId(body);
        int postId = parsePostId(body);
        String content = parseContent(body);
        // TODO call service
        boolean status = false;
        return response(status);
    }
}
