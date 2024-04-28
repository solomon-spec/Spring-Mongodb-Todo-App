package org.example.springswaggermongodbtodoapp.dao;

import org.example.springswaggermongodbtodoapp.model.Todo;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface TodoRepository extends MongoRepository<Todo, String>{

    List<Todo> findTodosByCompleted(boolean completed);
    List<Todo> findTodosByTitle(String title);
}
