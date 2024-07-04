package com.umc.dream.repository;

import com.umc.dream.domain.Dream;
import com.umc.dream.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DreamRepository extends JpaRepository<Dream, Long> {

}
