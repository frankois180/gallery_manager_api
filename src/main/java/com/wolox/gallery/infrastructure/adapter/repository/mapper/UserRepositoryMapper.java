package com.wolox.gallery.infrastructure.adapter.repository.mapper;

import com.wolox.gallery.domain.model.user.User;
import com.wolox.gallery.infrastructure.adapter.repository.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UserRepositoryMapper {

    /**
     * Method that convert entity object to domain object
     */
    @Mapping(target = "rol", source = "rol.name")
    User entityToDomain(UserEntity userEntity);

    /**
     * Method that convert domain object to entity object
     */
    @Mapping(target = "rol", ignore = true)
    UserEntity domainToEntity(User user);

}
