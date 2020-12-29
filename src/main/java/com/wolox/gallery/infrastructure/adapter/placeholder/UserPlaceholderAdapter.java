package com.wolox.gallery.infrastructure.adapter.placeholder;

import com.wolox.gallery.domain.model.user.User;
import com.wolox.gallery.domain.port.external.UserExternalPort;
import com.wolox.gallery.infrastructure.adapter.placeholder.delegate.PlaceholderDelegate;
import com.wolox.gallery.infrastructure.adapter.placeholder.mapper.UserPlaceholderMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class UserPlaceholderAdapter implements UserExternalPort {

    private final PlaceholderDelegate placeholderClientDelegate;
    private final UserPlaceholderMapper userPlaceholderMapper;

    @Override
    public List<User> findAll() {

        return placeholderClientDelegate.findAllUsers().stream()
                .map(userPlaceholderMapper::responseToDomain)
                .collect(Collectors.toList());

    }
}
