package com.wolox.gallery.domain.port.external;

import com.wolox.gallery.domain.model.album.Photo;

import java.util.List;

public interface AlbumExternalPort {
    /**
     * method to obtain photos
     */
    List<Photo> findAllPhotos();
}
