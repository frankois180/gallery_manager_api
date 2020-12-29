package com.wolox.gallery.infrastructure.adapter.placeholder.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {

    private int id;
    private String name;
    private String username;
    private String email;
    private String phone;
    private String website;
    AddressDto address;
    CompanyDto company;

}