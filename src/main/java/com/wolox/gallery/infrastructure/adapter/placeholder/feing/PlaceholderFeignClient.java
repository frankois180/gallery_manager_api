package com.wolox.gallery.infrastructure.adapter.placeholder.feing;

import com.wolox.gallery.infrastructure.adapter.placeholder.dto.album.AlbumResponse;
import com.wolox.gallery.infrastructure.adapter.placeholder.dto.album.PhotoResponse;
import com.wolox.gallery.infrastructure.adapter.placeholder.dto.param.IdParam;
import com.wolox.gallery.infrastructure.adapter.placeholder.dto.param.UserIdParam;
import com.wolox.gallery.infrastructure.adapter.placeholder.dto.user.UserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@FeignClient(name = "${feign.placeholder.name}", url = "${feign.placeholder.rootUrl}")
public interface PlaceholderFeignClient {

    /**
     * Method to get all users
     */
    @GetMapping(value = "${feign.placeholder.resources.users}", produces = APPLICATION_JSON_VALUE)
    List<UserResponse> findAllUsers();

    /**
     * Method to obtain all photos
     */
    @GetMapping(value = "${feign.placeholder.resources.photos}", produces = APPLICATION_JSON_VALUE)
    List<PhotoResponse> findAllPhotos();

    /**
     * Method that obtain a album list by user id
     */
    @GetMapping(value = "${feign.placeholder.resources.albums}", produces = APPLICATION_JSON_VALUE)
    List<AlbumResponse> findAllAlbumsByUserId(@SpringQueryMap UserIdParam userIdParam);

    /**
     * Method that obtain all albums
     */
    @GetMapping(value = "${feign.placeholder.resources.albums}", produces = APPLICATION_JSON_VALUE)
    List<AlbumResponse> findAllAlbums();

    /**
     * Method that obtain an album
     */
    @GetMapping(value = "${feign.placeholder.resources.albums}", produces = APPLICATION_JSON_VALUE)
    List<AlbumResponse> findAlbumById(@SpringQueryMap IdParam idParam);

    /**
     * Method to obtain a user
     */
    @GetMapping(value = "${feign.placeholder.resources.users}", produces = APPLICATION_JSON_VALUE)
    List<UserResponse> findUserById(@SpringQueryMap IdParam idParam);

}

