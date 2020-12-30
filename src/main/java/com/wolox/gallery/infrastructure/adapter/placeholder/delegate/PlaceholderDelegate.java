package com.wolox.gallery.infrastructure.adapter.placeholder.delegate;

import com.wolox.gallery.infrastructure.adapter.placeholder.dto.album.AlbumResponse;
import com.wolox.gallery.infrastructure.adapter.placeholder.dto.album.PhotoResponse;
import com.wolox.gallery.infrastructure.adapter.placeholder.dto.param.IdParam;
import com.wolox.gallery.infrastructure.adapter.placeholder.dto.param.UserIdParam;
import com.wolox.gallery.infrastructure.adapter.placeholder.dto.user.UserResponse;
import com.wolox.gallery.infrastructure.adapter.placeholder.feing.PlaceholderFeignClient;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PlaceholderDelegate {

    private final PlaceholderFeignClient placeholderFeignClient;

    public PlaceholderDelegate(PlaceholderFeignClient placeholderFeignClient) {
        this.placeholderFeignClient = placeholderFeignClient;
    }

    public List<UserResponse> findAllUsers() {
        return placeholderFeignClient.findAllUsers();
    }

    public List<PhotoResponse> findAllPhotos() {
        return placeholderFeignClient.findAllPhotos();
    }

    public List<AlbumResponse> findAllAlbumsByUserId(int userId) {

        UserIdParam userIdQueryParam = new UserIdParam(userId);
        return placeholderFeignClient.findAllAlbumsByUserId(userIdQueryParam);

    }

    public List<AlbumResponse> findAllAlbums() {
        return placeholderFeignClient.findAllAlbums();
    }

    public List<AlbumResponse> findAlbumById(int albumId) {

        IdParam queryParam = new IdParam(albumId);
        return placeholderFeignClient.findAlbumById(queryParam);

    }
}
