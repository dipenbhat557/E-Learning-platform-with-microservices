package com.quiz.services;

import java.util.List;

import com.quiz.model.Quiz;

public interface QuizService {
  public Quiz add(Quiz quiz);

  public List<Quiz> get();

  public Quiz get(Long id);
}
