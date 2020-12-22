package com.scholar.social.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class ControllerParser {
    public static Map<String, String> response(boolean status) {
        Map<String, String> res = new HashMap<>();
        String result = "result";
        res.put(result, String.valueOf(status));
        return res;
    }

    public static String parseUserId(Map<String, Object> body) {
        String userId = "userId";
        if (body.containsKey(userId)) {
            return (String) body.get(userId);
        }
        return null;
    }

    public static int parseSectorId(Map<String, Object> body) {
        String sectorId = "sectorId";
        if (body.containsKey(sectorId)) {
            return Integer.parseInt((String) body.get(sectorId));
        }
        return -1;
    }

    public static int parseCommentId(Map<String, Object> body) {
        String commentId0 = "deleteCommentId";
        String commentId1 = "reportCommentId";
        if (body.containsKey(commentId0)) {
            return Integer.parseInt((String) body.get(commentId0));
        } else if (body.containsKey(commentId1)) {
            return Integer.parseInt((String) body.get(commentId1));
        }
        return -1;
    }

    public static int parsePostId(Map<String, Object> body) {
        String postId = "postId";
        if (body.containsKey(postId)) {
            return Integer.parseInt((String) body.get(postId));
        }
        return -1;
    }

    public static String parseContent(Map<String, Object> body) {
        List<String> contentList = List.of("commentContent", "reportContent", "postContent");
        for (String contentName : contentList) {
            if (body.containsKey(contentName)) {
                return (String) body.get(contentName);
            }
        }
        return null;
    }
}
