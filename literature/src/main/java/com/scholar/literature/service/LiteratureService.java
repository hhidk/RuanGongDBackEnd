package com.scholar.literature.service;

import com.scholar.literature.pojo.Literature;
import org.hibernate.validator.constraints.br.TituloEleitoral;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LiteratureService {

    public Literature getLiterature(int literatureID) {
        // TODO: 12/15/20
        return null;
    }

    public boolean editLiterature(int literatureID, String url) {
        // TODO: 12/15/20
        return false;
    }

    public boolean addLiterature(Literature obj) {
        // TODO: 12/15/20
        return false;
    }

    public boolean collectLiterature(String userID, String LiteratureID) {
        // TODO: 12/15/20
        return false;
    }
    public boolean commentLiterature(String userID,String LiteratureID,String content){
        // TODO: 12/15/20  
        return false;
    }
    public List<Literature> getMyLiterature(String userID) {
        // TODO: 12/15/20  
        return null;
    }
}
