package com.wolox.gallery.infrastructure.controller;

import com.wolox.gallery.application.service.AlbumAppService;
import com.wolox.gallery.infrastructure.controller.dto.ApiResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")

@AllArgsConstructor
public class AlbumController {

    private final AlbumAppService albumAppService;

    @GetMapping("/photos")
    public ApiResponseDto findAllPhotos() {

        return ApiResponseDto.builder()
                .data(albumAppService.findAllPhotos())
                .build();

    }

    @GetMapping("/photos/{idUser}")
    public ApiResponseDto findAllPhotosByUserId(@PathVariable Integer userId) {

        return ApiResponseDto.builder()
                .data(albumAppService.findAllPhotosByUserId(userId))
                .build();

    }
}
