package com.abhishekk.joblisting;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
class JoblistingApplicationTests {

	@Autowired
	private MockMvc mockMvc;
	@Test
	public void testGetAllPosts() throws Exception {
		mockMvc.perform(get("/posts")
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$", hasSize(greaterThan(0))))
				.andExpect(jsonPath("$[0].profile", is("java developer")))
				.andExpect(jsonPath("$[0].desc", is("Seniour Software engineer with java skillset expert in core")))
				.andExpect(jsonPath("$[0].exp", is(5)))
				.andExpect(jsonPath("$[0].techs", containsInAnyOrder("java", "jee", "spring", "springbot", "microservices", "threads")))
				.andExpect(jsonPath("$[1].profile", is("java developer")))
				.andExpect(jsonPath("$[1].desc", is("Seniour Software engineer with java skillset expert in core")))
				.andExpect(jsonPath("$[1].exp", is(5)))
				.andExpect(jsonPath("$[1].techs", containsInAnyOrder("java", "jee", "spring", "springbot", "microservices", "threads")))
				.andExpect(jsonPath("$[3].profile", is("Block chain")))
				.andExpect(jsonPath("$[3].desc", is("Etherium")))
				.andExpect(jsonPath("$[3].exp", is(2)))
				.andExpect(jsonPath("$[3].techs", containsInAnyOrder("Java", "Solidity")));
	}

}



