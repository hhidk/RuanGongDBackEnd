package com.scholar.social.service;

import com.scholar.social.repository.PostRepository;
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
    private final PostRepository postRepository;

    @Autowired
    public SectorService(SectorRepository sectorRepository,
                         PostService postService,
                         PostRepository postRepository) {
        this.sectorRepository = sectorRepository;
        this.postService = postService;
        this.postRepository = postRepository;
    }

    public List<Sector> getAllSectors() {
        List<Sector> sectorList = sectorRepository.getAll();
        sectorList = sectorList.stream().peek(sector -> {
            sector.setTags(
                    Arrays.asList(sectorRepository.getTags(sector.getId()).split(";")));
            sector.setTot(sectorRepository.getTot(sector.getId()));
            if (sector.getTot() > 0) {
                List<Post> postList =
                        postService
                                .search(sector.getId(), 0, 1, SortType.UPDATE_TIME, "");
                sector.setPost(postList.get(0));
            } else {
                sector.setPost(null);
            }
        }).collect(Collectors.toList());
        return sectorList;
    }

    public int getTot(int sectorId, String keyword) {
        return postRepository.search(sectorId, keyword).size();
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
