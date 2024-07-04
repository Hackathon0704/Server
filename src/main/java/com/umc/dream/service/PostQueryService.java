package com.umc.dream.service;


import com.umc.dream.domain.Post;
import org.springframework.data.domain.Page;

public interface PostQueryService {
    Page<Post> getCommunityPostList(Integer page);
}
