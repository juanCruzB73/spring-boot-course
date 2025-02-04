package com.springcourse.quizzapp.dao;

import com.springcourse.quizzapp.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question,Integer> {


    List<Question> findByCategory(String category);
    @Query(value = "SELECT id FROM questions WHERE category=:category LIMIT :numQ",nativeQuery = true)
    List<Integer> findByCategoryLimited(@Param("category") String category, @Param("numQ") int numQ);
}
