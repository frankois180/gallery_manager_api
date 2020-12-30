package com.wolox.gallery.infrastructure.controller;

import com.wolox.gallery.application.service.AlbumAppService;
import com.wolox.gallery.infrastructure.controller.dto.ApiResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/albums")

@RequiredArgsConstructor
public class AlbumController {

    private final AlbumAppService albumAppService;

    @GetMapping("/photos")
    public ApiResponseDto findAllPhotos() {

        return ApiResponseDto.builder()
                .data(albumAppService.findAllPhotos())
                .build();

    }

    @GetMapping("/photos/{userId}")
    public ApiResponseDto findAllPhotosByUserId(@PathVariable(value = "userId") Integer userId) {

        return ApiResponseDto.builder()
                .data(albumAppService.findAllPhotosByUserId(userId))
                .build();

    }

    @GetMapping
    public ApiResponseDto findAllAlbums() {

        return ApiResponseDto.builder()
                .data(albumAppService.findAllAlbums())
                .build();
    }

    @GetMapping("/{userId}")
    public ApiResponseDto findAlbumById(@PathVariable int userId) {
        return ApiResponseDto.builder()
                .data(albumAppService.findAllAlbumsByUserId(userId))
                .build();
    }
}
