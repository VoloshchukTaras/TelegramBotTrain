package com.friend.service;

import com.friend.persistence.model.Friend;
import com.friend.persistence.repository.FriendReposirory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FriendServiceImpl implements FriendService {
    @Autowired
    private FriendReposirory friendReposirory;

    @Override
    public List<Friend> getObjects() {
        return friendReposirory.findAll();
    }
}
