package com.wolox.gallery.domain.port.external;

import com.wolox.gallery.domain.model.user.User;

import java.util.List;

public interface UserExternalPort {
    List<User> findAll();
}
