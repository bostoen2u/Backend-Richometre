
package com.fullstack.movies.backend.repositories;

import com.fullstack.movies.backend.models.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public interface CommentRepository extends JpaRepository<Comment, UUID> {

    // Removed the findAllByMovieIdOrderByCreatedAtAsc method due to missing movieId in Comment entity

    // Example: Add alternative methods if needed
    List<Comment> findAllByUserIdOrderByCreatedAtAsc(UUID userId);
}
