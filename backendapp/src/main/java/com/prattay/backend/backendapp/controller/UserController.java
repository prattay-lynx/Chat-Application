package com.prattay.backend.backendapp.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prattay.backend.backendapp.domain.User;
import com.prattay.backend.backendapp.exceptions.UserAlreadyExistException;
import com.prattay.backend.backendapp.exceptions.UserNotFoundException;
import com.prattay.backend.backendapp.services.UserService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getall")
    public ResponseEntity<List<User>> getAll() throws IOException {
        try {
            return new ResponseEntity<List<User>>(userService.getAll(), HttpStatus.OK);
        } catch (UserNotFoundException e) {
            return new ResponseEntity("User not Found", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<User> addUser(@RequestBody User user) throws IOException {
        try {
            return new ResponseEntity<User>(userService.addUser(user), HttpStatus.OK);
        } catch (UserAlreadyExistException e) {
            return new ResponseEntity("User already exists", HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/getbyusername/{username}")
    public ResponseEntity<User> getUserByUserName(@PathVariable String username) throws IOException {
        try {
            return new ResponseEntity<User>(userService.getUserByUserName(username), HttpStatus.OK);
        } catch (UserNotFoundException e) {
            return new ResponseEntity("User not Found", HttpStatus.NOT_FOUND);
        }
    }
}
