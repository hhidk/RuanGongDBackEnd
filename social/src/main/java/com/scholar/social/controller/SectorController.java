package com.scholar.social.controller;

import com.scholar.social.service.PostService;
import com.scholar.social.service.SectorService;
import com.scholar.social.util.Sector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * for sector get
 */
@RestController
public class SectorController {

    private final SectorService sectorService;
    private final PostService postService;

    @Autowired
    public SectorController(SectorService sectorService,
                            PostService postService) {
        this.sectorService = sectorService;
        this.postService = postService;
    }

    @RequestMapping(value = "/getAllSectors",
            method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public Map<String, Object> get() {
        List<Sector> sectorList = sectorService.getAllSectors();
        // TODO format
        return null;
    }

    @RequestMapping(value = "/getAllTags",
            method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public Map<String, Object> getInfo() {
        // TODO call service
        return null;
    }
}
