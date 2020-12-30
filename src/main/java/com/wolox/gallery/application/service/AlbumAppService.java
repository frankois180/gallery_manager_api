package com.wolox.gallery.application.service;

import com.wolox.gallery.application.dto.album.AlbumDto;
import com.wolox.gallery.application.dto.album.PhotoDto;
import com.wolox.gallery.application.mapper.AlbumAppMapper;
import com.wolox.gallery.domain.model.album.Album;
import com.wolox.gallery.domain.model.album.Photo;
import com.wolox.gallery.domain.service.AlbumService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class AlbumAppService {

    private final AlbumService albumService;
    private final AlbumAppMapper albumAppMapper;

    public List<PhotoDto> findAllPhotos() {
        return albumService.findAllPhotos().stream()
                .map(albumAppMapper::domainPhotoToDtoPhoto).collect(Collectors.toList());

    }

    public List<PhotoDto> findAllPhotosByUserId(int userId) {
        return albumService.findAllPhotosByUserId(userId).stream()
                .map(albumAppMapper::domainPhotoToDtoPhoto).collect(Collectors.toList());

    }

    public List<AlbumDto> findAllAlbums() {
        return albumService.findAllAlbums()
                .stream().map(albumAppMapper::domainAlbumToDtoAlbum)
                .collect(Collectors.toList());
    }

    public AlbumDto findAlbumById(int albumId) {
        return albumAppMapper.domainAlbumToDtoAlbum(albumService.findAlbumById(albumId));
    }

}
