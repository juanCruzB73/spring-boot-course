package com.springcourse.quizzapp.controller;

import com.springcourse.quizzapp.model.Question;
import com.springcourse.quizzapp.model.QuestionWrapper;
import com.springcourse.quizzapp.model.Response;
import com.springcourse.quizzapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping("/allquestions")
    public ResponseEntity<List<Question>> getAllQuestions() {
        return questionService.getAllQuestions();
    }
    @GetMapping("/category/{category}")
    public ResponseEntity<List<Question>>getByCategory(@PathVariable String category){
        return questionService.findByCategory(category);
    }
    @PostMapping("/addquestion")
    public ResponseEntity<String> addQuestion(@RequestBody Question question){
        return questionService.addQuestion(question);
    }
    @PutMapping("editquestion/{id}")
    public ResponseEntity<String> editQuestions(@RequestBody Question question,@PathVariable Integer id){
        return questionService.editQuestion(question,id);
    }
    @DeleteMapping("/deletequestion/{id}")
    public ResponseEntity<String> deleteQuestion(@PathVariable Integer id){
        return questionService.deleteQuestion(id);
    }
    //microservices
    @GetMapping("/generate")
    public ResponseEntity<List<Integer>> getQuestionsForQuiz(@RequestParam String category,@RequestParam int numQ){
        return questionService.getQuestionsForQuiz(category,numQ);
    }
    @PostMapping("/getquestions")
    public ResponseEntity<List<QuestionWrapper>> getQuestionWrappers(@RequestBody List<Integer>questionsIds) {
        return questionService.getQuestionWrappers(questionsIds);
    }
    @PostMapping("/getscore")
    public ResponseEntity<Integer> getScore(@RequestBody List<Response>responses){
        return questionService.getScore(responses);
    }
}
