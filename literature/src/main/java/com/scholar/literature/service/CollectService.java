package com.scholar.literature.service;

import com.scholar.literature.dto.LiteraturePreview;
import com.scholar.literature.mapper.CollectMapper;
import com.scholar.literature.pojo.Literature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CollectService {

    @Autowired
    private CollectMapper collectMapper;

    public int collect(String userID, String literatureID, String title, int option, String year, String venue, String realName) throws Exception {
        if (option == 1) {
            collectMapper.addCollect(userID, literatureID, title, year, venue, realName);
        } else {
            collectMapper.deleteCollect(userID, literatureID);
        }
        return 0;
    }

    public List<LiteraturePreview> getHighCollect() throws Exception {
        List<LiteraturePreview> list = collectMapper.getHighCollect();
        for (LiteraturePreview literature : list) {
            LiteraturePreview info = collectMapper.getLiteratureByLiteratureID(literature.getLiteratureID());
            literature.setTitle(info.getTitle());
            literature.setVenue(info.getVenue());
            literature.setYear(info.getYear());
            Map<String, Object> map = new HashMap<>();
            map.put("realName", info.getRealName());
            literature.setAuthors(map);
        }
        return list;
    }

    public int getcollect(String userID, String literatureID) throws Exception {
        if (collectMapper.checkCollect(userID, literatureID) != null) {
            return 1;
        } else {
            return 0;
        }
    }
}
