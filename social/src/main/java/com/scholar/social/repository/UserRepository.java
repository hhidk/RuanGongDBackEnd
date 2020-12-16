package com.scholar.social.repository;

import com.scholar.social.util.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserRepository {
    User get(String userId);
}
