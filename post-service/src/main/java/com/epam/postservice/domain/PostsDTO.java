package com.epam.postservice.domain;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class PostsDTO {

    private Long id;

    private Long authorId;

    private String text;

    private LocalDate postedAt;
}
