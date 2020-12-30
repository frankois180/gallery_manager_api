package com.wolox.gallery.infrastructure.adapter.placeholder.dto.post;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CommentResponse {

    private int postId;
    private int id;
    private String name;
    private String email;
    private String body;

}