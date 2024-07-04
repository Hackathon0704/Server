package com.umc.dream.repository;

import com.umc.dream.domain.Post;
import com.umc.dream.domain.enums.Type;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllByWriterIdAndType(Long userId, Type type);
}
