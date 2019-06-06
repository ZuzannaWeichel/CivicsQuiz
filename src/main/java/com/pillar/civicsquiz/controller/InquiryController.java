package com.pillar.civicsquiz.controller;

import com.pillar.civicsquiz.Inquiry;
import com.pillar.civicsquiz.repository.InquiryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api")
public class InquiryController {

    @Autowired
    InquiryRepository inquiryRepository;

    @GetMapping("/inquiries")
    public List<Inquiry> getAllInquiries(){
        List<Inquiry> all = inquiryRepository.findAll();
        Collections.shuffle(all);
        return all;
    }

    @GetMapping("/inquiries/government")
    public List<Inquiry> getGovernmentCategory(){
        List<Inquiry> all = inquiryRepository.getAllByGovernmentCategory();
        Collections.shuffle(all);
        return all;
    }

    @GetMapping("/inquiries/history")
    public List<Inquiry> getHistoryCategory(){
        List<Inquiry> all = inquiryRepository.getAllByHistoryCategory();
        Collections.shuffle(all);
        return all;
    }

    @GetMapping("/inquiries/integrated")
    public List<Inquiry> getIntegratedCategory(){
        List<Inquiry> all = inquiryRepository.getAllByIntegratedCategory();
        Collections.shuffle(all);
        return all;
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
