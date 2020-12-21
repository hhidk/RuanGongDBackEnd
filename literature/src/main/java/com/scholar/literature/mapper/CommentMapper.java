package com.scholar.literature.mapper;

import com.scholar.literature.pojo.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface CommentMapper {

    int addComment(Comment comment);

    List<Comment> getCommentByLiteratureID(String literatureID);

    // key: literatureID和月份差
    int getCommentCount(Map<String, Object> map);

}
