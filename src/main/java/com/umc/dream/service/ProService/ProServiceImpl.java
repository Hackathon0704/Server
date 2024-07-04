package com.umc.dream.service.ProService;

import com.umc.dream.domain.Post;
import com.umc.dream.dto.ProRequestDTO;

import java.util.List;

public interface ProServiceImpl {
    Post createProPost(ProRequestDTO.CreateRequestDTO request);

    List<Post> getAllProPostList(Long userId);
}
