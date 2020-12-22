package com.scholar.social.controller;

import com.scholar.social.service.PostService;
import com.scholar.social.util.Post;
import org.springframework.beans.factory.annotation.Autowired;
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
    private final PostService service;

    @Autowired
    PostController(PostService service) {
        this.service = service;
    }

    @RequestMapping(value = "/deletePost",
            method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public Map<String, String> delete(@RequestBody Map<String, Object> body) {
        String userId = parseUserId(body);
        int postId = parsePostId(body);
        boolean status = service.delete(userId, postId);
        return response(status);
    }

    @RequestMapping(value = "/reportPost",
            method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public Map<String, String> report(@RequestBody Map<String, Object> body) {
        String userId = parseUserId(body);
        int postId = parsePostId(body);
        String content = parseContent(body);
        boolean status = service.report(userId, postId, content);
        return response(status);
    }

    @RequestMapping(value = "/createPost",
            method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public Map<String, String> put(@RequestBody Map<String, Map<String, Object>> body) {
        Map<String, Object> form = body.get("createPostForm");
        String userId = parseUserId(form);
        String title = (String) form.get("postName");
        String content = parseContent(form);
        int sectorId = parseSectorId(form);
        List<String> tags = (List<String>) form.get("postTags");
        String citeId = (String) form.get("citeId");
        Post post = new Post();
        post = post.setUserId(userId)
                .setCiteId(citeId)
                .setTags(tags)
                .setTitle(title)
                .setComments(null)
                .setContent(content)
                .setSectorId(sectorId);
        int postId = service.put(post);
        Map<String, String> res = response(postId != -1);
        res.put("postId", String.valueOf(postId));
        return res;
    }
}
