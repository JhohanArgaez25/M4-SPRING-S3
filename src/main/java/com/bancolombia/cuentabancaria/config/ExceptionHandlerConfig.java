package com.bancolombia.cuentabancaria.config;

import com.bancolombia.cuentabancaria.model.DomainException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionHandlerConfig {

    @Autowired
    private ObjectMapper mapper;

    @ExceptionHandler(DomainException.class)
    public ResponseEntity<Object> handleRequestApiException(
            HttpServletRequest request,
            DomainException domainException) {
        return new ResponseEntity<>(domainException.getErrorModel1(),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> manejarValidaciones(MethodArgumentNotValidException exception) {
        Map<String, String> errores = new HashMap<>();
        exception.getBindingResult().getAllErrors()
                .forEach((error) -> {
                    String parametro = ((FieldError) error).getField();
                    String mensaje = error.getDefaultMessage();
                    errores.put(parametro, mensaje);
                }
                );
        return new ResponseEntity<>(errores, HttpStatus.BAD_REQUEST);}
}
