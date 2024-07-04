package com.umc.dream.repository;

import com.umc.dream.domain.User;
import com.umc.dream.domain.enums.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByAccount(String account);
    Page<User> findByRole(Role role, PageRequest pageRequest);
}
