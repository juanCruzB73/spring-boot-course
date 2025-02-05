package com.springcourse.quizzapp.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity(name = "quizzes")
@Data
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    @ElementCollection
    private List<Integer>questions;

    public Quiz(Integer id, String title, List<Integer> questions) {
        this.id = id;
        this.title = title;
        this.questions = questions;
    }

    public Quiz() {}

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public List<Integer> getQuestions() {
        return questions;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setQuestions(List<Integer> questions) {
        this.questions = questions;
    }

    @Override
    public String toString() {
        return "Quiz{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", questions=" + questions +
                '}';
    }
}
