package com.umc.dream.repository;

import com.umc.dream.domain.Post;
import com.umc.dream.domain.enums.Type;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllByWriterIdAndType(Long userId, Type type);
    
    @Query("select p from Post p join fetch p.writer where p.type = :type")
    Page<Post> findAllByTypeJoinFetch(Type type, PageRequest pageRequest);
}
