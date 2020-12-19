package com.sens.myapp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

// 일반 자바빈 규약대로 @Getter/@Setter를 만들기 쉽지만
// @Entity 가 붙으면 절대로 @Setter를 만들어서는 안된다.
// -> 해당 인스턴스의 값들이 언제 변경되는지 구분하기가 어려워서 향후 굉장히 복잡해진다.
// 대신 필드를 변경하고자 한다면 목적과 이유가 명확해야 한다.

// 기본은 생성자를 통해 insert를 하는것이고 값 변경이 필요한 경우 해당 이벤트에 맞는 public메소드를 호출하여 변경하는것으로 한다.                                                                                                   
@Entity
@Getter
@NoArgsConstructor
public class Posts {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 500, nullable = false)
	private String title;
	
	@Column(columnDefinition = "TEXT", nullable = false)
	private String content;
	
	private String author;

	@Builder // 빌더패턴 사용하는 이유? 
	public Posts(Long id, String title, String content, String author) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.author = author;
	}
	
	public void update(String title, String content) {
		this.title = title;
		this.content = content;
	}
}
