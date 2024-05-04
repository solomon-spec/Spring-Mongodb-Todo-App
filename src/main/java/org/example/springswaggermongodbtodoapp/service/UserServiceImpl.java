package org.example.springswaggermongodbtodoapp.service;

import org.example.springswaggermongodbtodoapp.dao.UserRepository;
import org.example.springswaggermongodbtodoapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> findByUserName(String username) {
        return Optional.ofNullable(userRepository.findUserByUsername(username));
    }

    public User save(User user) {
        return userRepository.save(user);
    }

}
