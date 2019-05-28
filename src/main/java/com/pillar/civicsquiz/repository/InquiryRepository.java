package com.pillar.civicsquiz.repository;

import com.pillar.civicsquiz.Inquiry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InquiryRepository extends JpaRepository<Inquiry, Long> {

    @Query(
            value = "SELECT * FROM quiz WHERE category = 'American Government'",
            nativeQuery = true)
    List<Inquiry> getAllByGovernmentCategory();

    @Query(
            value = "SELECT * FROM quiz WHERE category = 'American History'",
            nativeQuery = true)
    List<Inquiry> getAllByHistoryCategory();

    @Query(
            value = "SELECT * FROM quiz WHERE category = 'Integrated Civics'",
            nativeQuery = true)
    List<Inquiry> getAllByIntegratedCategory();
}
