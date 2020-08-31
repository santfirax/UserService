package com.smolano.createuser.resource;

import com.smolano.createuser.entities.User;
import com.smolano.createuser.model.UserDTO;
import com.smolano.createuser.service.IRegisterUser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@RestController
public class CreateUserServiceImpl implements ICreateUserService {
    @Autowired
    private IRegisterUser registerUser;
    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public ResponseEntity<User> registerUser(URI location, UserDTO userDTO) {
        User user = modelMapper.map(userDTO, User.class);
        registerUser.registerUser(user);
        return ResponseEntity.created(location)
                .body(user);
    }

    @Override
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(registerUser.getAllUsers());
    }
}
