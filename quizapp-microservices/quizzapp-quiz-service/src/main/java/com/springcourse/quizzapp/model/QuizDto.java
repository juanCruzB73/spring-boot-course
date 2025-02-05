package com.springcourse.quizzapp.model;

import lombok.Data;

@Data
public class QuizDto {
    String categoryName;
    Integer numQ;
    String title;

    public QuizDto(String categoryName, Integer numQ, String title) {
        this.categoryName = categoryName;
        this.numQ = numQ;
        this.title = title;
    }

    public QuizDto() {
    }

    public String getCategoryName() {
        return categoryName;
    }

    public Integer getNumQ() {
        System.out.println(numQ);
        return numQ;
    }
    public String getTitle() {
        return title;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public void setNumQ(Integer numQuestions) {
        this.numQ = numQuestions;
    }

    public void setTitle(String title) {
        this.title = title;
    }




    @Override
    public String toString() {
        return "QuizDto{" +
                "categoryName='" + categoryName + '\'' +
                ", numQuestions=" + numQ +
                ", title='" + title + '\'' +
                '}';
    }
}
