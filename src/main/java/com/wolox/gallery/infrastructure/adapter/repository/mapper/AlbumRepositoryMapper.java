package com.wolox.gallery.infrastructure.adapter.repository.mapper;

import com.wolox.gallery.domain.model.album.Access;
import com.wolox.gallery.domain.model.album.Album;
import com.wolox.gallery.infrastructure.adapter.repository.entity.AccessEntity;
import com.wolox.gallery.infrastructure.adapter.repository.entity.AlbumEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface AlbumRepositoryMapper {

    /**
     * Method that convert domain object to entity object
     */
    AlbumEntity domainToEntity(Album album);

    /**
     * Method that convert entity object to domain object
     */
    @Mapping(target = "user.rol", ignore = true)
    Album entityToDomain(AlbumEntity albumEntity);

    /**
     * Method that convert entity object to domain object
     */
    List<Access> accessEntityListToAccessDomainList(List<AccessEntity> accessEntityEntityList);

    /**
     * Method that convert entity object to domain object
     */
    @Mapping(target = "type", source = "name")
    Access accessEntityToAccessDomain(AccessEntity accessEntity);

}