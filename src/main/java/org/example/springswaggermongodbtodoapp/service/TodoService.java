package org.example.springswaggermongodbtodoapp.service;

import org.example.springswaggermongodbtodoapp.model.Todo;

import java.util.List;
import java.util.Optional;

public interface TodoService {
    List<Todo> findAll();
    Optional<Todo> findById(String id);
    Todo save(Todo todo);
    void deleteById(String id);
    List<Todo> findTodosByCompleted(boolean completed);
    List<Todo> findTodosByTitle(String title);
    void deleteAll();
}