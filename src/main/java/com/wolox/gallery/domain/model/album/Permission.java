package com.wolox.gallery.domain.model.album;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Permission {

    private Long id;
    private PermissionType type;

}