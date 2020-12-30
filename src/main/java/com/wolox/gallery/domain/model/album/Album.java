package com.wolox.gallery.domain.model.album;


import com.wolox.gallery.domain.model.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Album {

    private int id;
    private User user;
    private String title;
    private List<Access> access;

}
