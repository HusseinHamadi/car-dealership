package org.example.cardealership.advice;

import org.example.cardealership.exception.ConflictException;
import org.example.cardealership.exception.ErrorResponse;
import org.example.cardealership.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.List;

@RestControllerAdvice
public class ExceptionControllerAdvice {



    //webRequest is to get data about the current http request, we need it to get the url
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponse> exceptionNotFoundHandler(NotFoundException ex, WebRequest request){
        ErrorResponse errorResponse = new ErrorResponse(LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                "Bad Request",
                ex.getMessage(),
                request.getDescription(false).replace("uri=", "")
        );
        return ResponseEntity.badRequest().body(errorResponse);
    }

    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<ErrorResponse> exceptionConflictHandler(ConflictException ex, WebRequest request){
        ErrorResponse errorResponse = new ErrorResponse(
                LocalDateTime.now(),
                HttpStatus.CONFLICT.value(),
                "Conflicted values.",
                ex.getMessage(),
                request.getDescription(false).replace("uri=", "")
        );
        return ResponseEntity.badRequest().body(errorResponse);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> exceptionMethodArgumentsNotValidHandler(MethodArgumentNotValidException ex, WebRequest request){

        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> error.getField()+": "+error.getDefaultMessage())
                .toList();

        ErrorResponse errorResponse = new ErrorResponse(
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                "Invalid input values.",
                String.join("; ", errors),
                request.getDescription(false).replace("uri=", "")
        );
        return ResponseEntity.badRequest().body(errorResponse);
    }
}
