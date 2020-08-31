package com.smolano.createuser.service;

import com.smolano.createuser.entities.User;

import java.util.List;


public interface IRegisterUser {
    void registerUser(User user);

    List<User> getAllUsers();
}
