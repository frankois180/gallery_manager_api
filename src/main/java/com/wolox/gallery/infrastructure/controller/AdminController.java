package com.wolox.gallery.infrastructure.controller;


import com.wolox.gallery.application.dto.admin.AlbumAccessDto;
import com.wolox.gallery.application.service.AdminAppService;
import com.wolox.gallery.infrastructure.controller.dto.ApiResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/admin")
@RequiredArgsConstructor
public class AdminController {

    private final AdminAppService adminAppService;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/album-access")
    public ResponseEntity<ApiResponseDto> enableAccessForUser(
            @RequestBody AlbumAccessDto albumAccessDto) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponseDto.builder()
                        .data(adminAppService.enableAccessForUser(albumAccessDto))
                        .build());
    }
}