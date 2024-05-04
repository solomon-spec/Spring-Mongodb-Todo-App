package org.example.springswaggermongodbtodoapp.dao;
import org.example.springswaggermongodbtodoapp.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    User findUserByUsername(String username);
}
