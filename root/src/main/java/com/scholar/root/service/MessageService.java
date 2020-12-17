package com.scholar.root.service;

import com.scholar.root.dto.CommentMessage;
import com.scholar.root.dto.ConsultMessage;
import com.scholar.root.mapper.MessageMapper;
import com.scholar.root.pojo.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MessageService
{

    @Autowired
    private MessageMapper messageMapper;

    public List<CommentMessage> getCommentMsg(String userID) {
        List<CommentMessage> list = messageMapper.getCommentMessageByUserID(userID);
        return list;
    }

    public List<Message> getSystemMsg(String userID) {
        List<Message> list = messageMapper.getSystemMessageByUserID(userID);
        return list;
    }

    public List<ConsultMessage> getConsultMsg(String userID) {
        List<ConsultMessage> list = messageMapper.getConsultMessageByUserID(userID);
        return list;
    }

    public int deleteMsg(String messageID) {
        return messageMapper.deleteMessageByMessageID(messageID);
    }

    public int replyMsg(String messageID, String content) {

        Message originalMessage = messageMapper.getMessageByMessageID(messageID);
        Message replyMessage = new Message();
        Date date = new Date();

        replyMessage.setSenderID(originalMessage.getReceiverID());
        replyMessage.setReceiverID(originalMessage.getSenderID());
        replyMessage.setViewed(false);
        replyMessage.setContent(content);
        replyMessage.setType(2);
        replyMessage.setSendTime(date.toString());
        replyMessage.setCommentID(originalMessage.getMessageID());

        return messageMapper.addMessage(replyMessage);

    }

}
