package com.umc.dream.repository;

import com.umc.dream.domain.Follow;
import com.umc.dream.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FollowRepository extends JpaRepository<Follow, Long> {
    List<Follow> findAllByFollower_Id(Long memberId);

    Follow findByFollowerAndAcceptor(User follower, User acceptor);
}
