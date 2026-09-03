package com.jcboe.home.instruction.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Arrays;
import java.util.Collections;

import javax.servlet.http.HttpServletRequest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;

class GlobalExceptionHandlerTest {

	private GlobalExceptionHandler handler;

	@BeforeEach
	void setUp() {
		handler = new GlobalExceptionHandler();
	}

	@Test
	void testConstructor() {
		assertNotNull(handler);
	}

	@Test
	void testHandleHttpMessageNotReadableException() {

		HttpMessageNotReadableException exception = Mockito.mock(HttpMessageNotReadableException.class);

		Mockito.when(exception.getMessage()).thenReturn("Malformed JSON request");

		ResponseEntity<ExceptionResponse> response = handler.handleHttpMessageNotReadableException(exception);

		assertNotNull(response);
		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
		assertNotNull(response.getBody());

		assertEquals("INVALID_REQUEST", response.getBody().getError());

		assertEquals("Malformed JSON request", response.getBody().getMessage());

		assertEquals("400", response.getBody().getStatus());
	}

	@Test
	void testHandleHttpMessageNotReadableException_NullMessage() {

		HttpMessageNotReadableException exception = Mockito.mock(HttpMessageNotReadableException.class);

		Mockito.when(exception.getMessage()).thenReturn(null);

		ResponseEntity<ExceptionResponse> response = handler.handleHttpMessageNotReadableException(exception);

		assertNotNull(response);
		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
		assertNotNull(response.getBody());

		assertEquals("INVALID_REQUEST", response.getBody().getError());

		assertEquals(null, response.getBody().getMessage());

		assertEquals("400", response.getBody().getStatus());
	}

	@Test
	void testHandleInternalError() {

		HttpServletRequest request = Mockito.mock(HttpServletRequest.class);

		HomeInstructionException exception = Mockito.mock(HomeInstructionException.class);

		Mockito.when(exception.getErrorCode()).thenReturn("HOME_INSTRUCTION_ERROR");

		Mockito.when(exception.getMessage()).thenReturn("Home instruction error");

		ResponseEntity<ExceptionResponse> response = handler.handleInternalError(request, exception);

		assertNotNull(response);
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());

		assertNotNull(response.getBody());

		assertEquals("HOME_INSTRUCTION_ERROR", response.getBody().getError());

		assertEquals("Home instruction error", response.getBody().getMessage());

