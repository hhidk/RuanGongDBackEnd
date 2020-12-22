package com.scholar.social.generator;

import com.scholar.social.util.Comment;

import java.util.HashMap;
import java.util.Map;

import static com.scholar.social.util.TimeFormat.format;

public class CommentGenerator {
    public static Map<String, Object> info(Comment comment) {
        Map<String, Object> res = new HashMap<>();
        res.put("commentId", String.valueOf(comment.getId()));
        res.put("commentContent", comment.getContent());
        res.put("commentTime", format(comment.getTime()));
        return res;
    }
}
