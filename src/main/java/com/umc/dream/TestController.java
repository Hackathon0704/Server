package com.umc.dream;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/health")
    public String healthCheck() {
        return "I'm healthy!";
    }

}
