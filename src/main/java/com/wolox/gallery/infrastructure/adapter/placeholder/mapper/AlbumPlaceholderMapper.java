package com.wolox.gallery.infrastructure.adapter.placeholder.mapper;


import com.wolox.gallery.domain.model.album.Album;
import com.wolox.gallery.domain.model.album.Photo;
import com.wolox.gallery.infrastructure.adapter.placeholder.dto.album.AlbumResponse;
import com.wolox.gallery.infrastructure.adapter.placeholder.dto.album.PhotoResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface AlbumPlaceholderMapper {

    /**
     * Method that convert response photo object to domain photo object
     */
    @Mapping(target = "album.id", source = "albumId")
    Photo responsePhotoToDomainPhoto(PhotoResponse photoResponse);

    /**
     * Method that convert response album object to domain album object
     */
    @Mapping(target = "user.id", source = "userId")
    Album responseAlbumToDomainAlbum(AlbumResponse albumResponse);

}
