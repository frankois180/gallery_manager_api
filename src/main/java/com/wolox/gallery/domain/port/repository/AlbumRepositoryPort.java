package com.wolox.gallery.domain.port.repository;

import com.wolox.gallery.domain.model.album.Album;

import java.util.List;

public interface AlbumRepositoryPort {
    /**
     * Method that obtain an album list by user id
     */
    List<Album> findByUserId(int userId);
}
