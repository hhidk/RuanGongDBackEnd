package com.scholar.literature.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface CollectMapper {

    int addCollect(@Param("userID") String userID, @Param("literatureID") String literatureID, @Param("title") String title);

    int deleteCollect(@Param("userID") String userID, @Param("literatureID") String literatureID);

}
