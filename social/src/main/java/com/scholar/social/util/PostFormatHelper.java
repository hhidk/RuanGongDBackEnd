package com.scholar.social.util;

import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class PostFormatHelper {
    private final String lastUserId;
    private final Date lastTime;
    private Post post;

    public PostFormatHelper(Post post) {
        this.post = post;
        List<Comment> commentList = post.getComments();
        if (commentList.isEmpty()) {
            lastUserId = post.getUserId();
            lastTime = post.getCreateTime();
        } else {
            commentList.sort(Comparator.comparingLong(t -> t.getTime().getTime()));
            Comment latest = commentList.get(commentList.size() - 1);
            lastUserId = latest.getUserId();
            lastTime = latest.getTime();
        }
    }

    public Post getPost() {
        return post;
    }

    public String getLastUserId() {
        return lastUserId;
    }

    public Date getLastTime() {
        return lastTime;
    }
}
