package com.wolox.gallery.infrastructure.adapter.placeholder.mapper;


import com.wolox.gallery.domain.model.user.User;
import com.wolox.gallery.infrastructure.adapter.placeholder.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UserPlaceholderMapper {

    /**
     * Method that convert response object to domain object
     */
    @Mapping(target = "rol", ignore = true)
    User responseToDomain(UserDto userResponse);

}