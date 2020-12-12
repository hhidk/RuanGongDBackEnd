package com.scholar.social.controller.generator;

import com.scholar.social.util.Post;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

import static com.scholar.social.util.TimeFormat.format;

@Component
public class PostGenerator {
    public Map<String, Object> basicInfo(Post post) {
        Map<String, Object> res = new HashMap<>();
        res.put("postName", post.getTitle());
        res.put("postContent", post.getContent());
        res.put("replyNum", String.valueOf(post.getComments().size()));
        res.put("viewNum", String.valueOf(post.getViewNum()));
        res.put("creatorId", String.valueOf(post.getUserId()));
        res.put("creatorAvatar", post.getUserAvatar());
        res.put("creatorName", post.getUserName());
        res.put("createTime", format(post.getCreateTime()));
        return res;
    }

    public Map<String, Object> updatedInfo(Post post) {
        Map<String, Object> res = new HashMap<>();
        return res;
    }
}
