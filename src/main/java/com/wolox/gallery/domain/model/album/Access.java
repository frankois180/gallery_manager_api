package com.wolox.gallery.domain.model.album;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Access {

    private Long id;
    private AccessType type;

}