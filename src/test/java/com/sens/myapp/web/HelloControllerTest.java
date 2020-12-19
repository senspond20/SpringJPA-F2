package com.sens.myapp.web;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.sens.myapp.web.HelloController;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = HelloController.class)
public class HelloControllerTest {
	
	@Autowired
	private MockMvc mvc;
	
	@Test
	public void ishelloReturn() throws Exception {
		String hello = "hello";
		
		mvc.perform(get("/hello"))
		   .andExpect(status().isOk())
		   .andExpect(content().string(hello));
	}
	@Test
	public void ishelloReturnM() throws Exception {
		int id = 123;
		String name = "Allow";
		mvc.perform(get("/hello/m")
			.param("id", String.valueOf(id))
			.param("name", name))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.id", is(id))).andExpect(jsonPath("$.name", is(name)));
	}
}