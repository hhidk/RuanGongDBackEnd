package com.scholar.root.service;

import com.scholar.root.dto.GateApplication;
import com.scholar.root.mapper.ApplicationMapper;
import com.scholar.root.mapper.MessageMapper;
import com.scholar.root.mapper.UserMapper;
import com.scholar.root.pojo.Application;
import com.scholar.root.pojo.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ApplicationService
{
    @Autowired
    MessageMapper messageMapper;
    @Autowired
    ApplicationMapper applicationMapper;
    @Autowired
    UserMapper userMapper;

    public int approveApplication(int applicationID) {

        //置authorID
        Application application = applicationMapper.getApplicationByApplicationID(applicationID);
        Map<String, Object> map = new HashMap<>();
        map.put("userID", application.getUserID());
        map.put("authorID", application.getAuthorID());
        map.put("realName", application.getRealName());
        userMapper.setAuthor(map);

        //发消息
        Message message = new Message();
        message.setSenderID(application.getUserID());
        message.setReceiverID(application.getUserID());
        message.setViewed(false);
        message.setContent(application.getRealName());
        message.setType(6);
        messageMapper.addMessage(message);

        map = new HashMap<>();
        map.put("applicationID", applicationID);
        map.put("status", 1);
        applicationMapper.setApplicationStatus(map);

        return 1;
    }

    public int rejectApplication(int applicationID, String msgContent) {

        Application application = applicationMapper.getApplicationByApplicationID(applicationID);
        Message message = new Message();
        message.setSenderID(application.getUserID());
        message.setReceiverID(application.getUserID());
        message.setViewed(false);
        message.setContent(msgContent);
        message.setType(7);
        messageMapper.addMessage(message);

        Map<String, Object> map = new HashMap<>();
        map.put("applicationID", applicationID);
        map.put("status", 2);
        applicationMapper.setApplicationStatus(map);

        return 1;
    }

    public List<GateApplication> getAllGateApplication() {
        List<GateApplication> list = applicationMapper.getAllGateApplication();
        for(GateApplication gateApplication : list)
        {
            if (gateApplication.getContent().length() > 52)
            {
                gateApplication.setIsTrimmed(true);
                gateApplication.setTrimmedContent(gateApplication.getContent().substring(0, 50) + "...");
            }
        }
        return list;
    }

}
