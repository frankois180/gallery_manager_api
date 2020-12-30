package com.wolox.gallery.domain.service;

import com.wolox.gallery.domain.exception.DataNotFoundException;

import static com.wolox.gallery.domain.exception.GalleryNotificationCode.ALBUM_DATA_NOT_FOUND;
import static com.wolox.gallery.domain.exception.GalleryNotificationCode.DATA_NOT_FOUND;

import com.wolox.gallery.domain.model.album.AccessType;
import com.wolox.gallery.domain.model.album.Album;
import com.wolox.gallery.domain.model.album.Photo;
import com.wolox.gallery.domain.port.external.AlbumExternalPort;
import com.wolox.gallery.domain.port.repository.AlbumRepositoryPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class AlbumService {
    private final AlbumExternalPort albumExternalPort;
    private final AlbumRepositoryPort albumRepositoryPort;

    public List<Photo> findAllPhotos() {
        return albumExternalPort.findAllPhotos();

    }

    public List<Photo> findAllPhotosByUserId(int userId) {

        List<Album> albumList = albumExternalPort.findAllAlbumsByUserId(userId);

        List<Photo> photoList = albumExternalPort.findAllPhotos().stream()
                .filter(photo -> albumList.stream()
                        .anyMatch(album -> album.getId() == photo.getAlbum().getId()))
                .collect(Collectors.toList());

        if (photoList.isEmpty()) {
            throw new DataNotFoundException(DATA_NOT_FOUND);
        }
        return photoList;

    }

    public List<Album> findAllAlbums() {
        return albumExternalPort.findAllAlbums();
    }

    public Album findAlbumById(int albumId) {
        return albumExternalPort.findAlbumById(albumId);
    }

    public List<Album> findAllAlbumsByUserId(int userId) {

        List<Album> albumListWithPermission = albumRepositoryPort.findByUserId(userId);

        List<Album> albumListExternal = albumExternalPort.findAllAlbumsByUserId(userId).stream()
                .filter(albumExternal -> albumListWithPermission.stream()
                        .anyMatch(albumWithAccess -> albumWithAccess.getId() == albumExternal.getId()
                                && validAccess(albumWithAccess)))
                .collect(Collectors.toList());

        if (albumListExternal.isEmpty()) {
            throw new DataNotFoundException(ALBUM_DATA_NOT_FOUND);
        }

        return albumListExternal;

    }

    private boolean validAccess(Album albumWithAccess) {

        boolean isValid = false;

        if (!albumWithAccess.getAccess().isEmpty()) {
            isValid = albumWithAccess.getAccess().stream()
                    .anyMatch(access -> access.getType().equals(AccessType.READ));
        }
        return isValid;

    }

    private boolean validAlbums(Album albumExternal, Album albumWithAccess) {

        return albumWithAccess.getId() == albumExternal.getId();

    }
}
