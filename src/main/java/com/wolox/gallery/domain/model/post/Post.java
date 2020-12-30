package com.wolox.gallery.domain.model.post;

import com.wolox.gallery.domain.model.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Post {

    private int id;
    private User user;
    private String title;
    private String body;

}