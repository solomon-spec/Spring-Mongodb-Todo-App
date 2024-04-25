package org.example.springswaggermongodbtodoapp.controller;

import org.example.springswaggermongodbtodoapp.SpringSwaggerMongodbTodoAppApplication;
import org.example.springswaggermongodbtodoapp.model.Todo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoController {

    @GetMapping("/all")
    List<Todo> getAllTodos(){
        return SpringSwaggerMongodbTodoAppApplication.todos;
    }

    @PostMapping("/add")
    public void addTodo(@RequestBody Todo todo){
        SpringSwaggerMongodbTodoAppApplication.todos.add(todo);
    }

    @GetMapping("/incomplete")
    public List<Todo> getIncompleteTodos(){
        return SpringSwaggerMongodbTodoAppApplication.todos.stream().filter(todo -> !todo.isCompleted()).toList();
    }

    @GetMapping("/complete")
    public List<Todo> getCompleteTodos(){
        return SpringSwaggerMongodbTodoAppApplication.todos.stream().filter(Todo::isCompleted).toList();
    }

    @GetMapping("/todo/{id}")
    public Todo getTodoById(@PathVariable String id){
        return SpringSwaggerMongodbTodoAppApplication.todos.stream().filter(todo -> todo.getId().equals(id)).findFirst().orElse(null);
    }

    @PutMapping("/update/{id}")
    public void updateTodoById(@PathVariable String id, @RequestBody Todo todo){
        SpringSwaggerMongodbTodoAppApplication.todos.stream().filter(t -> t.getId().equals(id)).forEach(t -> {
            t.setTitle(todo.getTitle());
            t.setDescription(todo.getDescription());
            t.setCompleted(todo.isCompleted());
        });
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTodoById(@PathVariable String id){
        SpringSwaggerMongodbTodoAppApplication.todos.removeIf(todo -> todo.getId().equals(id));
    }

    @DeleteMapping("/delete/all")
    public void deleteAllTodos(){
        SpringSwaggerMongodbTodoAppApplication.todos.clear();
    }

}
