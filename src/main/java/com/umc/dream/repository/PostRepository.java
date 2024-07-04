package com.umc.dream.repository;

import com.umc.dream.domain.Post;
import com.umc.dream.domain.enums.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PostRepository extends JpaRepository<Post, Long> {

    @Query("select p from Post p join fetch p.writer where p.type = :type")
    Page<Post> findAllByTypeJoinFetch(Type type, PageRequest pageRequest);

}
