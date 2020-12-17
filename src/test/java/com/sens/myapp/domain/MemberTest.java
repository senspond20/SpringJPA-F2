package com.sens.myapp.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class MemberTest {

	@Test
	void test() {
		int id = 4;
		String name = "안녕이";
		
		Member m = new Member(id,name);
		System.out.println(m);
		assertThat(m.getName()).isEqualTo(name);
	}

}
