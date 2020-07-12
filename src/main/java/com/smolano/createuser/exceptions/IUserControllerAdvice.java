package com.smolano.createuser.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public interface IUserControllerAdvice {
    @ExceptionHandler(value = UserNotFoundException.class)
    ResponseEntity<?> userNotFoundError(UserNotFoundException userNotFoundException);

    @ExceptionHandler(value = UserException.class)
    ResponseEntity<?> handleError(UserException userException);
}
