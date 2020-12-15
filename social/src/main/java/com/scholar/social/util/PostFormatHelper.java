package com.scholar.social.util;

import java.util.Comparator;
import java.util.List;

public class PostFormatHelper {
    private final String lastUserId;
    private final long lastTime;
    private Post post;

    public PostFormatHelper(Post post) {
        this.post = post;
        List<Comment> commentList = post.getComments();
        if (commentList.isEmpty()) {
            lastUserId = post.getUserId();
            lastTime = post.getCreateTime();
        } else {
            commentList.sort(Comparator.comparingLong(Comment::getTime));
            Comment latest = commentList.get(commentList.size() - 1);
            lastUserId = latest.getUserId();
            lastTime = latest.getTime();
        }
    }

    public String getLastUserId() {
        return lastUserId;
    }

    public long getLastTime() {
        return lastTime;
    }
}
