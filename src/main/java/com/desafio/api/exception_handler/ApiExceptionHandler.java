package com.desafio.api.exception_handler;

import com.desafio.domain.exception.BusinessException;
import com.desafio.domain.exception.ResourceInUseException;
import com.desafio.domain.exception.ResourceNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleUncaught(Exception ex, WebRequest request) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        ProblemType problemType = ProblemType.SYSTEM_ERROR;
        String detail = "An unexpected internal system error has occurred. "
                + "Please try again and if the problem persists, contact your system administrator.";

        ex.printStackTrace();

        Problem problem = createProblem(status, problemType, detail);

        return handleExceptionInternal(ex, problem, new HttpHeaders(), status, request);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {
        ProblemType problemType = ProblemType.INVALID_DATA;
        String detail = "One or more fields are invalid. Please fill in correctly and try again.";

        BindingResult bindingResult = ex.getBindingResult();

        List<Problem.Field> problemFields = bindingResult.getFieldErrors().stream()
                .map(fieldError -> Problem.Field.builder()
                        .name(fieldError.getField())
                        .errorMessage(fieldError.getDefaultMessage())
                        .build())
                .collect(Collectors.toList());

        Problem problem = createProblem(status, problemType, detail, problemFields);

        return handleExceptionInternal(ex, problem, headers, status, request);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        ProblemType problemType = ProblemType.RESOURCE_NOT_FOUND;
        String detail = ex.getMessage();

        Problem problem = createProblem(status, problemType, detail);

        return handleExceptionInternal(ex, problem, new HttpHeaders(), status, request);
    }

    @ExceptionHandler(ResourceInUseException.class)
    public ResponseEntity<?> handleResourceInUseException(ResourceInUseException ex, WebRequest request) {
        HttpStatus status = HttpStatus.CONFLICT;
        ProblemType problemType = ProblemType.RESOURCE_IN_USE;
        String detail = ex.getMessage();

        Problem problem = createProblem(status, problemType, detail);

        return handleExceptionInternal(ex, problem, new HttpHeaders(), status, request);
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<?> handleBusinessException(BusinessException ex, WebRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ProblemType problemType = ProblemType.BUSINESS_ERROR;
        String detail = ex.getMessage();

        Problem problem = createProblem(status, problemType, detail);

        return handleExceptionInternal(ex, problem, new HttpHeaders(), status, request);
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
                                                             HttpStatus status, WebRequest request) {
        if (ObjectUtils.isEmpty(body)) {
            body = Problem.builder()
                    .status(status.value())
                    .title(status.getReasonPhrase())
                    .build();
        }

        return super.handleExceptionInternal(ex, body, headers, status, request);
    }

    private Problem createProblem(HttpStatus status, ProblemType problemType, String detail) {
        return createProblem(status, problemType, detail, null);
    }

    private Problem createProblem(HttpStatus status, ProblemType problemType, String detail,
                                                 List<Problem.Field> problemFields) {
        return Problem.builder()
                .status(status.value())
                .type(problemType.getUri())
                .title(problemType.getTitle())
                .detail(detail)
                .fields(problemFields)
                .build();
    }

}
