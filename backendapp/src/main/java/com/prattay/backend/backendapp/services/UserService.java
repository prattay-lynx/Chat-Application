package com.prattay.backend.backendapp.services;

import java.util.List;

import com.prattay.backend.backendapp.domain.User;
import com.prattay.backend.backendapp.exceptions.UserAlreadyExistException;
import com.prattay.backend.backendapp.exceptions.UserNotFoundException;

public interface UserService {
    List<User> getAll() throws UserNotFoundException;

    User addUser(User user) throws UserAlreadyExistException;

    User getUserByUserName(String username) throws UserNotFoundException;
}
