package org.eug.todo.exceptionhandler;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static org.eug.todo.Constants.ErrorMessages.ILLEGAL_ARGUMENT_ERROR;

@Log4j2
@ControllerAdvice(annotations = CustomExceptionHandler.class)
public class DefaultExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({IllegalArgumentException.class})
    public ResponseEntity<Object> handleValidationException(Exception e, WebRequest request) {
        log.debug(e.getMessage(), e);
        return this.handleExceptionInternal(e, new ExceptionResponse(ILLEGAL_ARGUMENT_ERROR), new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }
}