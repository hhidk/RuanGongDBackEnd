package com.scholar.literature.service;

import com.scholar.literature.mapper.UserMapper;
import com.scholar.literature.pojo.Author;
import com.scholar.literature.pojo.Literature;
import com.scholar.literature.pojo.User;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class GateService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RestHighLevelClient restHighLevelClient;
    private static final Logger log = LoggerFactory.getLogger(GateService.class);
    public User getAuthorInformation(String authorID) {
        User user = userMapper.getUserByAuthorID();
        if (user == null) {
            // todo: 在author表中查找authorID对应的author，并把信息填入User类。
            user = new User(0);
            log.info("In func: getAuthorInformation Trying to get literature {}", authorID);
            try {
                GetRequest getRequest = new GetRequest("authors", authorID);
                GetResponse getResponse = restHighLevelClient.get(getRequest, RequestOptions.DEFAULT);
                Map<String, Object> map = getResponse.getSource();
                if (map == null) {
                    log.info("source is null");
                    return user;
                }
                if (getResponse.isExists()) {
                    log.info("In func: author that id=" + authorID + "is found");
                    Author author=  new Author(map);
                    user.setAuthorID(author.getId());
                    user.setOrganization(author.getOrgs());
                    user.setRealName(author.getName());
                } else {
                    log.info("In func: literature that id=" + authorID + "is not found");
                    return null;
                }
            } catch (Exception e) {
                log.error("Error getting literature id=" + authorID);
                e.printStackTrace();
                return null;
            }
        }
        return user;
    }

}
