package com.wolox.gallery.domain.model.user;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
