package com.springcourse.quizzapp.controller;

import com.springcourse.quizzapp.model.QuestionWrapper;
import com.springcourse.quizzapp.model.Quiz;
import com.springcourse.quizzapp.model.QuizDto;
import com.springcourse.quizzapp.model.Response;
import com.springcourse.quizzapp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {
    @Autowired
    QuizService quizService;

    @GetMapping("getquizzes")
    public ResponseEntity<List<Quiz>>getAllQuiz(){
        return quizService.getAllQuizz();
    }

    @GetMapping("getquizzes/{id}")
    public ResponseEntity<List<QuestionWrapper>>getquizById(@PathVariable Integer id){
        return quizService.getQuizzById(id);
    }

    @PostMapping("/addquiz")
    public ResponseEntity<String>createQuiz(@RequestBody QuizDto quizDto){
        return quizService.addQuizz(quizDto.getCategoryName(),quizDto.getNumQ(), quizDto.getTitle());
    }

    @PostMapping("submit/{id}")
    public ResponseEntity<Integer>submitQuiz(@PathVariable Integer id,@RequestBody List<Response> responses){
        return quizService.submitQuiz(id,responses);
    }
}
