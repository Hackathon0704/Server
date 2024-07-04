package com.umc.dream.repository;

import com.umc.dream.domain.Dream;
import com.umc.dream.domain.People;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PeopleRepository extends JpaRepository<People, Long> {
    People findFirstByDream(Dream dream);
    List<People> findAllByDream(Dream dream);
}
