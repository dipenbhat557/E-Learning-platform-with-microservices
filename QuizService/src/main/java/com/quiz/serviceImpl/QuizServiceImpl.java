package com.quiz.serviceImpl;

import com.quiz.model.Quiz;
import com.quiz.repositories.QuizRepository;
import com.quiz.services.QuizService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuizServiceImpl implements QuizService {

  @Autowired
  private QuizRepository quizRepository;

  @Override
  public Quiz add(Quiz quiz) {
    return quizRepository.save(quiz);
  }

  @Override
  public List<Quiz> get() {
    return quizRepository.findAll();
  }

  @Override
  public Quiz get(Long id) {
    return quizRepository.findById(id).orElseThrow(()->new RuntimeException("Quiz not found"));
  }

}
