package org.example.springswaggermongodbtodoapp.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "todos")
public class Todo {
    @Id
    private String id;

    @NotNull(message = "Title can not be empty")
    @Size(max = 100, message = "Title must be less than 100 characters")
    private String title;

    @NotNull(message = "Title can not be empty")
    @Size(max = 200, message = "Description must be less than 200 characters")
    private String description;

    @NotNull(message = "Completed status must be specified")
    private boolean completed;

}
