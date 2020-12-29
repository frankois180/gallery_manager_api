package com.wolox.gallery.application.service;


import com.wolox.gallery.application.mapper.UserAppMapper;
import com.wolox.gallery.domain.port.external.UserExternalPort;
import com.wolox.gallery.infrastructure.contract.UserDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class UserAppService {

    private final UserExternalPort userExternalPort;
    private final UserAppMapper userAppMapper;

    public List<UserDto> findAll() {

        return userExternalPort.findAll().stream()
                .map(userAppMapper::domainToDto)
                .collect(Collectors.toList());

    }
}

