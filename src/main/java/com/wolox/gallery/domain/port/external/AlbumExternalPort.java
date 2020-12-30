package com.wolox.gallery.domain.port.external;

import com.wolox.gallery.domain.model.album.Album;
import com.wolox.gallery.domain.model.album.Photo;

import java.util.List;

public interface AlbumExternalPort {
    /**
     * method to obtain photos
     */
    List<Photo> findAllPhotos();

    /**
     * Method that obtain a album list by user id
     */
    List<Album> findAllAlbumsByUserId(int userId);

    /**
     * method to obtain albums
     */
    List<Album> findAllAlbums();

    /**
     * Method to obtain an album by id
     */
    Album findAlbumById(int albumId);


}
