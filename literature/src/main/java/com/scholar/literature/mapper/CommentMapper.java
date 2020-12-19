package com.scholar.literature.mapper;

import com.scholar.literature.pojo.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface CommentMapper {

    int addComment(Comment comment);

}
