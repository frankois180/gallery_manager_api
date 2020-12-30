package com.wolox.gallery.application.dto.post;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CommentDto {

    private int id;

    @JsonIgnoreProperties({"title", "body", "user"})
    private PostDto post;
    private String name;
    private String email;
    private String body;

}