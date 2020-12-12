package com.scholar.social.generator;

import com.scholar.social.util.Post;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

import static com.scholar.social.util.TimeFormat.format;

@Component
public class PostGenerator {
    public static Map<String, Object> basicInfo(Post post) {
        Map<String, Object> res = new HashMap<>();
        res.put("postId", String.valueOf(post.getPostId()));
        res.put("postName", post.getTitle());
        res.put("postContent", post.getContent());
        res.put("replyNum", String.valueOf(post.getComments().size()));
        res.put("viewNum", String.valueOf(post.getViewNum()));
        res.put("createTime", format(post.getCreateTime()));
        res.put("tags", post.getTags());
        return res;
    }
}
