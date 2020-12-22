package com.scholar.social.repository;

import com.scholar.social.util.Sector;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface SectorRepository {
    List<Sector> getAll();

    String getTags(@Param("sectorId") int sectorId);

    int getTot(@Param("sectorId") int sectorId);

    void setTot(@Param("sectorId") int sectorId, @Param("tot") int tot);
}
