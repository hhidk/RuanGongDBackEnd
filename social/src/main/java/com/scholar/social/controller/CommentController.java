package com.scholar.social.controller;

import com.scholar.social.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
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

    private final CommentService service;

    @Autowired
    CommentController(CommentService service) {
        this.service = service;
    }

    @RequestMapping(value = "/deleteComment",
            method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public Map<String, String> delete(@RequestBody Map<String, Object> body) {
        String userId = parseUserId(body);
        int commentId = parseCommentId(body);
        boolean status = service.delete(userId, commentId);
        return response(status);
    }

    @RequestMapping(value = "/reportComment",
            method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public Map<String, String> report(@RequestBody Map<String, Object> body) {
        String userId = parseUserId(body);
        int commentId = parseCommentId(body);
        String content = parseContent(body);
        boolean status = service.report(userId, commentId, content);
        return response(status);
    }

    @RequestMapping(value = "/commentPost",
            method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public Map<String, String> put(@RequestBody Map<String, Object> body) {
        String userId = parseUserId(body);
        int postId = parsePostId(body);
        String content = parseContent(body);
        boolean status = service.put(userId, postId, content);
        return response(status);
    }
}
