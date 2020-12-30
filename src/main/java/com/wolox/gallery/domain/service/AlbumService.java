package com.wolox.gallery.domain.service;

import com.wolox.gallery.domain.exception.DataNotFoundException;
import static com.wolox.gallery.domain.exception.GalleryNotificationCode.DATA_NOT_FOUND;
import com.wolox.gallery.domain.model.album.Album;
import com.wolox.gallery.domain.model.album.Photo;
import com.wolox.gallery.domain.port.external.AlbumExternalPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class AlbumService {
    private final AlbumExternalPort albumExternalPort;

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
}
