package org.example.springswaggermongodbtodoapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Todo {
    private String id;
    private String title;
    private String description;
    private boolean completed;

}
