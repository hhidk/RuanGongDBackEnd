package com.scholar.profile.service;

import com.scholar.profile.mapper.ApplicationMapper;
import com.scholar.profile.mapper.ReportMapper;
import com.scholar.profile.mapper.UserMapper;
import com.scholar.profile.pojo.Application;
import com.scholar.profile.pojo.Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GateService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ApplicationMapper applicationMapper;
    @Autowired
    private ReportMapper reportMapper;

    public int followUser(String followerID, String userID, int option) throws Exception {
        if (option == 1) {
            userMapper.addFollow(followerID, userID);
        } else {
            userMapper.deleteFollow(followerID, userID);
        }
        return 0;
    }

    public int apply(String userID, String authorID, String realName, String emailAddress, String content) throws Exception {
        if (userMapper.checkIsAuthor(userID) != null) {
            return 2;
        }
        if (applicationMapper.getUserPendingApplication(userID) != null) {
            return 1;
        }
        Application application = new Application(userID, authorID, realName, emailAddress, content);
        applicationMapper.addApplication(application);
        return 0;
    }

    public int getApplyStatus(String userID) throws Exception {
        return applicationMapper.getUserRecentApplication(userID).getStatus();
    }

    public int reportGate(String userID, String authorID, String content) throws Exception {
        Report report = new Report(userID, authorID, content);
        report.setType(4);
        report.setStatus(0);
        reportMapper.addReport(report);
        return 0;
    }

    public int getIntroFollowStatus(String followerID, String authorID) throws Exception {
        String myAuthorID = userMapper.checkIsAuthor(followerID);
        String userID = userMapper.checkIsUser(authorID);
        if (myAuthorID != null && myAuthorID.equals(authorID)) {
            return 0;
        }
        if (userID == null) {
            return 3;
        }
        String flag = userMapper.checkIsFollowed(followerID, userID);
        if (flag != null) {
            return 1;
        } else {
            return 2;
        }
    }

}
