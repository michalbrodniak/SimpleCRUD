package com.brodniak.coderslabcrud.controller.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class UserEntityExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(value = RuntimeException.class)
	protected ResponseEntity<Object> handleException(RuntimeException exception, WebRequest webRequest){
		final ErrorResponse response = ErrorResponse.builder()
				.code(HttpStatus.NOT_FOUND.value())
				.message(exception.getMessage())
				.build();

		return handleExceptionInternal(exception,  response, new HttpHeaders(), HttpStatus.NOT_FOUND, webRequest);
	}

	@Override
	protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
			HttpStatusCode statusCode, WebRequest request) {
		return super.handleExceptionInternal(ex, body, headers, statusCode, request);
	}
}
