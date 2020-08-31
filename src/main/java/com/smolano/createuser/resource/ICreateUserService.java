package com.smolano.createuser.resource;

import com.smolano.createuser.entities.User;
import com.smolano.createuser.model.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.URI;
import java.util.List;

@RequestMapping("/users")
public interface ICreateUserService {

    @PostMapping
    ResponseEntity<User> registerUser(URI location, @RequestBody UserDTO userDTO);

    @GetMapping
    ResponseEntity<List<User>> getAllUsers();
}
