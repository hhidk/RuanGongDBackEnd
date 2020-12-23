package com.scholar.social.repository;

import com.scholar.social.util.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserRepository {
    User get(@Param("userId") String userId);

    String getAuthorId(@Param("userId") String userId);

    int getIdent(@Param("userId") String userId);
}
