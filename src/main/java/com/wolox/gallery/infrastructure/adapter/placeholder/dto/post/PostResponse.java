package com.wolox.gallery.infrastructure.adapter.placeholder.dto.post;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostResponse {

    private int userId;
    private int id;
    private String title;
    private String body;

}
