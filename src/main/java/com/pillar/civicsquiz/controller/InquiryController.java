package com.pillar.civicsquiz.controller;

import com.pillar.civicsquiz.Inquiry;
import com.pillar.civicsquiz.repository.InquiryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class InquiryController {

    @Autowired
    InquiryRepository inquiryRepository;

    @GetMapping("/inquiries")
    public List<Inquiry> getAllInquiries(){
        return inquiryRepository.findAll();
    }

    @GetMapping("/test")
    public String getTest(){
        return "Test works! :D";
    }
}
