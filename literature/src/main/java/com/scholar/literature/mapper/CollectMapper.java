package com.scholar.literature.mapper;

import com.scholar.literature.dto.LiteraturePreview;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface CollectMapper {

    int addCollect(@Param("userID") String userID, @Param("literatureID") String literatureID, @Param("title") String title, @Param("year") String year, @Param("venue") String venue);

    int deleteCollect(@Param("userID") String userID, @Param("literatureID") String literatureID);

    // key: literatureID和月份差
    int getCollectCount(Map<String, Object> map);

    /**
     * 返回收藏量前10的文献列表
     */
    List<LiteraturePreview> getHighCollect();

    LiteraturePreview getLiteratureByLiteratureID(@Param("literatureID") String literatureID);

    String checkCollect(@Param("userID") String userID, @Param("literatureID") String literatureID);
}
