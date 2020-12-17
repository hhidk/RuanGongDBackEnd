package com.scholar.root.pojo;

import lombok.Data;

@Data
public class Message
{
    int messageID;
    String senderID;
    String receiverID;
    boolean viewed;
    String content;
    int type;
    String sendTime;
    int commentID;
}
