package com.springcourse.quizzapp.model;

import lombok.Data;

@Data
public class QuestionWrapper {

    private Integer id;
    private  String category;
    private  String difficulty;
    private  String option1;
    private  String option2;
    private  String option3;
    private  String option4;

    public QuestionWrapper() {
    }

    public QuestionWrapper(Integer id, String category, String difficulty, String option1, String option2, String option3, String option4) {
        this.id = id;
        this.category = category;
        this.difficulty = difficulty;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
    }

    public Integer getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }

    public String getOption1() {
        return option1;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public String getOption2() {
        return option2;
    }

    public String getOption3() {
        return option3;
    }

    public String getOption4() {
        return option4;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public void setOption4(String option4) {
        this.option4 = option4;
    }
}
