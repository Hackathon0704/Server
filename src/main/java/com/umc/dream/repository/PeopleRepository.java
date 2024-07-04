package com.umc.dream.repository;

import com.umc.dream.domain.People;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeopleRepository extends JpaRepository<People, Long> {
}
