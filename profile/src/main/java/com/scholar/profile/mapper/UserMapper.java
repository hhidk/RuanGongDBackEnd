package com.scholar.profile.mapper;

import com.scholar.profile.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserMapper {

    int addUser(User user);

}
