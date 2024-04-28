package org.example.springswaggermongodbtodoapp.service;

import jakarta.validation.Valid;
import org.example.springswaggermongodbtodoapp.dao.TodoRepository;
import org.example.springswaggermongodbtodoapp.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;

    @Autowired
    public TodoServiceImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public List<Todo> findAll() {
        return todoRepository.findAll();
    }

    @Override
    public Optional<Todo> findById(String id) {
        return todoRepository.findById(id);
    }

    @Override
    public Todo save(@Valid Todo todo) {
        return todoRepository.save(todo);
    }

    @Override
    public void deleteById(String id) {
        todoRepository.deleteById(id);
    }

    @Override
    public List<Todo> findTodosByCompleted(boolean completed) {
        return todoRepository.findTodosByCompleted(completed);
    }

    @Override
    public List<Todo> findTodosByTitle(String title) {
        return todoRepository.findTodosByTitle(title);
    }

    @Override
    public void deleteAll(){
        todoRepository.deleteAll();
    }
}