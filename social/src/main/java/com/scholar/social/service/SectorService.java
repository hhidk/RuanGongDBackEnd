package com.scholar.social.service;

import com.scholar.social.repository.SectorRepository;
import com.scholar.social.util.Post;
import com.scholar.social.util.Sector;
import com.scholar.social.util.SortType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class SectorService {
    private final SectorRepository sectorRepository;
    private final PostService postService;

    @Autowired
    public SectorService(SectorRepository sectorRepository,
                         PostService postService) {
        this.sectorRepository = sectorRepository;
        this.postService = postService;
    }

    public List<Sector> getAllSectors() {
        List<Sector> sectorList = sectorRepository.getAll();
        sectorList = sectorList.stream().peek(sector -> {
            List<Post> postList =
                    postService.search(sector.getId(), 0, 1, SortType.UPDATE_TIME, "");
            sector.setTags(
                    Arrays.asList(sectorRepository.getTags(sector.getId()).split(";")));
            if (postList.size() > 0) sector.setPost(postList.get(0));
        }).collect(Collectors.toList());
        return sectorList;
    }

    public int getTot(int sectorId) {
        return sectorRepository.getTot(sectorId);
    }

    public Map<Integer, String> getSectorNameMap() {
        List<Sector> sectorList = sectorRepository.getAll();
        Map<Integer, String> nameMap = new HashMap<>();
        for (Sector s :
                sectorList) {
            nameMap.put(s.getId(), s.getName());
        }
        return nameMap;
    }
}
