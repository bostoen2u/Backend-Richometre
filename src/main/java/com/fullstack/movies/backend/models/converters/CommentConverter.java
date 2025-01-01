package com.fullstack.movies.backend.models.converters;

import com.fullstack.movies.backend.models.dtos.CommentDto;
import com.fullstack.movies.backend.models.entities.Comment;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CommentConverter implements Converter<Comment, CommentDto> {

    @Override
    public CommentDto convert(Comment comment) {
        return CommentDto.builder()
                .id(comment.getId()) // This remains UUID
                .title(comment.getTitle())
                .content(comment.getContent())
                .username(comment.getUser().getUsername())
                .build();
    }
}
