package com.example.autoservice.exception.handlers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.skypro.homework.exception.InvalidParametersExeption;
import ru.skypro.homework.exception.MarketNotFoundException;
import ru.skypro.homework.exception.UnauthorizedExeption;

@ControllerAdvice
public class NotFoundPasteController {
    @ExceptionHandler(MarketNotFoundException.class)
    public ResponseEntity<?> notFound() {
        return ResponseEntity.status(404).body("Not Found");
    }

    @ExceptionHandler(InvalidParametersExeption.class)
    public ResponseEntity<?> invalidParam() {
        return ResponseEntity.status(400).body("Bed request");
    }

    @ExceptionHandler(UnauthorizedExeption.class)
    public ResponseEntity<?> unauthorized() {
        return ResponseEntity.status(401).body("Unauthorized");
    }
}
