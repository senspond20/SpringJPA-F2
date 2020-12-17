package com.sens.myapp.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.sens.myapp.repository.PostsRepository;
import com.sens.myapp.web.dto.PostsSaveRequestDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PostsService {

	private final PostsRepository postsRepository;
	
	@Transactional
	public Long save(PostsSaveRequestDto requestDto) {
		return postsRepository.save(requestDto.toEntity().getId());
	}
}
