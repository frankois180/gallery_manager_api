package com.wolox.gallery.infrastructure.adapter.placeholder.feing;

import com.wolox.gallery.infrastructure.adapter.placeholder.dto.UserDto;
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
    List<UserDto> findAllUsers();

}

