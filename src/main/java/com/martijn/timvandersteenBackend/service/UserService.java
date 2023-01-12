package com.martijn.timvandersteenBackend.service;

import com.martijn.timvandersteenBackend.model.User;
import com.martijn.timvandersteenBackend.model.UserDto;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User save(UserDto user);
    List<User> findAll();
    User findOne(String username);
    Optional<User> findById(long userId);
}
