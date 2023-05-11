package com.company.api.exception;

import static java.time.LocalDateTime.now;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import lombok.extern.slf4j.Slf4j;

/**
 * Exception handler to handle all types of exceptions originated with in the
 * API
 *
 */
@ControllerAdvice
@Slf4j
public class ExceptionAdvice extends ResponseEntityExceptionHandler {

	@ExceptionHandler(CustomerApiException.class)
	public final ResponseEntity<ErrorResponse> handleCustomerDetailsApiException(CustomerApiException ex,
			WebRequest request) {
		log.error("Exception thrown:", ex);
		return ResponseEntity.internalServerError().body(ErrorResponse.builder().timeStamp(now())
				.statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value()).message(ex.getMessage()).build());
	}

}
