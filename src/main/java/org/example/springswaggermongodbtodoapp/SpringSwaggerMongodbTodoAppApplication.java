package org.example.springswaggermongodbtodoapp;

import org.example.springswaggermongodbtodoapp.model.Todo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringSwaggerMongodbTodoAppApplication {
    public static List<Todo> todos;
    public static void main(String[] args) {
        todos = new ArrayList<Todo>();
        SpringApplication.run(SpringSwaggerMongodbTodoAppApplication.class, args);

        todos.add(new Todo("1", "First Todo", "This is the first todo", false));
        todos.add(new Todo("2", "Second Todo", "This is the second todo", false));
        todos.add(new Todo("3", "Third Todo", "This is the third todo", false));
        todos.add(new Todo("4", "Fourth Todo", "This is the fourth todo", true));

    }

}
