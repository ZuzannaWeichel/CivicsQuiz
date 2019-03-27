package com.pillar.civicsquiz;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CivicsQuizApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void understanding_getMapping() throws Exception {
		MvcResult resultMock = mockMvc.perform(get("/api/test"))
				.andReturn();
		String result =  resultMock.getResponse().getContentAsString();
		Assert.assertEquals("Test works! :D", result);
	}

}
