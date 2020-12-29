package com.wolox.gallery.infrastructure.adapter.placeholder.dto.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AddressResponse {

    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private GeoResponse geo;

}