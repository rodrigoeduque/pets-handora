package br.com.rodrigoeduque.pets.exception;

import org.springframework.http.HttpStatusCode;

import java.util.List;

public class ApiErrorMessage {

    private HttpStatusCode status;
    private List<Object> errors;

    public ApiErrorMessage(HttpStatusCode status, List<Object> errors) {
        this.status = status;
        this.errors = errors;
    }

    public HttpStatusCode getStatus() {
        return status;
    }

    public List<Object> getErrors() {
        return errors;
    }
}
