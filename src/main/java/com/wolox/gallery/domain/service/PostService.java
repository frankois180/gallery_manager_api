package com.wolox.gallery.domain.service;


import com.wolox.gallery.domain.exception.DataNotFoundException;
import static com.wolox.gallery.domain.exception.GalleryNotificationCode.DATA_NOT_FOUND;
import com.wolox.gallery.domain.model.post.Comment;
import com.wolox.gallery.domain.model.post.Post;
import com.wolox.gallery.domain.port.external.PostExternalPort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {

    private final PostExternalPort postExternalPort;

    public PostService(PostExternalPort postExternalPort) {

        this.postExternalPort = postExternalPort;

    }

    public List<Comment> finAllCommentsByName(String name) {

        List<Comment> commentList = postExternalPort.findCommentsByName(name);
        validCommentList(commentList);

        return commentList;

    }
    private void validCommentList(List<Comment> commentList) {

        if (commentList.isEmpty()) {
            throw new DataNotFoundException(DATA_NOT_FOUND);
        }

    }

    public List<Comment> findAllCommentsByUserId(int userId) {

        List<Post> postList = postExternalPort.findPostsByUserId(userId);

        List<Comment> commentList = postExternalPort.findAllComments().stream()
                .filter(comment -> postList.stream()
                        .anyMatch(post -> post.getId()==comment.getPost().getId()))
                .collect(Collectors.toList());
        validCommentList(commentList);

        return commentList;

    }

    public List<Comment> findAllComments() {

        List<Comment> commentList = postExternalPort.findAllComments();
        validCommentList(commentList);

        return commentList;

    }


}
