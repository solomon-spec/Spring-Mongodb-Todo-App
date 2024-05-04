package org.example.springswaggermongodbtodoapp.model;


import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "users")
public class User {
    @Id
    private String id;

    @NotNull(message = "Username can not be null")
    private String username;

    @NotNull(message = "Password can not be null")
    private String password;

}
