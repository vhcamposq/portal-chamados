package com.vhcamposq.portalchamados.shared.api;

import com.vhcamposq.portalchamados.shared.exception.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import java.time.Instant;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiError> handleNotFound(ResourceNotFoundException ex, HttpServletRequest request) {
		return buildError(HttpStatus.NOT_FOUND, ex.getMessage(), request.getRequestURI(), null);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ApiError> handleValidation(MethodArgumentNotValidException ex, HttpServletRequest request) {
		Map<String, Object> details = new LinkedHashMap<>();
		Map<String, String> fieldErrors = new LinkedHashMap<>();

		ex.getBindingResult().getFieldErrors().forEach(err -> fieldErrors.put(err.getField(), err.getDefaultMessage()));
		details.put("fieldErrors", fieldErrors);

		return buildError(HttpStatus.BAD_REQUEST, "Validation failed", request.getRequestURI(), details);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ApiError> handleGeneric(Exception ex, HttpServletRequest request) {
		return buildError(HttpStatus.INTERNAL_SERVER_ERROR, "Unexpected error", request.getRequestURI(), null);
	}

	private ResponseEntity<ApiError> buildError(
			HttpStatus status,
			String message,
			String path,
			Map<String, Object> details
	) {
		ApiError body = new ApiError(
				Instant.now(),
				status.value(),
				status.getReasonPhrase(),
				message,
				path,
				details
		);
		return ResponseEntity.status(status).body(body);
	}
}
