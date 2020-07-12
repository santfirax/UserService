package com.smolano.createuser.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class UserControllerAdviceImpl implements IUserControllerAdvice {

    @Override
    public ResponseEntity<?> userNotFoundError(UserNotFoundException userNotFoundException) {

//        ApiError apiError = new ApiError();
        return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<?> handleError(UserException userException) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(userException.getMessage());
    }
}
