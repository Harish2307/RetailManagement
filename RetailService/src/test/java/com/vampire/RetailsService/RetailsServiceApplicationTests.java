package com.vampire.RetailsService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.vampire.RetailService.RetailsServiceApplication;
import com.vampire.RetailService.service.RetailService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = RetailsServiceApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-test.properties")
public class RetailsServiceApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private RetailService retailService;

	private MvcResult mvcResult;
	
	@Test
	public void contextLoads() throws Exception {
		mvcResult = mockMvc
				.perform(MockMvcRequestBuilders.get("/products/updatePrice/1").accept(MediaType.APPLICATION_JSON)).andReturn();
		System.out.println("The response "+mvcResult.getResponse());

		mvcResult = mockMvc
				.perform(MockMvcRequestBuilders.get("/products/getProductData/1").accept(MediaType.APPLICATION_JSON)).andReturn();
		System.out.println("The response "+mvcResult.getResponse());
		
		mvcResult = mockMvc
				.perform(MockMvcRequestBuilders.get("/products/getPrice/1").accept(MediaType.APPLICATION_JSON)).andReturn();
		System.out.println("The response "+mvcResult.getResponse());
	}

}
