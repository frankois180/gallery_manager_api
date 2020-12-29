package com.wolox.gallery.domain.service;

import com.wolox.gallery.domain.model.album.Photo;
import com.wolox.gallery.domain.port.external.AlbumExternalPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class AlbumService {
    private final AlbumExternalPort albumExternalPort;

    public List<Photo> findAllPhotos() {
        return albumExternalPort.findAllPhotos();

    }
}
