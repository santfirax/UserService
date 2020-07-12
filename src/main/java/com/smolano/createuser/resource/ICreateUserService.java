package com.smolano.createuser.resource;

import com.smolano.createuser.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.net.URI;

@RequestMapping("/users")
public interface ICreateUserService {

    @PostMapping
    ResponseEntity<User> registerUser(URI location,  @Valid @RequestBody User user);

    @GetMapping
    ResponseEntity<Iterable<User>> getAllUsers();
}
