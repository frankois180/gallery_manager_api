package com.wolox.gallery.domain.model.album;


import com.wolox.gallery.domain.model.user.User;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Album {

    private int id;
    private User user;
    private String title;
    private List<Access> access;

}
