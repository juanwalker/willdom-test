package com.willdom.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.willdom.test.repositories.ILogRepository;
import com.willdom.test.service.ILogService;
import com.willdom.test.service.IPasscodeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class TestApplicationTests {

		@Autowired
		private MockMvc mvc;

		@Test
		public void testPassCode()  throws Exception {

			String response21 ="[\"1\",\"2\",\"Big\",\"4\",\"Bang\",\"Big\",\"Theory\",\"8\",\"Big\",\"Bang\",\"11\",\"Big\",\"13\",\"Theory\",\"BigBang\",\"16\",\"17\",\"Big\",\"19\",\"Bang\",\"BigTheory\"]";
			MvcResult result = mvc.perform(MockMvcRequestBuilders.get("/21")
							.contentType(MediaType.APPLICATION_JSON))
					.andExpect(status().isOk()).andReturn();
			String response= result.getResponse().getContentAsString();
			assertEquals(response21,response);
		}
}
