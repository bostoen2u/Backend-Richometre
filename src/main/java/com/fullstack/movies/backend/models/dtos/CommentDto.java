
package com.fullstack.movies.backend.models.dtos;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
public class CommentDto {
    private UUID id;
    private String title;
    private String content;
    private String username;
    private LocalDateTime publishedAt;
}
