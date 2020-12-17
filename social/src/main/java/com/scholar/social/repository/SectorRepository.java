package com.scholar.social.repository;

import com.scholar.social.util.Sector;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface SectorRepository {
    List<Sector> getAll();

    String getTags(int SectorId);
}