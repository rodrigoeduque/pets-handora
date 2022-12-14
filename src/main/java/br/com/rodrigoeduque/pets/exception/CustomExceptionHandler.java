package br.com.rodrigoeduque.pets.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

        List<Object> errors = new ArrayList<>();

        ex.getBindingResult().getFieldErrors().stream().forEach(x -> {

            Map<String, Object> map = new HashMap<>();
            map.put("field : ", x.getField());
            map.put("message : ", x.getDefaultMessage());
            map.put("value : ", x.getRejectedValue());

            errors.add(map);

        });

        ApiErrorMessage apiErrorMessage = new ApiErrorMessage(status, errors);


        return new ResponseEntity<>(apiErrorMessage, apiErrorMessage.getStatus());
    }
}
