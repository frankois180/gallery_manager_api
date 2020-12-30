package com.wolox.gallery.infrastructure.adapter.placeholder;

import com.wolox.gallery.domain.model.post.Comment;
import com.wolox.gallery.domain.model.post.Post;
import com.wolox.gallery.domain.port.external.PostExternalPort;
import com.wolox.gallery.infrastructure.adapter.placeholder.delegate.PlaceholderDelegate;
import com.wolox.gallery.infrastructure.adapter.placeholder.mapper.PostPlaceholderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class PostPlaceholderAdapter implements PostExternalPort {

    private final PlaceholderDelegate placeholderClientDelegate;
    private final PostPlaceholderMapper postPlaceholderMapper;

    @Override
    public List<Comment> findCommentsByName(String name) {

        return placeholderClientDelegate.findAllCommentsByName(name).stream()
                .map(postPlaceholderMapper::responseCommentToDomainComment)
                .collect(Collectors.toList());

    }

    @Override
    public List<Post> findPostsByUserId(int userId) {

        return placeholderClientDelegate.findAllPostByUserId(userId).stream()
                .map(postPlaceholderMapper::responsePostToDomainPost)
                .collect(Collectors.toList());

    }

    @Override
    public List<Comment> findAllComments() {

        return placeholderClientDelegate.findAllComments().stream()
                .map(postPlaceholderMapper::responseCommentToDomainComment)
                .collect(Collectors.toList());

    }
}