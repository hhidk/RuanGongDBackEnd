package com.scholar.literature.mapper;

import com.scholar.literature.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserMapper {

    /**
     * 根据authorID在user表中查找
     */
    User getUserByAuthorID();

}
