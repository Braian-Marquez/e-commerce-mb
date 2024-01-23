package com.ecommerce.mb.payment.exceptions;

import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.ecommerce.mb.commons.exceptions.*;


@RestControllerAdvice
public class GlobalHandleException {

	@ExceptionHandler(value = ExternalServiceException.class)
	public ResponseEntity<ErrorDto> handleExternalServiceException(ExternalServiceException e) {
		ErrorDto response = new ErrorDto();
		ErrorResponse error = buildErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		response.setError(error);
		return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}


	@ExceptionHandler(InvalidCredentialsException.class)
	public ResponseEntity<ErrorDto> handleInvalidCredentialsException(InvalidCredentialsException e) {
		ErrorDto response = new ErrorDto();
		ErrorResponse error = buildErrorResponse(HttpStatus.UNAUTHORIZED, e.getMessage());
		response.setError(error);
		return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
	}

	@ExceptionHandler(value = NotFoundException.class)
	public ResponseEntity<ErrorDto> handleNotFoundException(NotFoundException e) {
		ErrorDto response = new ErrorDto();
		ErrorResponse error = buildErrorResponse(HttpStatus.NOT_FOUND, e.getMessage());
		response.setError(error);
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = UserAlreadyExistException.class)
	public ResponseEntity<ErrorDto> handleUserAlreadyExistException(UserAlreadyExistException e) {
		ErrorDto response = new ErrorDto();
		ErrorResponse error = buildErrorResponse(HttpStatus.BAD_REQUEST, e.getMessage());
		response.setError(error);
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = BadCredentialsException.class)
	public ResponseEntity<ErrorDto> handlBadCredentialsException(BadCredentialsException e) {
		ErrorDto response = new ErrorDto();
		ErrorResponse error = buildErrorResponse(HttpStatus.BAD_REQUEST, e.getMessage());
		response.setError(error);
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = InsufficientPermissionsException.class)
	public ResponseEntity<ErrorDto> handleInsufficientPermissionsException(InsufficientPermissionsException e) {
		ErrorDto response = new ErrorDto();
		ErrorResponse error = buildErrorResponse(HttpStatus.FORBIDDEN, e.getMessage());
		response.setError(error);
		return new ResponseEntity<>(response, HttpStatus.FORBIDDEN);
	}

	private ErrorResponse buildErrorResponse(HttpStatus httpStatus, String message) {
		ErrorResponse error = new ErrorResponse();
		error.setHttpStatusCode(httpStatus.value());
		error.getDescription().add(message);
		error.setTimestamp(LocalDateTime.now());
		return error;
	}

}
