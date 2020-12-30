package com.wolox.gallery.domain.model.post;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Comment {

    private int id;
    private Post post;
    private String name;
    private String email;
    private String body;

}
