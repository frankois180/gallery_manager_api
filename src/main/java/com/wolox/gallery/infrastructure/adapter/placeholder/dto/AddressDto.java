package com.wolox.gallery.infrastructure.adapter.placeholder.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AddressDto {

    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private GeoDto geo;

}