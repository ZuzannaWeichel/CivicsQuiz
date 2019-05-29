package com.pillar.civicsquiz.controller;

import com.pillar.civicsquiz.Inquiry;
import com.pillar.civicsquiz.repository.InquiryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api")
public class InquiryController {

    @Autowired
    InquiryRepository inquiryRepository;

    @GetMapping("/inquiries")
    public List<Inquiry> getAllInquiries(){
        return inquiryRepository.findAll();
    }

    @GetMapping("/inquiries/government")
    public List<Inquiry> getGovernmentCategory(){
        return inquiryRepository.getAllByGovernmentCategory();
    }

    @GetMapping("/inquiries/history")
    public List<Inquiry> getHistoryCategory(){
        return inquiryRepository.getAllByHistoryCategory();
    }

    @GetMapping("/inquiries/integrated")
    public List<Inquiry> getIntegratedCategory(){
        return inquiryRepository.getAllByIntegratedCategory();
    }

    @GetMapping("/inquiry/{id}")
    public Inquiry getInquiryById(@PathVariable Long id) {
        return inquiryRepository.getOne(id);
    }

    @ResponseBody
    @PostMapping("/save")
    public void saveInquiry(@RequestBody Inquiry inquiry) {
        inquiryRepository.save(inquiry);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteInquiry(@PathVariable Long id) {
        inquiryRepository.deleteById(id);
    }

}
