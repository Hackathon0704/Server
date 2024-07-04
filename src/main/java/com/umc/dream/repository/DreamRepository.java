package com.umc.dream.repository;

import com.umc.dream.domain.Dream;
import com.umc.dream.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DreamRepository extends JpaRepository<Dream, Long> {
    List<Dream> findAllByUser(User user);

    Optional<Dream> findByIdAndUser(Long dreamId, User user);
}
