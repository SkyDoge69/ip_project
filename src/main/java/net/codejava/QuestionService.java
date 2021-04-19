package net.codejava;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepository repo;

    public List<Question> listAll() {
        return repo.findAll();
    }

    public void save(Question question) {
        repo.save(question);
    }

    public Question get(Long id) {
        return repo.findById(id).get();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
    
}
