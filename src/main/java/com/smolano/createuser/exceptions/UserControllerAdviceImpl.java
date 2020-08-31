package com.smolano.createuser.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class UserControllerAdviceImpl implements IUserControllerAdvice {

    @Override
    public ResponseEntity<String> userNotFoundError(UserNotFoundException userNotFoundException) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(userNotFoundException.getMessage());
    }

    @Override
    public ResponseEntity<String> handleError(UserException userException) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(userException.getMessage());
    }
}
