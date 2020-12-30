package com.wolox.gallery.infrastructure.controller;

import com.wolox.gallery.application.service.UserAppService;
import com.wolox.gallery.infrastructure.controller.dto.ApiResponseDto;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserAppService userAppService;

    @GetMapping
    public ApiResponseDto findAll() {
        return ApiResponseDto.builder()
                .data(userAppService.findAll())
                .build();
    }
}
