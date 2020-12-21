package com.scholar.root.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Mapper
@Repository
public interface UserMapper
{

    int setNormalUser(@Param("userID") String userID);

    int setAuthor(Map<String, Object> map);

}
