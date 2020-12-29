package com.wolox.gallery.infrastructure.adapter.placeholder.delegate;

import com.wolox.gallery.infrastructure.adapter.placeholder.dto.UserDto;
import com.wolox.gallery.infrastructure.adapter.placeholder.feing.PlaceholderFeignClient;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PlaceholderDelegate {

    private final PlaceholderFeignClient placeholderFeignClient;

    public PlaceholderDelegate(PlaceholderFeignClient placeholderFeignClient) {
        this.placeholderFeignClient = placeholderFeignClient;
    }

    public List<UserDto> findAllUsers() {
        return placeholderFeignClient.findAllUsers();
    }
}
