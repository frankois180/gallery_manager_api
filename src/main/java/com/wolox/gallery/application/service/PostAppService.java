package com.wolox.gallery.application.service;

import com.wolox.gallery.application.dto.post.CommentDto;
import com.wolox.gallery.application.mapper.PostAppMapper;
import com.wolox.gallery.domain.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

import static org.apache.commons.lang3.StringUtils.isEmpty;

@Component
@RequiredArgsConstructor
public class PostAppService {

    private final PostService postService;
    private final PostAppMapper postAppMapper;

    public List<CommentDto> findAllComments() {
        return postService.findAllComments().stream()
                .map(postAppMapper::domainCommentToCommentDto)
                .collect(Collectors.toList());
    }

    public List<CommentDto> finAllCommentsByName(String name) {
        return postService.finAllCommentsByName(name).stream()
                .map(postAppMapper::domainCommentToCommentDto)
                .collect(Collectors.toList());
    }

    public List<CommentDto> findAllCommentsByUserId(int userId) {
        return postService.findAllCommentsByUserId(userId).stream()
                .map(postAppMapper::domainCommentToCommentDto)
                .collect(Collectors.toList());

    }

}
