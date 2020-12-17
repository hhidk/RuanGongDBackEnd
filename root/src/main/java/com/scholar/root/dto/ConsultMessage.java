package com.scholar.root.dto;

import lombok.Data;

@Data
public class ConsultMessage
{
    int messageID;
    String senderID;
    String senderUserName;
    String image;
    String sendTime;
    String content;
    boolean viewed;
}
