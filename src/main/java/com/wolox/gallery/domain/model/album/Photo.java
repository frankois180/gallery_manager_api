package com.wolox.gallery.domain.model.album;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Photo {

    private int id;
    private Album album;
    private String title;
    private String url;
    private String thumbnailUrl;

}
