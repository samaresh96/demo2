/*
 * Copyright (C) YYYY-YYYY XXXXXXXXXXXXX
 * mailto:AAAA@DDDD.COM
 *
 */
package com.jcboe.home.instruction.exception;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

	private final Logger logger = LogManager.getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<ExceptionResponse> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex) {

		ExceptionResponse error = new ExceptionResponse();
		error.setError("INVALID_REQUEST");
		error.setMessage(ex.getMessage());
		logger.error("Error occuer homeinstructionException : {} ", ex.getMessage());
		error.setStatus(String.valueOf(HttpStatus.BAD_REQUEST.value()));
		return ResponseEntity.badRequest().body(error);
	}

	@ResponseStatus
	@ExceptionHandler(HomeInstructionException.class)
	public ResponseEntity<ExceptionResponse> handleInternalError(final HttpServletRequest request,
			final HomeInstructionException exception) {
		logger.error("Error occuer homeinstructionException : {} ", exception.getMessage());
		ExceptionResponse response = new ExceptionResponse();
		response.setError(exception.getErrorCode());
		response.setMessage(exception.getMessage());
		response.setStatus(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()));
		return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<ExceptionResponse> handleNoHandlerFound(NoHandlerFoundException ex) {

		ExceptionResponse response = new ExceptionResponse();
		response.setError("API endpoint not found ");
		response.setMessage(ex.getMessage());
		response.setStatus(String.valueOf(HttpStatus.NOT_FOUND.value()));
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	}

	/**
	 * HTTP Method Not Allowed
	 */
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public ResponseEntity<ExceptionResponse> handleMethodNotAllowed(HttpRequestMethodNotSupportedException ex) {

		ExceptionResponse response = new ExceptionResponse();
		response.setError("METHOD_NOT_ALLOWED");
		response.setMessage(ex.getMethod() + " method is not supported.");

		response.setStatus(String.valueOf(HttpStatus.METHOD_NOT_ALLOWED.value()));
		return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(response);
	}

	/**
	 * Unsupported Media Type
	 */
	@ExceptionHandler(HttpMediaTypeNotSupportedException.class)
	public ResponseEntity<ExceptionResponse> handleMediaType(HttpMediaTypeNotSupportedException ex) {

		ExceptionResponse response = new ExceptionResponse();
		response.setError("UNSUPPORTED_MEDIA_TYPE");
		response.setMessage("Content-Type is not supported.");
		response.setStatus(String.valueOf(HttpStatus.UNSUPPORTED_MEDIA_TYPE.value()));

		return ResponseEntity.status(HttpStatus.UNSUPPORTED_MEDIA_TYPE).body(response);
	}

	/**
	 * Catch All Exception
	 */
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ExceptionResponse> handleException(Exception ex) {

		logger.error("Unexpected Exception {}", ex.getMessage());

		ExceptionResponse response = new ExceptionResponse();
		response.setError("INTERNAL_SERVER_ERROR");
		response.setMessage("Something went wrong. Please try again later.");
		response.setStatus(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()));

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ExceptionResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {

		StringBuilder message = new StringBuilder();

		ex.getBindingResult().getFieldErrors().forEach(
				error -> message.append(error.getField()).append(" : ").append(error.getDefaultMessage()).append("; "));

		logger.error("Validation failed : {}", message);

		ExceptionResponse response = new ExceptionResponse();
		response.setError("VALIDATION_ERROR");
		response.setMessage(message.toString());
		response.setStatus(String.valueOf(HttpStatus.BAD_REQUEST.value()));

		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(MissingServletRequestParameterException.class)
	public ResponseEntity<ExceptionResponse> handleMissingServletRequestParameterException(
			MissingServletRequestParameterException ex) {

		logger.error("Missing Request Parameter : {}", ex.getMessage());

		ExceptionResponse response = new ExceptionResponse();
		response.setError("MISSING_PARAMETER");
		response.setMessage("Required request parameter '" + ex.getParameterName() + "' is missing.");
		response.setStatus(String.valueOf(HttpStatus.BAD_REQUEST.value()));
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(MissingPathVariableException.class)
	public ResponseEntity<ExceptionResponse> handleMissingPathVariableException(MissingPathVariableException ex) {

		logger.error("Missing Path Variable : {}", ex.getMessage());

		ExceptionResponse response = new ExceptionResponse();
		response.setError("MISSING_PATH_VARIABLE");
		response.setMessage("Required path variable '" + ex.getVariableName() + "' is missing.");
		response.setStatus(String.valueOf(HttpStatus.BAD_REQUEST.value()));
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public ResponseEntity<ExceptionResponse> handleMethodArgumentTypeMismatchException(
			MethodArgumentTypeMismatchException ex) {

		logger.error("Parameter Type Mismatch : {}", ex.getMessage());

		ExceptionResponse response = new ExceptionResponse();
		response.setError("TYPE_MISMATCH");

		response.setMessage(String.format("Parameter '%s' should be of type %s.", ex.getName(),
				ex.getRequiredType() != null ? ex.getRequiredType().getSimpleName() : ""));// NOSONAR

		response.setStatus(String.valueOf(HttpStatus.BAD_REQUEST.value()));
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(HttpMediaTypeNotAcceptableException.class)
	public ResponseEntity<ExceptionResponse> handleHttpMediaTypeNotAcceptableException(
			HttpMediaTypeNotAcceptableException ex) {

		logger.error("Media Type Not Acceptable : {}", ex.getMessage());

		ExceptionResponse response = new ExceptionResponse();
		response.setError("NOT_ACCEPTABLE");
		response.setMessage("Requested media type is not supported.");
		response.setStatus(String.valueOf(HttpStatus.NOT_ACCEPTABLE.value()));
		return new ResponseEntity<>(response, HttpStatus.NOT_ACCEPTABLE);
	}

	@ExceptionHandler(AccessDeniedException.class)
	public ResponseEntity<ExceptionResponse> handleAccessDeniedException(AccessDeniedException ex) {

		logger.error("Access Denied : {}", ex.getMessage());

		ExceptionResponse response = new ExceptionResponse();
		response.setError("ACCESS_DENIED");
		response.setMessage("You are not authorized to access this resource.");
		response.setStatus(String.valueOf(HttpStatus.FORBIDDEN.value()));

		return new ResponseEntity<>(response, HttpStatus.FORBIDDEN);
	}
}
