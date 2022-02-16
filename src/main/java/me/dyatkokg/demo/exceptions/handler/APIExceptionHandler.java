package me.dyatkokg.demo.exceptions.handler;

import lombok.extern.slf4j.Slf4j;
import me.dyatkokg.demo.exceptions.ResumeNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class APIExceptionHandler {

    @ExceptionHandler({ResumeNotFoundException.class})
    public ResponseEntity<Object> handleResumeNotFound(ResumeNotFoundException exception) {
        log.error(exception.getMessage());
        return ResponseEntity.noContent().build();
    }

}
