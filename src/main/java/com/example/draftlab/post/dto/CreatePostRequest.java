package com.example.draftlab.post.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreatePostRequest {
    private Long userIdx;
    private String title;
    private String category;
    private String tag;
    private String contents;
}
