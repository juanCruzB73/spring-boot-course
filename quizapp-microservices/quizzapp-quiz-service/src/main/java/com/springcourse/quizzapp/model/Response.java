package com.springcourse.quizzapp.model;
import lombok.Data;

@Data
public class Response {
    private Integer id;
    private String rightanswer;

    public Response() {
    }

    public Response(Integer id, String rightanswer) {
        this.id = id;
        this.rightanswer = rightanswer;
    }

    public Integer getId() {
        return id;
    }

    public String getRightanswer() {
        return rightanswer;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setRightanswer(String rightanswer) {
        this.rightanswer = rightanswer;
    }

    @Override
    public String toString() {
        return "Response{" +
                "id=" + id +
                ", rightanswer='" + rightanswer + '\'' +
                '}';
    }
}
