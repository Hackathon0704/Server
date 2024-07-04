package com.umc.dream.repository;

import com.umc.dream.domain.Dream;
import com.umc.dream.domain.Hashtag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HashtagRepository extends JpaRepository<Hashtag, Long> {
    Hashtag findFirstByDream(Dream dream);
}
