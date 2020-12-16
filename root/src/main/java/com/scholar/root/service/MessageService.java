package com.scholar.root.service;

import com.scholar.root.dto.CommentMessage;
import com.scholar.root.dto.ConsultMessage;
import com.scholar.root.dto.SystemMessage;
import com.scholar.root.mapper.MessageMapper;
import com.scholar.root.pojo.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
