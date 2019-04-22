package com.pillar.civicsquiz.integration_test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.pillar.civicsquiz.Inquiry;
import com.pillar.civicsquiz.repository.InquiryRepository;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTest {

    @Autowired
    private MockMvc mockMvc;


    @Test
    public void retrieveOneQuestionFromDatabase() throws Exception{
        Inquiry firstQuestion = new Inquiry(1L, "What is the supreme law of the land?", "the Constitution");
        ObjectMapper mapper = new ObjectMapper();
        MvcResult result = mockMvc.perform(get("/api/inquiry/{id}", 1).accept(MediaType.APPLICATION_JSON))
                .andReturn();

        Inquiry returnedInquiry = mapper.readValue(result.getResponse().getContentAsString(),Inquiry.class);
        assertEquals(firstQuestion, returnedInquiry);
    }

    @Test
    public void retrieveAllQuestionsFromDatabase() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        MvcResult result = mockMvc.perform(get("/api/inquiries").accept(MediaType.APPLICATION_JSON))
                .andReturn();
        List listOfInquiries = mapper.readValue(result.getResponse().getContentAsString(),List.class);

        assertEquals(5, listOfInquiries.size());
    }

    @Test
    @DirtiesContext
    public void saveANewInquiryToDatabase() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        Inquiry newQuestion = new Inquiry(1L,"What is one right or freedom from the First Amendment?", "speech, religion, assembly, press, petition the government");
        String content = mapper.writeValueAsString(newQuestion);
        mockMvc.perform(post("/api/save")
                .contentType(APPLICATION_JSON_UTF8)
                .content(content))
                .andExpect(status().isOk());
        MvcResult result = mockMvc.perform(get("/api/inquiry/{id}", 1).accept(MediaType.APPLICATION_JSON))
                .andReturn();
        Inquiry returnedInquiry = mapper.readValue(result.getResponse().getContentAsString(),Inquiry.class);
        assertEquals(newQuestion, returnedInquiry);
    }

    @Test
    @DirtiesContext
    public void deleteInquiryFromDatabase() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .delete("/api/delete/{id}", 5)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

}
