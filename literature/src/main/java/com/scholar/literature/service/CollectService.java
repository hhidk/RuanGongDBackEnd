package com.scholar.literature.service;

import com.scholar.literature.dto.LiteraturePreview;
import com.scholar.literature.mapper.CollectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CollectService {

    @Autowired
    private CollectMapper collectMapper;

    public int collect(String userID, String literatureID, String title, int option, String year, String venue) throws Exception {
        if (option == 1) {
            collectMapper.addCollect(userID, literatureID, title, year, venue);
        } else {
            collectMapper.deleteCollect(userID, literatureID);
        }
        return 0;
    }

    public List<LiteraturePreview> getHighCollect() throws Exception {
        return collectMapper.getHighCollect();
    }
}
