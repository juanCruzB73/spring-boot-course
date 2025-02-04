package com.springcourse.quizzapp.service;

import com.springcourse.quizzapp.dao.QuestionDao;
import com.springcourse.quizzapp.model.Question;
import com.springcourse.quizzapp.model.QuestionWrapper;
import com.springcourse.quizzapp.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;


    public ResponseEntity<List<Question>> getAllQuestions() {
        try{
            return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
        }

    }

    public ResponseEntity<List<Question>> findByCategory(String category) {
        try{
            return new ResponseEntity<>(questionDao.findByCategory(category),HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<String> addQuestion(Question question) {
        try{
            questionDao.save(question);
            return new ResponseEntity<>("Question service succes",HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Not possible to add question",HttpStatus.BAD_REQUEST);
        }

    }

    public ResponseEntity<String> editQuestion(Question question, Integer id) {
        try{
            Question questionToEdit = questionDao.findById(id).get();
            questionDao.save(question);
            return new ResponseEntity<>("question "+id+" edited",HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("question "+id+" couldn't be edited",HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<String> deleteQuestion(Integer id) {
        try{
            questionDao.deleteById(id);
            return new ResponseEntity<>("question deleated",HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("question couldn´t be deleated",HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<List<Integer>> getQuestionsForQuiz(String category, int numQ) {
        try {
            List<Integer> questions=questionDao.findByCategoryLimited(category,numQ);
            return new ResponseEntity<>(questions,HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<List<QuestionWrapper>> getQuestionWrappers(List<Integer> questionsIds) {
        try{
            List<QuestionWrapper>questionWrappers=new ArrayList<>();
            List<Question>questions=new ArrayList<>();

            for (Integer id:questionsIds){
                questions.add(questionDao.findById(id).get());
            }
            for (Question question:questions){
                QuestionWrapper questionWrapper = new QuestionWrapper();
                questionWrapper.setId(question.getId());
                questionWrapper.setQuestiontitle(question.getQuestiontitle());
                questionWrapper.setCategory(question.getCategory());
                questionWrapper.setDifficulty(question.getCategory());
                questionWrapper.setOption1(question.getOption1());
                questionWrapper.setOption2(question.getOption2());
                questionWrapper.setOption3(question.getOption3());
                questionWrapper.setOption4(question.getOption4());
                questionWrappers.add(questionWrapper);
            }

            return new ResponseEntity<>(questionWrappers,HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<Integer> getScore(List<Response> responses) {
        try{
            int right=0;
            for(Response response:responses){
                Question question = questionDao.findById(response.getId()).get();
                if(response.getRightanswer().equals(question.getRightanswer())){
                    right++;
                }
            }
            return new ResponseEntity<>(right,HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }
}
