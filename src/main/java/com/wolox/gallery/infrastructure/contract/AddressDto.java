package com.wolox.gallery.infrastructure.contract;


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

}