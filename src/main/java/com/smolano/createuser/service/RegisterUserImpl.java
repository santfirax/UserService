package com.smolano.createuser.service;

import com.smolano.createuser.entities.User;
import com.smolano.createuser.exceptions.UserException;
import com.smolano.createuser.repositories.CreateUserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.Optional;

@Service
public class RegisterUserImpl implements IRegisterUser {
    private static final Logger LOGGER = LoggerFactory.getLogger(RegisterUserImpl.class);
    @Autowired
    private CreateUserRepository createUserRepository;

    @Override
    public void registerUser(@Valid User user) {

        LOGGER.info("Creating user:{}", user);
        Optional<User> userFoundInDatabase = createUserRepository.findByIdentification(user.getIdentification());
        if (userFoundInDatabase.isPresent()) {
            throw new UserException("User already exists in the database");
        } else {
            createUserRepository.saveAndFlush(user);
        }
    }


    @Override
    public Iterable<User> getAllUsers() {
        try {
            LOGGER.info("Getting all users");
            return createUserRepository.findAll();
        } catch (Exception e) {
            LOGGER.error("Error while getting users from database", e);
            throw new UserException(e);
        }
    }
}
