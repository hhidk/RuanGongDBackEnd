package com.scholar.root.dto;

import lombok.Data;

@Data
public class CommentMessage
{
    int messageID;
    String senderID;
    String senderUserName;
    String image;
    String sendTime;
    String originalContent;
    String replyContent;
    boolean viewed;
}
