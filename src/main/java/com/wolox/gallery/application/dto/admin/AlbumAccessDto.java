package com.wolox.gallery.application.dto.admin;


import com.wolox.gallery.domain.model.album.AccessType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class AlbumAccessDto {

    private int userId;
    private int albumId;
    private AccessType access;

}