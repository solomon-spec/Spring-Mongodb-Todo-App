package org.example.springswaggermongodbtodoapp.controller;

import jakarta.validation.Valid;
import org.example.springswaggermongodbtodoapp.model.Todo;
import org.example.springswaggermongodbtodoapp.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoController {
    private final TodoService todoService;
    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/all")
    ResponseEntity<List<Todo>> getAllTodos(){

        return ResponseEntity.ok(todoService.findAll());
    }

    @PostMapping("/add")
    public ResponseEntity<Todo> addTodo(@Valid @RequestBody Todo todo){
        todo.setId(null);
        return ResponseEntity.ok(todoService.save(todo));
    }

    @GetMapping("/incomplete")
    public ResponseEntity<List<Todo>> getIncompleteTodos(){
        return ResponseEntity.ok(todoService.findTodosByCompleted(false));
    }

    @GetMapping("/complete")
    public ResponseEntity<List<Todo>> getCompleteTodos(){
        return ResponseEntity.ok(todoService.findTodosByCompleted(true));
    }

    @GetMapping("/todo/{id}")
    public ResponseEntity<Todo> getTodoById(@PathVariable String id){
        return todoService.findById(id).
                map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Todo> updateTodoById(@PathVariable String id, @RequestBody Todo todo){
         return todoService.findById(id).map(existingTodo -> {
             existingTodo.setTitle(todo.getTitle());
             existingTodo.setDescription(todo.getDescription());
             existingTodo.setCompleted(todo.isCompleted());
             return ResponseEntity.ok(todoService.save(existingTodo));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteTodoById(@PathVariable String id){
        todoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/delete/all")
    public ResponseEntity<Void> deleteAllTodos(){
        todoService.deleteAll();
        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        String errorMessage = ex.getBindingResult().getAllErrors().get(0).getDefaultMessage();
        return ResponseEntity.badRequest().body(errorMessage);
    }

}
