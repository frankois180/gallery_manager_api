package com.wolox.gallery.infrastructure.controller;


import com.wolox.gallery.application.service.PostAppService;
import com.wolox.gallery.infrastructure.controller.dto.ApiResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/comments")
@RequiredArgsConstructor
public class PostController {

    private final PostAppService postAppService;

    @GetMapping
    public ApiResponseDto findAllComments() {
        return ApiResponseDto.builder()
                .data(postAppService.findAllComments())
                .build();

    }

    @GetMapping("/{name}")
    public ApiResponseDto finAllCommentsByName(@PathVariable String name) {
        return ApiResponseDto.builder()
                .data(postAppService.finAllCommentsByName(name))
                .build();

    }

    @GetMapping("user-id/{userId}")
    public ApiResponseDto findAllCommentsByUserId(@PathVariable int userId) {
        return ApiResponseDto.builder()
                .data(postAppService.findAllCommentsByUserId(userId))
                .build();

    }

}
