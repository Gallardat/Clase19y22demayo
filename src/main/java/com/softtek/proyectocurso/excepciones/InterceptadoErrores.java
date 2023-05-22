package com.softtek.proyectocurso.excepciones;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.stream.Collectors;

@ControllerAdvice
@RestController
public class InterceptadoErrores extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final   ResponseEntity<Excepcionespuesta>manejadorTodasLasExcepciones(Exception ex, WebRequest request){
       Excepcionespuesta respuesta = new Excepcionespuesta(LocalDateTime.now(),
               ex.getMessage(),request.getDescription(false));
        return new ResponseEntity<>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(ExcepcionNoEncontrado.class)
    public ResponseEntity<Excepcionespuesta>manejadorTodasLasExcepciones(ExcepcionNoEncontrado ex, WebRequest request){
        Excepcionespuesta respuesta = new Excepcionespuesta(LocalDateTime.now(),
                ex.getMessage(),request.getDescription(false));
        return new ResponseEntity<>(respuesta, HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        String mensaje = ex.getBindingResult().getAllErrors().stream().map(e->e.getDefaultMessage()).collect(Collectors.joining());
    return new ResponseEntity<>(new Excepcionespuesta(LocalDateTime.now(),mensaje,request.getDescription(false)),HttpStatus.BAD_REQUEST);
    }


}
