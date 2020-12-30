package com.wolox.gallery.application.dto.post;

import com.wolox.gallery.application.dto.user.UserDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostDto {

    private int id;
    private UserDto user;
    private String title;
    private String body;

}