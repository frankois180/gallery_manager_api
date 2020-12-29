package com.wolox.gallery.domain.model.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Address {

    private String street;
    private String suite;
    private String city;
    private String zipcode;

}
