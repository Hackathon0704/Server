package com.umc.dream.repository;

import com.umc.dream.domain.Dream;
import com.umc.dream.domain.Place;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaceRepository extends JpaRepository<Place, Long> {
    Place findFirstByDream(Dream dream);
}
