package com.dbms.project.moovi.business.service;

import com.dbms.project.moovi.data.entity.User;
import com.dbms.project.moovi.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserService extends APICredentials {

    @Autowired
    UserRepository userRepository;

    @PostMapping("/api/user")
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping("/api/user")
    public Iterable<User> findAllUsers(@RequestParam(name = "username", required = false) String username) {
        if (username != null)
            return userRepository.findUserByUsername(username);
        return userRepository.findAll();
    }

    @GetMapping("/api/user/{userId}")
    public Optional<User> findUserByUserId(@PathVariable("userId") int userId) {
        return userRepository.findById(userId);
    }

}
