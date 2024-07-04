package com.umc.dream.service;

import com.umc.dream.domain.Post;
import com.umc.dream.dto.PostRequestDTO;

public interface PostCommandService {

    Post createCommunityPost(PostRequestDTO.CreateCommunityDTO request);
}
