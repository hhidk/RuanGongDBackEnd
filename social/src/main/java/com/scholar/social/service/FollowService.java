package com.scholar.social.service;

import com.scholar.social.repository.FollowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FollowService {
    private final FollowRepository followRepository;

    @Autowired
    public FollowService(FollowRepository followRepository) {
        this.followRepository = followRepository;
    }

    public boolean get(String userId, int sectorId) {
        int res = followRepository.get(userId, sectorId);
        return res != 0;
    }

    public boolean set(String userId, int sectorId) {
        if (followRepository.get(userId, sectorId) != 0) {
            followRepository.unset(userId, sectorId);
        } else {
            followRepository.set(userId, sectorId);
        }
        return true;
    }
}
