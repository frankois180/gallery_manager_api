package com.wolox.gallery.application.dto.album;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.wolox.gallery.application.dto.user.UserDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AlbumDto {

    private int id;

    @JsonIgnoreProperties({
            "name", "username", "email", "phone", "website", "address"})
    private UserDto user;

    private String title;

}