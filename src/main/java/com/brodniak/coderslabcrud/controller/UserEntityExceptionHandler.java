package com.brodniak.coderslabcrud.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class UserEntityExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(value = RuntimeException.class)
	protected ResponseEntity<Object> handleException(RuntimeException exception, WebRequest webRequest){
		return handleExceptionInternal(exception, exception.getMessage(), new HttpHeaders(), HttpStatus.NOT_FOUND, webRequest);
	}
}
