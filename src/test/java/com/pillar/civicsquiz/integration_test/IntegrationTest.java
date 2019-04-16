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
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
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
    public void saveOneAndViewTheOne() throws Exception {
        Inquiry firstQuestion = new Inquiry("What is the supreme law of the land?", "the Constitution");
        ObjectMapper mapper = new ObjectMapper();
        String content = mapper.writeValueAsString(firstQuestion);

        mockMvc.perform(post("/api/inquiries")
                .contentType(APPLICATION_JSON_UTF8)
                .content(content))
                .andExpect(status().isOk());

        MvcResult result = mockMvc.perform(get("/api/inquiry/{id}", 1).accept(MediaType.APPLICATION_JSON))
                .andReturn();

        Inquiry returnedInquiry = mapper.readValue(result.getResponse().getContentAsString(),Inquiry.class);
        System.out.println(returnedInquiry.getQuestion());

        firstQuestion.setId(1L);
        System.out.println("first Q"+ firstQuestion.getId()+", "+firstQuestion.getQuestion()+", "+firstQuestion.getAnswer());
        System.out.println("first Q"+ returnedInquiry.getId()+", "+returnedInquiry.getQuestion()+", "+returnedInquiry.getAnswer());

        assertEquals(firstQuestion, returnedInquiry);
    }

    @Test
    public void saveSecondInquiry_withNextId_automated() throws Exception {
        Inquiry secondQuestion = new Inquiry("What does the Constitution do?", "sets up the government, defines the government, protects basic rights of Americans");
        ObjectMapper mapper = new ObjectMapper();
        String content = mapper.writeValueAsString(secondQuestion);

        mockMvc.perform(post("/api/inquiries")
                .contentType(APPLICATION_JSON_UTF8)
                .content(content))
                .andExpect(status().isOk());
    }

    @Test
    @Ignore
    public void whenCallingGetAllInquiries_returnTheCurrentInquiries() throws Exception {
        List<Inquiry> listOfAllInquiries = new ArrayList<>();
        MvcResult resultMock = mockMvc.perform(get("/api/inquiries"))
                .andReturn();
        String result =  resultMock.getResponse().getContentAsString();
        assertEquals(listOfAllInquiries, result);
    }
}
