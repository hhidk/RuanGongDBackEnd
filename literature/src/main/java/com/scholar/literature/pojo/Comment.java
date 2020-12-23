package com.scholar.literature.pojo;

import lombok.Data;

@Data
public class Comment {
    private int postCommentID;
    private String content;
    private String postID;
    private String userID;
    private String username;
    private String image;
    private int type;
    private String commentTime;

    public Comment(String content, String postID, String userID) {
        this.content = content;
        this.postID = postID;
        this.userID = userID;
    }
}
