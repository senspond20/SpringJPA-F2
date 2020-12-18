package com.sens.myapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sens.myapp.domain.Posts;

@Repository
public interface PostsRepository extends JpaRepository<Posts, Long>{

	List<Posts> findAll();

	Long save(Long id);

}
