package com.scholar.root.mapper;

import com.scholar.root.dto.CommentMessage;
import com.scholar.root.dto.ConsultMessage;
import com.scholar.root.pojo.Message;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MessageMapper
{
    List<CommentMessage> getCommentMessageByUserID(@Param("userID") String userID);

    List<Message> getSystemMessageByUserID(@Param("userID") String userID);

    List<ConsultMessage> getConsultMessageByUserID(@Param("userID") String userID);

    int deleteMessageByMessageID(@Param("messageID") String messageID);

    Message getMessageByMessageID(@Param("messageID") String messageID);

    int addMessage(Message message);
}
