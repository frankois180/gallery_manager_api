package com.wolox.gallery.application.service;


import com.wolox.gallery.application.dto.admin.AlbumAccessDto;
import com.wolox.gallery.domain.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class AdminAppService {

    private final AdminService adminService;

    @Transactional
    public Boolean enableAccessForUser(AlbumAccessDto albumAccessDto) {
        adminService.enableAccessForUser(albumAccessDto.getUserId(), albumAccessDto.getAlbumId(), albumAccessDto.getAccess());
        return true;

    }
}
