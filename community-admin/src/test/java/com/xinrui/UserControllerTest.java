package com.xinrui;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * @ClassName UserControllerTest
 * @Description TODO
 * @Author kong
 * @Date 2019/4/22 16:45
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest{

	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext wac;

	@Before
	public void setUp(){
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}

	@Test
	public void whenCreateSuccess() throws Exception {

		String content = "{\"username\":\"tom\",\"password\":123}";
		String result = mockMvc.perform(MockMvcRequestBuilders.post("/user")
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.content(content))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.id").value("1"))
				.andReturn().getResponse().getContentAsString();
		System.out.println(result);
	}

	@Test
	public void whenGetInfoFaile() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/user/a")
				.contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(MockMvcResultMatchers.status().is4xxClientError());
	}

	@Test
	public void whenGetInfoSuccess() throws Exception {
		// TODO:json path git-hub
		String result = mockMvc.perform(MockMvcRequestBuilders.get("/user")
				.contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(3))
				.andReturn().getResponse().getContentAsString();
		System.out.println(result);
	}
}
