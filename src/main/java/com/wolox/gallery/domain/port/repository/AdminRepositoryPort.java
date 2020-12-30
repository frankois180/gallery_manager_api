package com.wolox.gallery.domain.port.repository;


import com.wolox.gallery.domain.model.album.Album;
import com.wolox.gallery.domain.model.album.AccessType;
import com.wolox.gallery.domain.model.user.User;

public interface AdminRepositoryPort {

    /**
     * Method that save access for the album with its user
     */
    void saveAccessForAlbum(User user, Album album, AccessType accessType);

}
