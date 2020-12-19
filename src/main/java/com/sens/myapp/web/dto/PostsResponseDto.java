package com.sens.myapp.web.dto;

import com.sens.myapp.domain.Posts;

import lombok.Getter;

@Getter
public class PostsResponseDto {
	
	private Long id;
	private String title;
	private String content;
	private String author;
	
	public PostsResponseDto(Posts Entity) {
		super();
		this.id = Entity.getId();
		this.title = Entity.getTitle();
		this.content = Entity.getContent();
		this.author = Entity.getAuthor();
	}
	
}
