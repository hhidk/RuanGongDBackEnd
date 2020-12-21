package com.scholar.literature.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
@Mapper
public interface CollectMapper {

    int addCollect(@Param("userID") String userID, @Param("literatureID") String literatureID, @Param("title") String title);

    int deleteCollect(@Param("userID") String userID, @Param("literatureID") String literatureID);

    // key: literatureID和月份差
    int getCollectCount(Map<String, Object> map);

}
