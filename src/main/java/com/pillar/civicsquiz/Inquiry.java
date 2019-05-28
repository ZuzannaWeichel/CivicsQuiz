package com.pillar.civicsquiz;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "quiz")

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Inquiry implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (nullable = false)
    private String question;
    @Column (nullable = false)
    private String answer;
    @Column (nullable = false)
    private String category;
    @Column (nullable = false)
    private String subcategory;

    public Inquiry() {
    }
    public Inquiry( String question,  String answer, String category, String subcategory) {
        this.question = question;
        this.answer = answer;
        this.category = category;
        this.subcategory = subcategory;
    }
    public Inquiry(Long id, @NotBlank String question, @NotBlank String answer, String category, String subcategory) {
        this.id = id;
        this.question = question;
        this.answer = answer;
        this.category = category;
        this.subcategory = subcategory;
    }


    public void setCategory(String category) {
        this.category = category;
    }
    public String getCategory() {
        return category;
    }
    public String getSubcategory() {
        return subcategory;
    }
    public void setSubcategory(String subcategory) {
        this.subcategory = subcategory;
    }
    public String getQuestion() {
        return question;
    }
    public void setQuestion(String question) {
        this.question = question;
    }
    public String getAnswer() {
        return answer;
    }
    public void setAnswer(String answer) {
        this.answer = answer;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Inquiry{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Inquiry)) return false;
        Inquiry inquiry = (Inquiry) o;
        return Objects.equals(getId(), inquiry.getId()) &&
                Objects.equals(getQuestion(), inquiry.getQuestion()) &&
                Objects.equals(getAnswer(), inquiry.getAnswer());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getQuestion(), getAnswer());
    }
}
