package com.wolox.gallery.infrastructure.adapter.placeholder.dto.album;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AlbumResponse {

    private int id;
    private int userId;
    private String title;

}