package com.scholar.root.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface PostMapper
{

    int deletePostByPostID(@Param("postID") int postID);
}
