package com.scholar.literature.service;

import com.scholar.literature.controller.AuthorController;
import com.scholar.literature.mapper.CollectMapper;
import com.scholar.literature.mapper.CommentMapper;
import com.scholar.literature.mapper.UserMapper;
import com.scholar.literature.pojo.Literature;
import com.scholar.literature.pojo.User;
import org.elasticsearch.action.DocWriteResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.Index;
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
import java.util.*;

@Service
public class LiteratureService {
    @Autowired
    RestHighLevelClient restHighLevelClient;
    @Autowired
    CollectMapper collectMapper;
    @Autowired
    CommentMapper commentMapper;
    @Autowired
    UserMapper userMapper;


    private static final Logger log = LoggerFactory.getLogger(LiteratureService.class);

    public Map<String, Object> getLiterature(String literatureID) {
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
    public  List<Map<String,Object>> getHighCitation() throws IOException {
        List<Map<String,Object>> ret= new ArrayList<>();
        List<String>ids=new ArrayList<>();
        ids.add("53e9b8f5b7602d97044da476");
        ids.add("53e9bb52b7602d9704790954");
        ids.add("53e9b4d4b7602d9703ff7208");
        ids.add("53e9bcc1b7602d97049412d4");
        ids.add("53e99d73b7602d970262b052");
        ids.add("53e9b46ab7602d9703f6d1d0");
        ids.add("53e99808b7602d970201a17e");
        ids.add("53e9afe8b7602d9703a3af5a");
        ids.add("53e9aa8eb7602d9703409cfe");
        ids.add("53e9ad33b7602d970371729e");
        for (String id : ids) {
            log.info("getCitation, try to get id= {}",id);
            GetRequest getRequest = new GetRequest("literature", id);
            GetResponse getResponse = restHighLevelClient.get(getRequest, RequestOptions.DEFAULT);
            Map<String, Object> map = getResponse.getSource();
            if (getResponse.isExists()) {
                log.info("literature got = {}",id);
                ret.add(new Literature(map).retGetMymap());
            }
        }
        return ret;
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

    public int addLiterature(Map<String,Object> map,String userID) {
        User user = userMapper.getUserByUserID(userID);
        log.info("try to add new Literature");
        List<Map<String,Object>>authors = new ArrayList<>();
        Map<String,Object>author =new HashMap<>();
        author.put("id",user.getAuthorID());
        author.put("name", user.getRealName());
        authors.add(author);
        Map<String,Object>venue = new HashMap<>();
        venue.put("raw",map.get("raw"));
        Map<String,Object> jsonMap = new HashMap<>();

        jsonMap.put("abstract",map.get("abstract"));
        jsonMap.put("pdf",map.get("url"));
        jsonMap.put("authors",authors);
        jsonMap.put("venue",venue);
        jsonMap.put("title",map.get("title"));
        jsonMap.put("year",Integer.parseInt((String)map.get("year")));
        jsonMap.put("n_citation",Integer.parseInt((String) map.get("citation")));
        IndexRequest indexRequest = new IndexRequest("literature");
        indexRequest.source(jsonMap);
        try {
            IndexResponse response=restHighLevelClient.index(indexRequest,RequestOptions.DEFAULT);
            if (response.getResult()== DocWriteResponse.Result.CREATED){
                log.info("created successfully");
                return 0;
            }else {
                log.error("create failed,resutl is {}",response.status());
                return -1;
            }
        }catch (IOException e){
            e.printStackTrace();
            log.error("create failed");
            return -1;
        }
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

    public Map<String, Object> getStats(String literatureID) {
        List<Integer> collectTimes = new ArrayList<>();
        // List<Integer> readTimes = new ArrayList<>();
        List<Integer> commentTimes = new ArrayList<>();

        int curMonth = Calendar.getInstance().get(Calendar.MONTH) + 1;
        Map<String, Object> param = new HashMap<>();
        param.put("literatureID", literatureID);

        for(int i = 11; i >= 0; i--)
        {
            param.put("diff", i);
            collectTimes.add(collectMapper.getCollectCount(param));
            commentTimes.add(commentMapper.getCommentCount(param));
        }

        Map<String, Object> map = new HashMap<>();
        map.put("collectTimes", collectTimes);
        map.put("commentTimes", commentTimes);
        return map;
    }

}
