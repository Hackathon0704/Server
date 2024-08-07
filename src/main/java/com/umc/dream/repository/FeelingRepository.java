package com.umc.dream.repository;

import com.umc.dream.domain.Dream;
import com.umc.dream.domain.Feeling;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FeelingRepository extends JpaRepository<Feeling, Long> {
    Feeling findFirstByDream(Dream dream);
    List<Feeling> findAllByDream(Dream dream);
}
