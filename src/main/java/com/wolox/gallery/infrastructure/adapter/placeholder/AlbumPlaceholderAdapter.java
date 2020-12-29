package com.wolox.gallery.infrastructure.adapter.placeholder;


import com.wolox.gallery.domain.model.album.Album;
import com.wolox.gallery.domain.model.album.Photo;
import com.wolox.gallery.domain.port.external.AlbumExternalPort;
import com.wolox.gallery.infrastructure.adapter.placeholder.delegate.PlaceholderDelegate;
import com.wolox.gallery.infrastructure.adapter.placeholder.mapper.AlbumPlaceholderMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class AlbumPlaceholderAdapter implements AlbumExternalPort {

    private final PlaceholderDelegate placeholderDelegate;
    private final AlbumPlaceholderMapper albumPlaceholderMapper;

    @Override
    public List<Photo> findAllPhotos() {

        return placeholderDelegate.findAllPhotos().stream()
                .map(albumPlaceholderMapper::responsePhotoToDomainPhoto)
                .collect(Collectors.toList());

    }


    @Override
    public List<Album> findAllAlbumsByUserId(int userId) {

        return placeholderDelegate.findAllAlbumsByUserId(userId).stream()
                .map(albumPlaceholderMapper::responseAlbumToDomainAlbum)
                .collect(Collectors.toList());

    }


}