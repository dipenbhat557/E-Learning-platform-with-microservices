package com.question.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.question.models.Question;

public interface QuestionRepository extends JpaRepository<Question,Long>{

    public List<Question> findByQuizId(Long quizId);
    
}
