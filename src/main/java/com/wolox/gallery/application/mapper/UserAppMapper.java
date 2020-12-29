package com.wolox.gallery.application.mapper;

import com.wolox.gallery.domain.model.user.User;
import com.wolox.gallery.infrastructure.contract.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UserAppMapper {

    /**
     * Method that convert domain object to domain object
     */
    UserDto domainToDto(User user);

}