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
    @ManyToMany
    private List<Question>questions;

    public Quiz(Integer id, String title, List<Question> questions) {
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

    public List<Question> getQuestions() {
        return questions;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setQuestions(List<Question> questions) {
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
