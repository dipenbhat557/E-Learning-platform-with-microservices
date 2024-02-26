package com.question.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.question.models.Question;
import com.question.repository.QuestionRepository;
import com.question.services.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService{

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public Question add(Question question) {
        return this.questionRepository.save(question);
    }

    @Override
    public List<Question> get() {
        return this.questionRepository.findAll();
    }

    @Override
    public Question get(Long id) {
        return this.questionRepository.findById(id).orElseThrow(()->new RuntimeException("The required question was not found"));
    }

    @Override
    public List<Question> getByQuizId(Long quizId) {
        return this.questionRepository.findByQuizId(quizId);
    }
    
}
