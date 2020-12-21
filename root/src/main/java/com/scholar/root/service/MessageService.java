package com.scholar.root.service;

import com.scholar.root.dto.CommentMessage;
import com.scholar.root.dto.ConsultMessage;
import com.scholar.root.mapper.MessageMapper;
import com.scholar.root.mapper.PostMapper;
import com.scholar.root.pojo.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService
{

    @Autowired
    private MessageMapper messageMapper;
    @Autowired
    private PostMapper postMapper;

    public List<CommentMessage> getCommentMsg(String userID) {
        List<CommentMessage> list = messageMapper.getCommentMessageByUserID(userID);
        for(CommentMessage commentMessage : list)
        {
            commentMessage.setOriginalContent(postMapper.getPostContentByPostID(Integer.parseInt(commentMessage.getPostID())));
        }
        return list;
    }

    public List<Message> getSystemMsg(String userID) {
        return messageMapper.getSystemMessageByUserID(userID);
    }

    public List<ConsultMessage> getConsultMsg(String userID) {
        return messageMapper.getConsultMessageByUserID(userID);
    }

    public int deleteMsg(String messageID) {
        return messageMapper.deleteMessageByMessageID(messageID);
    }

    public int replyMsg(String messageID, String content) {

        Message originalMessage = messageMapper.getMessageByMessageID(messageID);
        Message replyMessage = new Message();

        replyMessage.setSenderID(originalMessage.getReceiverID());
        replyMessage.setReceiverID(originalMessage.getSenderID());
        replyMessage.setViewed(false);
        replyMessage.setContent(content);
        replyMessage.setType(2);
        replyMessage.setCommentID(originalMessage.getMessageID());

        return messageMapper.addMessage(replyMessage);

    }

}
