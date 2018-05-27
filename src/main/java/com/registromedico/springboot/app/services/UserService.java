package com.registromedico.springboot.app.services;

import com.registromedico.springboot.app.entities.User;

public interface UserService {
    void save(User user);
    User findByUsername(String username);

    Iterable<User> listAllUsers();
}