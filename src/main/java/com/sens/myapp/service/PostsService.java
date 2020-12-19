package com.sens.myapp.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.sens.myapp.domain.Posts;
import com.sens.myapp.repository.PostsRepository;
import com.sens.myapp.web.dto.PostsResponseDto;
import com.sens.myapp.web.dto.PostsSaveRequestDto;
import com.sens.myapp.web.dto.PostsUpdateRequestDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PostsService {

	private final PostsRepository postsRepository;
	
	@Transactional
	public Posts save(PostsSaveRequestDto requestDto) {
		return postsRepository.save(requestDto.toEntity());
	}
	
	@Transactional
	public Long update(Long id, PostsUpdateRequestDto requestDto) {
		Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
		posts.update(requestDto.getTitle(), requestDto.getContent());
		return id;
	}

	public List<Posts> findAll(){
		return postsRepository.findAll();
	}
	
	public PostsResponseDto findById(Long id) {
		Posts entity = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
		return new PostsResponseDto(entity);
	}
}
