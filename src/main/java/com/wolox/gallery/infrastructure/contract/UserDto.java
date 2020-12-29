package com.wolox.gallery.infrastructure.contract;

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
    private AddressDto address;

}
