package com.wolox.gallery.application.dto.album;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PhotoDto {

    private int id;

    @JsonIgnoreProperties({"user", "title"})
    private AlbumDto album;

    private String title;
    private String url;
    private String thumbnailUrl;

}
