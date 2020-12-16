package com.scholar.root.mapper;

import com.scholar.root.dto.CommentMessage;
import com.scholar.root.dto.SystemMessage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MessageMapper
{
    List<CommentMessage> getCommentMessageByUserID(@Param("userID") String userID);

    List<SystemMessage> getSystemMessageByUserID(@Param("userID") String userID);
}
