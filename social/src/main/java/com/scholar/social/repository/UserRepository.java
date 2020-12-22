package com.scholar.social.repository;

import com.scholar.social.util.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserRepository {
    User get(@Param("userId") String userId);
}
