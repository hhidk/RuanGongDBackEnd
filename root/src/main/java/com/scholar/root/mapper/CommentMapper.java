package com.scholar.root.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface CommentMapper
{

    int deleteCommentByCommentID(@Param("commentID") int commentID);

}
