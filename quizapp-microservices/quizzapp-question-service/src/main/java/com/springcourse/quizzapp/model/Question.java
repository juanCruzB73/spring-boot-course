package com.springcourse.quizzapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name = "questions")

public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private  String category;
    private  String difficulty;
    private  String option1;
    private  String option2;
    private  String option3;
    private  String option4;
    private  String questiontitle;
    private  String rightanswer;

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", category='" + category + '\'' +
                ", difficulty='" + difficulty + '\'' +
                ", option1='" + option1 + '\'' +
                ", option2='" + option2 + '\'' +
                ", option3='" + option3 + '\'' +
                ", option4='" + option4 + '\'' +
                ", questiontitle='" + questiontitle + '\'' +
                ", rightanswer='" + rightanswer + '\'' +
                '}';
    }

    public Question() {}

    public Question(String category, String difficulty, String option1, String option2, String questiontitle, String option3, String option4, String rightanswer) {
        this.category = category;
        this.difficulty = difficulty;
        this.option1 = option1;
        this.option2 = option2;
        this.questiontitle = questiontitle;
        this.option3 = option3;
        this.option4 = option4;
        this.rightanswer = rightanswer;
    }

    public Integer getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public String getOption1() {
        return option1;
    }

    public String getOption3() {
        return option3;
    }

    public String getOption2() {
        return option2;
    }

    public String getOption4() {
        return option4;
    }

    public String getQuestiontitle() {
        return questiontitle;
    }

    public String getRightanswer() {
        return rightanswer;
    }
}
