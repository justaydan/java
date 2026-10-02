package com.lessons.exception;

import com.lessons.exception.AccountBlockedException;
import com.lessons.exception.CustomerBlockedException;
import com.lessons.exception.DailyLimitExceededException;
import com.lessons.exception.InsufficientFundsException;
import com.lessons.exception.InvalidRequestException;
import com.lessons.exception.InvalidStatusTransitionException;
import com.lessons.exception.PaymentException;
import com.lessons.exception.PostNotFoundException;
import com.lessons.exception.ServiceUnavailableException;
import com.lessons.exception.UnauthorizedException;
import com.lessons.model.response.ErrorResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidation(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors()
                .forEach(e -> errors.put(e.getField(), e.getDefaultMessage()));
        return ResponseEntity.unprocessableEntity().body(errors);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Map<String, String>> handleUnreadable(HttpMessageNotReadableException ex) {
        return ResponseEntity.badRequest().body(Map.of("error", ex.getMostSpecificCause().getMessage()));
    }

    @ExceptionHandler({NotFoundException.class, OrderNotFoundException.class, ProductNotFoundException.class, UserNotFoundException.class, PostNotFoundException.class})
    public ResponseEntity<ErrorResponseDto> handleNotFound(RuntimeException ex) {
        return ResponseEntity.status(404).body(new ErrorResponseDto(ex.getMessage(), 404, Instant.now()));
    }

    @ExceptionHandler(ServiceUnavailableException.class)
    public ResponseEntity<ErrorResponseDto> handleServiceUnavailable(ServiceUnavailableException ex) {
        return ResponseEntity.status(503).body(new ErrorResponseDto(ex.getMessage(), 503, Instant.now()));
    }

    @ExceptionHandler(OrderStatusTransitionException.class)
    public ResponseEntity<ErrorResponseDto> handleOrderStatusTransition(OrderStatusTransitionException ex) {
        return ResponseEntity.unprocessableEntity().body(new ErrorResponseDto(ex.getMessage(), 422, Instant.now()));
    }

    @ExceptionHandler(InvalidStatusTransitionException.class)
    public ResponseEntity<ErrorResponseDto> handleInvalidStatusTransition(InvalidStatusTransitionException ex) {
        return ResponseEntity.status(422).body(new ErrorResponseDto(ex.getMessage(), 422, Instant.now()));
    }

    @ExceptionHandler(CustomerBlockedException.class)
    public ResponseEntity<ErrorResponseDto> handleCustomerBlocked(CustomerBlockedException ex) {
        return ResponseEntity.status(403).body(new ErrorResponseDto(ex.getMessage(), 403, Instant.now()));
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponseDto> handleIllegalArgumentException(IllegalArgumentException ex) {
        return ResponseEntity.badRequest().body(new ErrorResponseDto(ex.getMessage(), 400, Instant.now()));
    }

    @ExceptionHandler(InvalidRequestException.class)
    public ResponseEntity<ErrorResponseDto> handleInvalidRequest(InvalidRequestException ex) {
        return ResponseEntity.badRequest().body(new ErrorResponseDto(ex.getMessage(), 400, Instant.now()));
    }

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<ErrorResponseDto> handleUnauthorized(UnauthorizedException ex) {
        return ResponseEntity.status(401).body(new ErrorResponseDto(ex.getMessage(), 401, Instant.now()));
    }

    @ExceptionHandler(InsufficientFundsException.class)
    public ResponseEntity<ErrorResponseDto> handleInsufficientFunds(InsufficientFundsException ex) {
        return ResponseEntity.status(422).body(new ErrorResponseDto(ex.getMessage(), 422, Instant.now()));
    }

    @ExceptionHandler(AccountBlockedException.class)
    public ResponseEntity<ErrorResponseDto> handleAccountBlocked(AccountBlockedException ex) {
        return ResponseEntity.status(403).body(new ErrorResponseDto(ex.getMessage(), 403, Instant.now()));
    }

    @ExceptionHandler(DailyLimitExceededException.class)
    public ResponseEntity<ErrorResponseDto> handleDailyLimitExceeded(DailyLimitExceededException ex) {
        return ResponseEntity.status(422).body(new ErrorResponseDto(ex.getMessage(), 422, Instant.now()));
    }

    @ExceptionHandler(PaymentException.class)
    public ResponseEntity<ErrorResponseDto> handlePaymentException(PaymentException ex) {
        return ResponseEntity.status(502).body(new ErrorResponseDto(ex.getMessage(), 502, Instant.now()));
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorResponseDto> handleRuntimeException(RuntimeException ex) {
        return ResponseEntity.internalServerError().body(new ErrorResponseDto(ex.getMessage(), 500, Instant.now()));
    }
}
