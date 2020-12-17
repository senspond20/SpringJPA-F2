package com.sens.myapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sens.myapp.domain.Posts;

public interface PostsRepository extends JpaRepository<Posts, Long>{

	Long save(Long id);

}
