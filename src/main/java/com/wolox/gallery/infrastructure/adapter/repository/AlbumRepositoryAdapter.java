package com.wolox.gallery.infrastructure.adapter.repository;


import com.wolox.gallery.domain.model.album.Album;
import com.wolox.gallery.domain.port.repository.AlbumRepositoryPort;
import com.wolox.gallery.infrastructure.adapter.repository.jpa.AlbumJpaRepository;
import com.wolox.gallery.infrastructure.adapter.repository.mapper.AlbumRepositoryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class AlbumRepositoryAdapter implements AlbumRepositoryPort {

    private final AlbumJpaRepository albumJpaRepository;
    private final AlbumRepositoryMapper albumRepositoryMapper;

    @Override
    public List<Album> findByUserId(int userId) {

        return albumJpaRepository.findByUserId(Integer.valueOf(userId).longValue()).stream()
                .map(albumRepositoryMapper::entityToDomain)
                .collect(Collectors.toList());

    }
}