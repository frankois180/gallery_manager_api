package com.wolox.gallery.domain.port.external;


import com.wolox.gallery.domain.model.post.Comment;
import com.wolox.gallery.domain.model.post.Post;

import java.util.List;

public interface PostExternalPort {

    /**
     * Method to obtain all comments by its name
     */
    List<Comment> findCommentsByName(String name);

    /**
     * Method to obtain all posts by its user id
     */
    List<Post> findPostsByUserId(int userId);

    /**
     * Method to obtain all comments
     */
    List<Comment> findAllComments();

}