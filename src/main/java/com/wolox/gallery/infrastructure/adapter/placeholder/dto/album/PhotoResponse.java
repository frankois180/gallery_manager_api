package com.wolox.gallery.infrastructure.adapter.placeholder.dto.album;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PhotoResponse {

    private int id;
    private int albumId;
    private String title;
    private String url;
    private String thumbnailUrl;

}