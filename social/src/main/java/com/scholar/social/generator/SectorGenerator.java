package com.scholar.social.generator;

import com.scholar.social.util.Sector;

import java.util.HashMap;
import java.util.Map;

public class SectorGenerator {
    public static Map<String, Object> info(Sector sector) {
        Map<String, Object> res = new HashMap<>();
        res.put("sectorId", String.valueOf(sector.getId()));
        res.put("sectorName", sector.getName());
        res.put("postNum", String.valueOf(sector.getTot()));
        res.put("sectorTags", sector.getTags());
        return res;
    }
}
