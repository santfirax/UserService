package com.smolano.createuser.resource;

import com.smolano.createuser.entities.User;
import com.smolano.createuser.service.IRegisterUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;

@RestController
@Validated
public class CreateUserServiceImpl implements ICreateUserService {
    @Autowired
    private IRegisterUser registerUser;


    @Override
    public ResponseEntity<User> registerUser(URI location, User user) {
        registerUser.registerUser(user);
        return ResponseEntity.created(location)
                .body(user);
    }

    @Override
    public ResponseEntity<Iterable<User>> getAllUsers() {
        return ResponseEntity.ok(registerUser.getAllUsers());
    }
}
