package com.scholar.social.controller;

import com.scholar.social.generator.SectorGenerator;
import com.scholar.social.generator.UserGenerator;
import com.scholar.social.service.SectorService;
import com.scholar.social.service.UserService;
import com.scholar.social.util.Post;
import com.scholar.social.util.PostFormatHelper;
import com.scholar.social.util.Sector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.scholar.social.util.TimeFormat.format;


/**
 * for sector get
 */
@RestController
@CrossOrigin
public class SectorController {

    private final SectorService sectorService;
    private final UserService userService;

    @Autowired
    public SectorController(SectorService sectorService,
                            UserService userService) {
        this.sectorService = sectorService;
        this.userService = userService;
    }

    @RequestMapping(value = "/getAllSectors",
            method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public Map<String, Object> get() {
        List<Sector> sectorList = sectorService.getAllSectors();
        List<Map<String, Object>> sectorMapList = new ArrayList<>();

        for (Sector sector : sectorList) {
            Map<String, Object> sectorMap = SectorGenerator.info(sector);
            Post post = sector.getPost();
            if (post == null) {
                sectorMap.put("postId", "");
                sectorMap.put("postName", "");
                sectorMap.put("editTime", "");
            } else {
                PostFormatHelper helper = new PostFormatHelper(post);
                sectorMap.putAll(UserGenerator
                        .userInfo(userService.get(helper.getLastUserId()), "user"));
                sectorMap.put("postId", String.valueOf(post.getPostId()));
                sectorMap.put("postName", post.getTitle());
                sectorMap.put("editTime", format(helper.getLastTime()));
            }
            sectorMapList.add(sectorMap);
        }
        return Map.of("sectors", sectorMapList);
    }

    @RequestMapping(value = "/getAllTags",
            method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public Map<String, Object> getInfo() {
        List<Sector> sectorList = sectorService.getAllSectors();
        List<Map<String, Object>> sectorMapList = new ArrayList<>();
        for (Sector sector : sectorList) {
            sectorMapList.add(SectorGenerator.info(sector));
        }
        return Map.of("sectors", sectorMapList);
    }

    @PostMapping(value = "/getPostNum", produces = "application/json;charset=UTF-8")
    public Map<String, Object> getTotal(@RequestBody Map<String, Object> body) {
        int sectorId = Integer.parseInt((String) body.get("sectorId"));
        String keyword = (String) body.get("keyword");
        if (keyword == null) keyword = "";
        return Map.of("total", String.valueOf(sectorService.getTot(sectorId, keyword)));
    }
}
