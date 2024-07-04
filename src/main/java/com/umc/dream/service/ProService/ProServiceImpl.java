package com.umc.dream.service.ProService;

import com.umc.dream.domain.Post;
import com.umc.dream.dto.ProRequestDTO;

public interface ProServiceImpl {
    Post createProPost(ProRequestDTO.CreateRequestDTO request);
}
