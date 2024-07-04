package com.umc.dream;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/health")
    @Operation(summary = "health check API",description = "인스턴스의 health check하는 API입니다")
    public String healthCheck() {
        return "I'm healthy!";
    }

}
