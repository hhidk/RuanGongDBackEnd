package com.scholar.profile.mapper;

import com.scholar.profile.dto.LiteraturePreview;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface FavoriteMapper {

    List<LiteraturePreview> getFavoriteByUserID(String userID);

}
