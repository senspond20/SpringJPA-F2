package com.sens.myapp.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.After;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sens.myapp.domain.Posts;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostRepositoryTest {

	@Autowired
	PostsRepository postsRepository;

	@After // 단위 테스트가 끝날때마다 수행 : 다음 테스트떄 영향을 주지 않기 위해
	public void cleanUp() {
		postsRepository.deleteAll();
	}
	/*
	 *  junit 과 함께사용 assertj
	 	<dependency> 
			<groupId>org.assertj</groupId> 
			<artifactId>assertj-core</artifactId> 
			<scope>test</scope>
		</dependency>
	 */
	@Test
	public void saveAndLoad() {
		// given
		String title = "테스트 게시글";
		String content = "테스트 본문";
		postsRepository.save(Posts.builder()
				                  .title(title)
				                  .content(content)
				                  .author("jojol@gmail.com")
				                  .build());
		// when
		List<Posts> postList = postsRepository.findAll();
		
		// then
		Posts posts = postList.get(0);
		
		System.out.println(posts.getId());
		assertThat(posts.getTitle()).isEqualTo(title);
		assertThat(posts.getContent()).isEqualTo(content);
	}
}
