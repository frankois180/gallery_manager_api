package com.wolox.gallery.application.mapper;

import com.wolox.gallery.application.dto.album.AlbumDto;
import com.wolox.gallery.application.dto.album.PhotoDto;
import com.wolox.gallery.domain.model.album.Album;
import com.wolox.gallery.domain.model.album.Photo;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface AlbumAppMapper {

    /**
     * Method that convert domain photo object to dto photo object
     */
    PhotoDto domainPhotoToDtoPhoto(Photo photo);

    /**
     * Method that convert domain album object to dto album object
     */
    AlbumDto domainAlbumToDtoAlbum(Album album);

}