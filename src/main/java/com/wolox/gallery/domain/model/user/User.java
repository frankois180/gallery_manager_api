package com.wolox.gallery.domain.model.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class User {

    private int id;
    private String name;
    private String username;
    private String email;
    private String phone;
    private RolType rol;
    private String website;
    private Address address;

}
