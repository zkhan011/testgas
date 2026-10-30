package com.dpw.gasws.api;

import com.dpw.gasws.repository.ProcedureRejectedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.UUID;

@RestControllerAdvice
public class ApiErrors extends ResponseEntityExceptionHandler {
    private static final Logger LOG = LoggerFactory.getLogger(ApiErrors.class);

    @ExceptionHandler(IllegalArgumentException.class)
    ProblemDetail invalid(IllegalArgumentException failure) {
        return ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, failure.getMessage());
    }

    @ExceptionHandler(ProcedureRejectedException.class)
    ProblemDetail rejected(ProcedureRejectedException failure) {
        return ProblemDetail.forStatusAndDetail(HttpStatus.UNPROCESSABLE_ENTITY, failure.getMessage());
    }

    @ExceptionHandler(DataAccessException.class)
    ResponseEntity<ProblemDetail> database(DataAccessException failure) {
        return failure(HttpStatus.SERVICE_UNAVAILABLE, "Database operation failed; check the outcome before retrying", failure);
    }

    @ExceptionHandler(Exception.class)
    ResponseEntity<ProblemDetail> unexpected(Exception failure) {
        return failure(HttpStatus.INTERNAL_SERVER_ERROR, "An unexpected error occurred", failure);
    }

    private ResponseEntity<ProblemDetail> failure(HttpStatus status, String detail, Exception failure) {
        String id = UUID.randomUUID().toString();
        LOG.error("Gate request failed; correlationId={}", id, failure);
        ProblemDetail problem = ProblemDetail.forStatusAndDetail(status, detail);
        problem.setProperty("correlationId", id);
        return ResponseEntity.status(status).header("X-Correlation-ID", id).body(problem);
    }
}
