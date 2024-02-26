package com.question.services;

import java.util.List;

import com.question.models.Question;

public interface QuestionService {

    public Question add(Question question);

    public List<Question> get();

    public Question get(Long id);

    public List<Question> getByQuizId(Long quizId);
    
}
