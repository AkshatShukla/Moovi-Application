package com.dbms.project.moovi.business.service;

import com.dbms.project.moovi.data.entity.User;
import com.dbms.project.moovi.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserService {

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/api/user", method = RequestMethod.POST)
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @RequestMapping(value = "/api/user", method = RequestMethod.GET)
    public List<User> findAllUsers(@RequestParam(name = "username", required = false) String username) {
        if (username != null)
            return (List<User>) userRepository.findUserByUsername(username);
        return (List<User>) userRepository.findAll();
    }

    @RequestMapping(value = "/api/user/{userId}", method = RequestMethod.GET)
    public Optional<User> findUserByUserId(@PathVariable("userId") int userId) {
        return userRepository.findById(userId);
    }
}
