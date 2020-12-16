package com.scholar.literature.service;

import com.scholar.literature.controller.AuthorController;
import com.scholar.literature.pojo.Literature;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.hibernate.validator.constraints.br.TituloEleitoral;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
public class LiteratureService {
    @Autowired
    RestHighLevelClient restHighLevelClient;

    private static final Logger log = LoggerFactory.getLogger(LiteratureService.class);


    public Literature getLiterature(String literatureID) throws IOException {
        // TODO: 12/15/20
        log.info("Trying to get literature {}",literatureID);
        try {
            GetRequest getRequest = new GetRequest("literature",literatureID);
            GetResponse getResponse = restHighLevelClient.get(getRequest, RequestOptions.DEFAULT);
            Map<String,Object> source ;
            if (getResponse.isExists()){
                source =getResponse.getSourceAsMap();
            }
            return null;
        }catch (Exception e){
            return null;
        }
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
