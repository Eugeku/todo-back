package org.eug.todo.controller.exception.handler;

import lombok.extern.log4j.Log4j2;
import org.eug.todo.controller.exception.ControllerException;
import org.eug.todo.service.exception.ServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static org.eug.todo.Constants.ErrorMessages.CONTROLLER_ERROR;
import static org.eug.todo.Constants.ErrorMessages.ILLEGAL_ARGUMENT_ERROR;

@Log4j2
@ControllerAdvice
public class DefaultExceptionHandler {

    @ExceptionHandler({ServiceException.class})
    public ResponseEntity<ExceptionResponse> handleValidationException(Exception e) {
        log.debug(e.getMessage(), e);

        return new ResponseEntity<>(new ExceptionResponse(ILLEGAL_ARGUMENT_ERROR), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({ServiceException.class})
    public ResponseEntity<ExceptionResponse> handleControllerException(Exception e) {
        log.debug(e.getMessage(), e);
        return new ResponseEntity<>(new ExceptionResponse(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}