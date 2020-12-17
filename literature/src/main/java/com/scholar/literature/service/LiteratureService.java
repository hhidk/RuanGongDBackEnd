package com.scholar.literature.service;

import com.scholar.literature.controller.AuthorController;
import com.scholar.literature.pojo.Literature;
import org.elasticsearch.action.DocWriteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.hibernate.validator.constraints.br.TituloEleitoral;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LiteratureService {
    @Autowired
    RestHighLevelClient restHighLevelClient;

    private static final Logger log = LoggerFactory.getLogger(LiteratureService.class);


    public Literature getLiterature(String literatureID) throws IOException {
        // TODO: 12/15/20
        log.info("In func: getLiterature Trying to get literature {}",literatureID);
        try {
            GetRequest getRequest = new GetRequest("literature",literatureID);
            GetResponse getResponse = restHighLevelClient.get(getRequest, RequestOptions.DEFAULT);
            Map<String,Object> source ;
            if (getResponse.isExists()){
                log.info("In func: literature that id="+literatureID+"is found");
                return  new Literature(getResponse.getSourceAsMap());
            }else {
                log.info("In func: literature that id="+literatureID+"is not found");
                return null;
            }
        }catch (Exception e){
            log.error("Error getting literature id="+literatureID);
            return null;
        }
    }


    public boolean editLiterature(String literatureID, String url) {
        // TODO: 12/15/20
        log.info("In func:editLiterature : Trying to update url {}",literatureID);
        try {  Map<String,Object>jsonMap =new HashMap<>();
            List<String>l=List.of(url);
            jsonMap.put("url",l);
            UpdateRequest updateRequest = new UpdateRequest("literature",literatureID).doc(jsonMap);
            UpdateResponse response = restHighLevelClient.update(updateRequest,RequestOptions.DEFAULT);
            if (response.getResult() ==DocWriteResponse.Result.UPDATED){
                log.info("In func editLiterature : updating successfully");
             return true;
            }else if (response.getResult()==DocWriteResponse.Result.NOOP){
             log.error("In func editLiterature : updating failed , reason : invalid DSL");
             return false ;
            }
        } catch (IOException e) {
            e.printStackTrace();
            log.error("In func editLiterature : updating failed , reason : IOException");
        }
        log.error("In func editLiterature : updating failed , reason : unknown");
        return false;
    }

    public boolean addLiterature(Literature obj) {
        // TODO: 12/15/20



        return false;
    }

    public List<Literature> getMyLiterature(String userID) {
        // TODO: 12/15/20

        return null;
    }

}
