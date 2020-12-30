package com.wolox.gallery.domain.model.album;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Access {

    private Long id;
    private AccessType type;

}