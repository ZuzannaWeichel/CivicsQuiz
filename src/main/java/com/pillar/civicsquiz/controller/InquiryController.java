package com.pillar.civicsquiz.controller;

import com.pillar.civicsquiz.Inquiry;
import com.pillar.civicsquiz.repository.InquiryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class InquiryController {

    @Autowired
    InquiryRepository inquiryRepository;

//    @GetMapping("/test")
//    public String getTest(){
//        return "Test works! :D";
//    }

    @GetMapping("/inquiries")
    public List<Inquiry> getAllInquiries(){
        return inquiryRepository.findAll();
    }

    @GetMapping("/inquiry/{id}")
    public Inquiry getInquiryById(@PathVariable Long id) {
        return inquiryRepository.getOne(id);
    }

    @ResponseBody
    @PostMapping("/inquiries")
    public void saveInquiry(@RequestBody Inquiry inquiry) {
        inquiryRepository.save(inquiry);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteInquiry(@PathVariable Long id) {
        inquiryRepository.deleteById(id);
    }
}
