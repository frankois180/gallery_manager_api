package com.wolox.gallery.infrastructure.adapter.repository;

import com.wolox.gallery.domain.model.album.AccessType;
import com.wolox.gallery.domain.model.album.Album;
import com.wolox.gallery.domain.model.user.User;
import com.wolox.gallery.domain.port.repository.AdminRepositoryPort;
import com.wolox.gallery.infrastructure.adapter.repository.entity.AlbumEntity;
import com.wolox.gallery.infrastructure.adapter.repository.entity.UserEntity;
import com.wolox.gallery.infrastructure.adapter.repository.jpa.AccessJpaRepository;
import com.wolox.gallery.infrastructure.adapter.repository.jpa.AlbumJpaRepository;
import com.wolox.gallery.infrastructure.adapter.repository.jpa.UserJpaRepository;
import com.wolox.gallery.infrastructure.adapter.repository.mapper.AlbumRepositoryMapper;
import com.wolox.gallery.infrastructure.adapter.repository.mapper.UserRepositoryMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashSet;

import static java.util.Collections.singletonList;

@Component
@AllArgsConstructor
public class AdminRepositoryAdapter implements AdminRepositoryPort {


    private final UserJpaRepository userJpaRepository;
    private final AlbumJpaRepository albumJpaRepository;
    private final AccessJpaRepository accessJpaRepository;
    private final UserRepositoryMapper userRepositoryMapper;
    private final AlbumRepositoryMapper albumRepositoryMapper;

    @Override
    public void saveAccessForAlbum(User user, Album album, AccessType accessType) {

        UserEntity userEntity = userRepositoryMapper.domainToEntity(user);
        userJpaRepository.save(userEntity);

        AlbumEntity albumEntity = albumRepositoryMapper.domainToEntity(album);
        albumEntity.setUser(userEntity);
        albumEntity.setAccess(new HashSet<>(singletonList(accessJpaRepository
                .findByName(accessType.name()))));
        albumJpaRepository.save(albumEntity);

    }
}
