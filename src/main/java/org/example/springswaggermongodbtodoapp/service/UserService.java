package org.example.springswaggermongodbtodoapp.service;

import org.example.springswaggermongodbtodoapp.model.User;

import java.util.Optional;

public interface UserService {

    Optional<User> findByUserName(String username);
    public User save(User user);

}
