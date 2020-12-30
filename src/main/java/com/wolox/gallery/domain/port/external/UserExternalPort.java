package com.wolox.gallery.domain.port.external;

import com.wolox.gallery.domain.model.user.User;

import java.util.List;

public interface UserExternalPort {

    /**
     * Method that obtain all user
     */
    List<User> findAll();

    /**
     * Method that obtain a user by id from external service
     */
    User findById(int userId);

}
