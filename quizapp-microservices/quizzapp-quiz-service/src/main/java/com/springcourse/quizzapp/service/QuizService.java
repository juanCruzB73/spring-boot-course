package com.springcourse.quizzapp.service;

import com.springcourse.quizzapp.dao.QuizDao;
import com.springcourse.quizzapp.feign.QuizInterface;
import com.springcourse.quizzapp.model.Question;
import com.springcourse.quizzapp.model.QuestionWrapper;
import com.springcourse.quizzapp.model.Quiz;
import com.springcourse.quizzapp.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
    @Autowired
    QuizDao quizDao;
    @Autowired
    QuizInterface quizInterface;

    public ResponseEntity<String> addQuizz(String category, int numQ, String title) {
        try{
            List<Integer> questions = quizInterface.getQuestionsForQuiz(category, numQ).getBody();
            Quiz quiz = new Quiz();
            quiz.setTitle(title);
            quiz.setQuestions(questions);
            quizDao.save(quiz);
            return new ResponseEntity<>("Quiz created",HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Quiz could not be created",HttpStatus.BAD_REQUEST);
        }

    }

    public ResponseEntity<List<QuestionWrapper>> getQuizzById(Integer id) {

        try {

            Quiz quiz = quizDao.findById(id).get();
            List<Integer>questionIds=quiz.getQuestions();

            ResponseEntity<List<QuestionWrapper>>questionWrappers=quizInterface.getQuestionWrappers(questionIds);

            return questionWrappers;
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
        }

    }

    public ResponseEntity<List<Quiz>> getAllQuizz() {

        try {
            return new ResponseEntity<>(quizDao.findAll(),HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
        }

    }

    public ResponseEntity<Integer> submitQuiz(Integer id,List<Response> responses) {
        try{
            Quiz quiz = quizDao.findById(id).get();
            ResponseEntity<Integer> right = quizInterface.getScore(responses);

            return right;
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }
}