		assertEquals("500", response.getBody().getStatus());
	}

	@Test
	void testHandleInternalError_NullValues() {

		HttpServletRequest request = Mockito.mock(HttpServletRequest.class);

		HomeInstructionException exception = Mockito.mock(HomeInstructionException.class);

		Mockito.when(exception.getErrorCode()).thenReturn(null);

		Mockito.when(exception.getMessage()).thenReturn(null);

		ResponseEntity<ExceptionResponse> response = handler.handleInternalError(request, exception);

		assertNotNull(response);
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());

		assertNotNull(response.getBody());

		assertEquals(null, response.getBody().getError());

		assertEquals(null, response.getBody().getMessage());

		assertEquals("500", response.getBody().getStatus());
	}

	@Test
	void testHandleNoHandlerFound() {

		NoHandlerFoundException exception = Mockito.mock(NoHandlerFoundException.class);

		Mockito.when(exception.getMessage()).thenReturn("No handler found");

		ResponseEntity<ExceptionResponse> response = handler.handleNoHandlerFound(exception);

		assertNotNull(response);
		assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());

		assertNotNull(response.getBody());

		assertEquals("API endpoint not found ", response.getBody().getError());

		assertEquals("No handler found", response.getBody().getMessage());

		assertEquals("404", response.getBody().getStatus());
	}

	@Test
	void testHandleNoHandlerFound_NullMessage() {

		NoHandlerFoundException exception = Mockito.mock(NoHandlerFoundException.class);

		Mockito.when(exception.getMessage()).thenReturn(null);

		ResponseEntity<ExceptionResponse> response = handler.handleNoHandlerFound(exception);

		assertNotNull(response);
		assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());

		assertNotNull(response.getBody());

		assertEquals(null, response.getBody().getMessage());
	}

	@Test
	void testHandleMethodNotAllowed() {

		HttpRequestMethodNotSupportedException exception = Mockito.mock(HttpRequestMethodNotSupportedException.class);

		Mockito.when(exception.getMethod()).thenReturn("POST");

		ResponseEntity<ExceptionResponse> response = handler.handleMethodNotAllowed(exception);

		assertNotNull(response);
		assertEquals(HttpStatus.METHOD_NOT_ALLOWED, response.getStatusCode());

		assertNotNull(response.getBody());

		assertEquals("METHOD_NOT_ALLOWED", response.getBody().getError());

		assertEquals("POST method is not supported.", response.getBody().getMessage());

		assertEquals("405", response.getBody().getStatus());
	}

	@Test
	void testHandleMethodNotAllowed_NullMethod() {

		HttpRequestMethodNotSupportedException exception = Mockito.mock(HttpRequestMethodNotSupportedException.class);

		Mockito.when(exception.getMethod()).thenReturn(null);

		ResponseEntity<ExceptionResponse> response = handler.handleMethodNotAllowed(exception);

		assertNotNull(response);
		assertEquals(HttpStatus.METHOD_NOT_ALLOWED, response.getStatusCode());

		assertNotNull(response.getBody());

		assertEquals("null method is not supported.", response.getBody().getMessage());
	}

	@Test
	void testHandleMediaType() {

		HttpMediaTypeNotSupportedException exception = Mockito.mock(HttpMediaTypeNotSupportedException.class);

		ResponseEntity<ExceptionResponse> response = handler.handleMediaType(exception);

		assertNotNull(response);
		assertEquals(HttpStatus.UNSUPPORTED_MEDIA_TYPE, response.getStatusCode());

		assertNotNull(response.getBody());

		assertEquals("UNSUPPORTED_MEDIA_TYPE", response.getBody().getError());

		assertEquals("Content-Type is not supported.", response.getBody().getMessage());

		assertEquals("415", response.getBody().getStatus());
	}

	@Test
	void testHandleException() {

		Exception exception = Mockito.mock(Exception.class);

		Mockito.when(exception.getMessage()).thenReturn("Unexpected error");

		ResponseEntity<ExceptionResponse> response = handler.handleException(exception);

		assertNotNull(response);
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());

		assertNotNull(response.getBody());

		assertEquals("INTERNAL_SERVER_ERROR", response.getBody().getError());

		assertEquals("Something went wrong. Please try again later.", response.getBody().getMessage());

		assertEquals("500", response.getBody().getStatus());
	}

	@Test
	void testHandleException_NullMessage() {

		Exception exception = Mockito.mock(Exception.class);

		Mockito.when(exception.getMessage()).thenReturn(null);

		ResponseEntity<ExceptionResponse> response = handler.handleException(exception);

		assertNotNull(response);
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());

		assertNotNull(response.getBody());

		assertEquals("INTERNAL_SERVER_ERROR", response.getBody().getError());

		assertEquals("Something went wrong. Please try again later.", response.getBody().getMessage());

		assertEquals("500", response.getBody().getStatus());
	}

	@Test
	void testHandleMethodArgumentNotValidException() {

		MethodArgumentNotValidException exception = Mockito.mock(MethodArgumentNotValidException.class);

		BindingResult bindingResult = Mockito.mock(BindingResult.class);

		FieldError fieldError = new FieldError("request", "studentId", "Student ID is required");

		Mockito.when(bindingResult.getFieldErrors()).thenReturn(Arrays.asList(fieldError));

		Mockito.when(exception.getBindingResult()).thenReturn(bindingResult);

		ResponseEntity<ExceptionResponse> response = handler.handleMethodArgumentNotValidException(exception);

		assertNotNull(response);
		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());

		assertNotNull(response.getBody());

		assertEquals("VALIDATION_ERROR", response.getBody().getError());

		assertEquals("studentId : Student ID is required; ", response.getBody().getMessage());

		assertEquals("400", response.getBody().getStatus());
	}

	@Test
	void testHandleMethodArgumentNotValidException_MultipleErrors() {

		MethodArgumentNotValidException exception = Mockito.mock(MethodArgumentNotValidException.class);

		BindingResult bindingResult = Mockito.mock(BindingResult.class);

		FieldError error1 = new FieldError("request", "studentId", "Student ID is required");

		FieldError error2 = new FieldError("request", "studentName", "Student name is required");

		Mockito.when(bindingResult.getFieldErrors()).thenReturn(Arrays.asList(error1, error2));

		Mockito.when(exception.getBindingResult()).thenReturn(bindingResult);

		ResponseEntity<ExceptionResponse> response = handler.handleMethodArgumentNotValidException(exception);

		assertNotNull(response);
		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());

		assertNotNull(response.getBody());

		assertEquals("VALIDATION_ERROR", response.getBody().getError());

		assertEquals("studentId : Student ID is required; " + "studentName : Student name is required; ",
				response.getBody().getMessage());

		assertEquals("400", response.getBody().getStatus());
	}

	@Test
	void testHandleMethodArgumentNotValidException_NoErrors() {

		MethodArgumentNotValidException exception = Mockito.mock(MethodArgumentNotValidException.class);

		BindingResult bindingResult = Mockito.mock(BindingResult.class);

		Mockito.when(bindingResult.getFieldErrors()).thenReturn(Collections.emptyList());

		Mockito.when(exception.getBindingResult()).thenReturn(bindingResult);

		ResponseEntity<ExceptionResponse> response = handler.handleMethodArgumentNotValidException(exception);

		assertNotNull(response);
		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());

		assertNotNull(response.getBody());

		assertEquals("VALIDATION_ERROR", response.getBody().getError());

		assertEquals("", response.getBody().getMessage());

		assertEquals("400", response.getBody().getStatus());
	}

	@Test
	void testHandleMethodArgumentNotValidException_NullDefaultMessage() {

		MethodArgumentNotValidException exception = Mockito.mock(MethodArgumentNotValidException.class);

		BindingResult bindingResult = Mockito.mock(BindingResult.class);

		FieldError fieldError = new FieldError("request", "studentId", null);

		Mockito.when(bindingResult.getFieldErrors()).thenReturn(Arrays.asList(fieldError));

		Mockito.when(exception.getBindingResult()).thenReturn(bindingResult);

		ResponseEntity<ExceptionResponse> response = handler.handleMethodArgumentNotValidException(exception);

		assertNotNull(response);
		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());

		assertNotNull(response.getBody());

		assertEquals("VALIDATION_ERROR", response.getBody().getError());

		assertEquals("studentId : null; ", response.getBody().getMessage());

		assertEquals("400", response.getBody().getStatus());
	}

	@Test
	void testHandleMissingServletRequestParameterException() {

		MissingServletRequestParameterException exception = Mockito.mock(MissingServletRequestParameterException.class);

		Mockito.when(exception.getParameterName()).thenReturn("studentId");

		ResponseEntity<ExceptionResponse> response = handler.handleMissingServletRequestParameterException(exception);

		assertNotNull(response);
		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());

		assertNotNull(response.getBody());

		assertEquals("MISSING_PARAMETER", response.getBody().getError());

		assertEquals("Required request parameter 'studentId' is missing.", response.getBody().getMessage());

		assertEquals("400", response.getBody().getStatus());
	}

	@Test
	void testHandleMissingServletRequestParameterException_NullParameter() {

		MissingServletRequestParameterException exception = Mockito.mock(MissingServletRequestParameterException.class);

		Mockito.when(exception.getParameterName()).thenReturn(null);

		ResponseEntity<ExceptionResponse> response = handler.handleMissingServletRequestParameterException(exception);

		assertNotNull(response);
		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());

		assertEquals("Required request parameter 'null' is missing.", response.getBody().getMessage());
	}

	@Test
	void testHandleMissingPathVariableException() {

		MissingPathVariableException exception = Mockito.mock(MissingPathVariableException.class);

		Mockito.when(exception.getVariableName()).thenReturn("applicationId");

		ResponseEntity<ExceptionResponse> response = handler.handleMissingPathVariableException(exception);

		assertNotNull(response);
		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());

		assertNotNull(response.getBody());

		assertEquals("MISSING_PATH_VARIABLE", response.getBody().getError());

		assertEquals("Required path variable 'applicationId' is missing.", response.getBody().getMessage());

		assertEquals("400", response.getBody().getStatus());
	}

	@Test
	void testHandleMissingPathVariableException_NullVariable() {

		MissingPathVariableException exception = Mockito.mock(MissingPathVariableException.class);

		Mockito.when(exception.getVariableName()).thenReturn(null);

		ResponseEntity<ExceptionResponse> response = handler.handleMissingPathVariableException(exception);

		assertNotNull(response);
		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());

		assertEquals("Required path variable 'null' is missing.", response.getBody().getMessage());
	}

	@Test
	void testHandleMethodArgumentTypeMismatchException_Long() {

		MethodArgumentTypeMismatchException exception = new MethodArgumentTypeMismatchException("123", Long.class,
				"studentId", null, new IllegalArgumentException("Invalid value"));

		ResponseEntity<ExceptionResponse> response = handler.handleMethodArgumentTypeMismatchException(exception);

		assertNotNull(response);
		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());

		assertNotNull(response.getBody());

		assertEquals("TYPE_MISMATCH", response.getBody().getError());

		assertEquals("Parameter 'studentId' should be of type Long.", response.getBody().getMessage());

		assertEquals("400", response.getBody().getStatus());
	}

	@Test
	void testHandleMethodArgumentTypeMismatchException_String() {

		MethodArgumentTypeMismatchException exception = new MethodArgumentTypeMismatchException("abc", String.class,
				"name", null, new IllegalArgumentException("Invalid value"));

		ResponseEntity<ExceptionResponse> response = handler.handleMethodArgumentTypeMismatchException(exception);

		assertNotNull(response);
		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());

		assertNotNull(response.getBody());

		assertEquals("TYPE_MISMATCH", response.getBody().getError());

		assertEquals("Parameter 'name' should be of type String.", response.getBody().getMessage());

		assertEquals("400", response.getBody().getStatus());
	}

	@Test
	void testHandleMethodArgumentTypeMismatchException_NullRequiredType() {

		MethodArgumentTypeMismatchException exception = Mockito.mock(MethodArgumentTypeMismatchException.class);

		Mockito.when(exception.getName()).thenReturn("studentId");

		Mockito.when(exception.getRequiredType()).thenReturn(null);

		ResponseEntity<ExceptionResponse> response = handler.handleMethodArgumentTypeMismatchException(exception);

		assertNotNull(response);
		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());

		assertNotNull(response.getBody());

		assertEquals("TYPE_MISMATCH", response.getBody().getError());

		assertEquals("Parameter 'studentId' should be of type .", response.getBody().getMessage());

		assertEquals("400", response.getBody().getStatus());
	}

	@Test
	void testHandleMethodArgumentTypeMismatchException_NullName() {

		MethodArgumentTypeMismatchException exception = new MethodArgumentTypeMismatchException("123", Integer.class,
				null, null, new IllegalArgumentException("Invalid value"));

		ResponseEntity<ExceptionResponse> response = handler.handleMethodArgumentTypeMismatchException(exception);

		assertNotNull(response);
		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
		assertNotNull(response.getBody());

		assertEquals("TYPE_MISMATCH", response.getBody().getError());

		assertEquals("Parameter 'null' should be of type Integer.", response.getBody().getMessage());

		assertEquals("400", response.getBody().getStatus());
	}

	@Test
	void testHandleHttpMediaTypeNotAcceptableException() {

		HttpMediaTypeNotAcceptableException exception = Mockito.mock(HttpMediaTypeNotAcceptableException.class);

		ResponseEntity<ExceptionResponse> response = handler.handleHttpMediaTypeNotAcceptableException(exception);

		assertNotNull(response);
		assertEquals(HttpStatus.NOT_ACCEPTABLE, response.getStatusCode());

		assertNotNull(response.getBody());

		assertEquals("NOT_ACCEPTABLE", response.getBody().getError());

		assertEquals("Requested media type is not supported.", response.getBody().getMessage());

		assertEquals("406", response.getBody().getStatus());
	}

	@Test
	void testHandleAccessDeniedException() {

		AccessDeniedException exception = Mockito.mock(AccessDeniedException.class);

		ResponseEntity<ExceptionResponse> response = handler.handleAccessDeniedException(exception);

		assertNotNull(response);
		assertEquals(HttpStatus.FORBIDDEN, response.getStatusCode());

		assertNotNull(response.getBody());

		assertEquals("ACCESS_DENIED", response.getBody().getError());

		assertEquals("You are not authorized to access this resource.", response.getBody().getMessage());

		assertEquals("403", response.getBody().getStatus());
	}

	@Test
	void testHandleAccessDeniedException_NullMessage() {

		AccessDeniedException exception = Mockito.mock(AccessDeniedException.class);

		Mockito.when(exception.getMessage()).thenReturn(null);

		ResponseEntity<ExceptionResponse> response = handler.handleAccessDeniedException(exception);

		assertNotNull(response);
		assertEquals(HttpStatus.FORBIDDEN, response.getStatusCode());

		assertNotNull(response.getBody());

		assertEquals("ACCESS_DENIED", response.getBody().getError());

		assertEquals("You are not authorized to access this resource.", response.getBody().getMessage());

		assertEquals("403", response.getBody().getStatus());
	}
}
