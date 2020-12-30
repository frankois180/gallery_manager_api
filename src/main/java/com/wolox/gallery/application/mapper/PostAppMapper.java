package com.wolox.gallery.application.mapper;

import com.wolox.gallery.application.dto.post.CommentDto;
import com.wolox.gallery.domain.model.post.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface PostAppMapper {

    /**
     * Method to convert domain object to dto object
     */
    CommentDto domainCommentToCommentDto(Comment comment);

}
