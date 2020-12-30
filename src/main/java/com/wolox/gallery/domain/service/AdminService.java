package com.wolox.gallery.domain.service;

import com.wolox.gallery.domain.model.album.Album;
import com.wolox.gallery.domain.model.album.AccessType;
import com.wolox.gallery.domain.model.user.User;
import com.wolox.gallery.domain.port.external.AlbumExternalPort;
import com.wolox.gallery.domain.port.external.UserExternalPort;
import com.wolox.gallery.domain.port.repository.AdminRepositoryPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AdminService {

    private final AdminRepositoryPort adminRepositoryPort;
    private final UserExternalPort userExternalPort;
    private final AlbumExternalPort albumExternalPort;

    public void enableAccessForUser(int userId, int albumId, AccessType accessType) {

        User userExternal = userExternalPort.findById(userId);
        Album albumExternal = albumExternalPort.findAlbumById(albumId);
        adminRepositoryPort.saveAccessForAlbum(userExternal, albumExternal, accessType);
    }
}
