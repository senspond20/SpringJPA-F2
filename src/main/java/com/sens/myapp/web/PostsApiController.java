package com.sens.myapp.web;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sens.myapp.domain.Posts;
import com.sens.myapp.service.PostsService;
import com.sens.myapp.web.dto.PostsResponseDto;
import com.sens.myapp.web.dto.PostsSaveRequestDto;
import com.sens.myapp.web.dto.PostsUpdateRequestDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor // final 붙은 인자만 생성자 생성 -> 신개념 bean 주입
@RestController
public class PostsApiController {
	
	private final PostsService postsService;
	
	// Insert
	@PostMapping("/api/v1/posts")
	public Posts save(@RequestBody PostsSaveRequestDto requestDto) {
		return postsService.save(requestDto);
	}
		
	// Update
	@PutMapping("/api/v1/posts/{id}")
	public Long update(@PathVariable Long id, PostsUpdateRequestDto requestDto) {
		return postsService.update(id, requestDto);
	}
	
	// Select All
	@GetMapping("/api/v1/posts")
	public List<Posts> findAll() {
		return postsService.findAll();
	}
		
	// Select
	@GetMapping("/api/v1/posts/{id}")
	public PostsResponseDto findbyId(@PathVariable Long id) {
		return postsService.findById(id);
	}
	
	
	

}
