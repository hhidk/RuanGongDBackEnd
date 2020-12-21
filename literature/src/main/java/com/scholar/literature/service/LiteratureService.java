package com.scholar.literature.service;

import com.scholar.literature.controller.AuthorController;
import com.scholar.literature.pojo.Literature;
import org.elasticsearch.action.DocWriteResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.rest.RestStatus;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.hibernate.validator.constraints.br.TituloEleitoral;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LiteratureService {
    @Autowired
    RestHighLevelClient restHighLevelClient;

    private static final Logger log = LoggerFactory.getLogger(LiteratureService.class);

    public Map<String, Object> getLiterature(String literatureID) throws IOException {
        // TODO: 12/15/20
        log.info("In func: getLiterature Trying to get literature {}", literatureID);
        try {
            GetRequest getRequest = new GetRequest("literature", literatureID);
            GetResponse getResponse = restHighLevelClient.get(getRequest, RequestOptions.DEFAULT);
            Map<String, Object> map = getResponse.getSource();
            if (map == null) {
                log.info("source is null");
            }
            if (getResponse.isExists()) {
                log.info("In func: literature that id=" + literatureID + "is found");
                return new Literature(map).retGetmap();
            } else {
                log.info("In func: literature that id=" + literatureID + "is not found");
                return null;
            }
        } catch (Exception e) {
            log.error("Error getting literature id=" + literatureID);
            e.printStackTrace();
            return null;
        }
    }


    public boolean editLiterature(String literatureID, String url) {
        // TODO: 12/15/20
        log.info("In func:editLiterature : pdf={}", literatureID);
        try {
            Map<String, Object> jsonMap = new HashMap<>();
            jsonMap.put("pdf", url);
            UpdateRequest updateRequest = new UpdateRequest("literature", literatureID).doc(jsonMap);
            UpdateResponse response = restHighLevelClient.update(updateRequest, RequestOptions.DEFAULT);
            if (response.getResult() == DocWriteResponse.Result.UPDATED) {
                log.info("In func editLiterature : succeed");
                return true;
            } else if (response.getResult() == DocWriteResponse.Result.NOOP) {
                log.error("In func editLiterature :  failed for invalid literatureID");
                return false;
            }
        } catch (IOException e) {
            e.printStackTrace();
            log.error("In func editLiterature : updating failed ");
        }
        log.error("In func editLiterature :  failed , unknown Reason");
        return false;
    }

    public boolean addLiterature(Literature obj) {
        // TODO: 12/15/20

        return false;
    }

    public Map<String, Object> getRelation(String venue) {
        log.info("In func:getRelation : venue = {}", venue);
        Map<String, Object> ret = new HashMap<>();
        List<Map<String, Object>> relationList = new ArrayList<>();
        try {
            SearchRequest searchRequest = new SearchRequest("literature");
            SearchSourceBuilder sb = new SearchSourceBuilder().size(10000);
            sb.query(QueryBuilders.matchQuery("venue.raw", venue));
            SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
            SearchHits searchHits = searchResponse.getHits();
            for (SearchHit searchHit : searchHits) {
                log.info("get literature, ID = {} ", searchHit.getId());
                relationList.add(new Literature(
                        searchHit.getSourceAsMap())
                        .retRelationMap());
            }
            ret.put("relationList", relationList);
            return ret;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean deleteLiterature(String literatureID) {

        log.info("In fuc:deleteLiterature ID = {}", literatureID);
        try {
            DeleteRequest deleteRequest = new DeleteRequest("literature", literatureID);
            DeleteResponse deleteResponse = restHighLevelClient.delete(deleteRequest, RequestOptions.DEFAULT);
            if (deleteResponse.getResult() == DocWriteResponse.Result.DELETED) {
                log.info("delete succeed");
                return true;
            } else {
                log.error("delete failed");
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("delete failed,got exception");
            return false;
        }

    }


    public List<Map<String, Object>> getMyLiterature(String authorID) {
        try {
            List<Map<String, Object>> ret = new ArrayList<>();
            SearchRequest searchRequest = new SearchRequest("literature");
            SearchSourceBuilder sb = new SearchSourceBuilder().size(10000);
            sb.query(QueryBuilders.matchQuery("venue.raw", authorID));
            SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
            SearchHits searchHits = searchResponse.getHits();
            for (SearchHit searchHit : searchHits) {
                log.info("get literature, ID = {} ", searchHit.getId());
                ret.add(new Literature(
                        searchHit.getSourceAsMap())
                        .retGetMymap());
            }
            return ret;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Map<String, Object> getStats(String literatureID) throws Exception {
        List<Integer> collectTimes = new ArrayList<>();
        // List<Integer> readTimes = new ArrayList<>();
        List<Integer> commentTimes = new ArrayList<>();

        Map<String, Object> map = new HashMap<>();
        map.put("collectTimes", collectTimes);
        map.put("commentTimes", commentTimes);
        return map;
    }

}
