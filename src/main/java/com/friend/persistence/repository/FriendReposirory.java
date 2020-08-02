package com.friend.persistence.repository;

import com.friend.persistence.model.Friend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FriendReposirory extends JpaRepository<Friend, Integer> {
}
