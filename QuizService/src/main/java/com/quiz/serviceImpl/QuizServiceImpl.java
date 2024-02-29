package com.quiz.serviceImpl;

import com.quiz.repositories.QuizRepository;
import com.quiz.services.QuestionClient;
import com.quiz.services.QuizService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.quiz.model.Quiz;

@Service
public class QuizServiceImpl implements QuizService {

  @Autowired
  private QuizRepository quizRepository;

  @Autowired
  private QuestionClient questionClient;

  @Override
  public Quiz add(Quiz quiz) {
    return quizRepository.save(quiz);
  }

  @Override
  public List<Quiz> get() {
    List<Quiz> oldQuizes = quizRepository.findAll();

    List<Quiz> quizes = oldQuizes.stream().map(quiz -> {
      quiz.setQuestions(questionClient.getQuestionOfQuiz(quiz.getId()));
      return quiz;
    }).collect(Collectors.toList());

    return quizes;
  }

  @Override
  public Quiz get(Long id) {

    Quiz quiz = quizRepository.findById(id).orElseThrow(() -> new RuntimeException("Quiz not found"));
    quiz.setQuestions(questionClient.getQuestionOfQuiz(quiz.getId()));
    return quiz;
  }

}
