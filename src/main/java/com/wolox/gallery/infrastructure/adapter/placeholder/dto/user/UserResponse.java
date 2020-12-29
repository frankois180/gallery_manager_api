package com.wolox.gallery.infrastructure.adapter.placeholder.dto.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserResponse {

    private int id;
    private String name;
    private String username;
    private String email;
    private String phone;
    private String website;
    AddressResponse address;
    CompanyResponse company;

}