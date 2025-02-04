package com.springcourse.quizzapp.service;

import com.springcourse.quizzapp.dao.QuizDao;
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
    QuestionDao questionDao;

    public ResponseEntity<String> addQuizz(String category, int numQ, String title) {
        try{
            List<Question>questions=questionDao.findByCategoryLimited(category,numQ);

            Quiz quiz = new Quiz();
            quiz.setTitle("first quiz");
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
            Optional<Quiz> quiz = quizDao.findById(id);
            List<Question>questionFromDB=quiz.get().getQuestions();
            List<QuestionWrapper>questionWrappers=new ArrayList<>();
            for(Question question : questionFromDB){
                QuestionWrapper questionWrapper=new QuestionWrapper(question.getId(),question.getCategory(),question.getOption1(),question.getOption2(),question.getOption3(),question.getOption4(),question.getDifficulty());
                questionWrappers.add(questionWrapper);
            }
            return new ResponseEntity<>(questionWrappers,HttpStatus.OK);
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
            List<Question>questions=quiz.getQuestions();
            int right=0;
            int i=0;
            for(Response response:responses){
                if(i>=questions.size()){
                    System.out.println("breaking");
                    break;
                }
                if(response.getRightanswer().equals(questions.get(i).getRightanswer())){
                    right++;
                }
                i++;
            }
            return new ResponseEntity<>(right,HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }
}
