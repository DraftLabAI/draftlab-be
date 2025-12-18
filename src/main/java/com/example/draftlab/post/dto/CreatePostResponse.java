package com.example.draftlab.post.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreatePostResponse {
    private Long idx;
    private Long userIdx;
    private String title;
    private String category;
    private String tag;
    private String contents;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}