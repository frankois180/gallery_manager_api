package com.wolox.gallery.infrastructure.adapter.placeholder.feing;

import com.wolox.gallery.infrastructure.adapter.placeholder.dto.album.PhotoResponse;
import com.wolox.gallery.infrastructure.adapter.placeholder.dto.user.UserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@FeignClient(
        name = "${feign.placeholder.name}", url = "${feign.placeholder.rootUrl}"
)
public interface PlaceholderFeignClient {

    /**
     * Method to get all users
     */
    @GetMapping(
            value = "${feign.placeholder.resources.users}", produces = APPLICATION_JSON_VALUE
    )
    List<UserResponse> findAllUsers();

    /**
     * Method to obtain all photos
     */
    @GetMapping(
            value = "${feign.placeholder.resources.photos}", produces = APPLICATION_JSON_VALUE
    )
    List<PhotoResponse> findAllPhotos();

}

