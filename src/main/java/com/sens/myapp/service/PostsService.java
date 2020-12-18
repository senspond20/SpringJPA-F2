package com.sens.myapp.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.sens.myapp.domain.Posts;
import com.sens.myapp.repository.PostsRepository;
import com.sens.myapp.web.dto.PostsSaveRequestDto;

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
	public List<Posts> findAll(){
		return postsRepository.findAll();
	}
}
