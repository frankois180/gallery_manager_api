package com.wolox.gallery.infrastructure.adapter.placeholder.mapper;

import com.wolox.gallery.domain.model.post.Comment;
import com.wolox.gallery.domain.model.post.Post;
import com.wolox.gallery.infrastructure.adapter.placeholder.dto.post.CommentResponse;
import com.wolox.gallery.infrastructure.adapter.placeholder.dto.post.PostResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface PostPlaceholderMapper {

    /**
     * Method to convert response object to domain object
     */
    @Mapping(target = "post.id", source = "postId")
    Comment responseCommentToDomainComment(CommentResponse commentResponse);

    /**
     * Method to convert response object to domain object
     */
    @Mapping(target = "user.id", source = "userId")
    Post responsePostToDomainPost(PostResponse postResponse);

}
