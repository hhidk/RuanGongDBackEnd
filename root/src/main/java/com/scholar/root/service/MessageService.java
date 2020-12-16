package com.scholar.root.service;

import com.scholar.root.dto.CommentMessage;
import com.scholar.root.dto.SystemMessage;
import com.scholar.root.mapper.MessageMapper;
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

    public List<SystemMessage> getSystemMsg(String userID) {
        List<SystemMessage> list = messageMapper.getSystemMessageByUserID(userID);
        return list;
    }

}
