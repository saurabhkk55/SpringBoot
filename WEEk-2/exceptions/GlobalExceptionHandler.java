package com.web.webApplication.department.exceptions;

import employee.exceptions.SaurabhException;
import employee.response.ApiError;
import employee.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {
//  1.3
    @ExceptionHandler(SaurabhException.class)
    public ResponseEntity<ApiError> handleDepartmentCustomException(DepartmentException deptException) {
        ApiError apiError = ApiError
                .builder()
                .status(HttpStatus.BAD_REQUEST)
                .message(deptException.getMessage())
                .subErrors(Collections.emptyList())
                .build();
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<?>> handleInputValidationErrors(MethodArgumentNotValidException exception) {
        List<String> errors = exception
                .getBindingResult()
                .getAllErrors()
                .stream()
                .map(error -> error.getDefaultMessage())
                .collect(Collectors.toList());
        ApiError apiError = ApiError
                .builder()
                .status(HttpStatus.BAD_REQUEST)
                .message("Input validation failed")
                .subErrors(errors)
                .build();
        return buildErrorResponseEntity(apiError);
    }

    private ResponseEntity<ApiResponse<?>> buildErrorResponseEntity(ApiError apiError) {
        ApiResponse<Object> apiResponse = ApiResponse
                .builder()
                .timeStamp(LocalDateTime.now())
                .data(null)
                .error(apiError)
                .build();

        return new ResponseEntity<>(apiResponse, apiError.getStatus());
    }

////  1
//    @ExceptionHandler(DepartmentException.class)
//    public ResponseEntity<String> handleDepartmentCustomException(DepartmentException deptException) {
////        return new ResponseEntity<>("Something is wrong", HttpStatus.BAD_REQUEST);
//        return new ResponseEntity<>(deptException.getMessage(), HttpStatus.BAD_REQUEST);
//    }

////  1.1
//    @ExceptionHandler(DepartmentException.class)
//    public ResponseEntity<ApiError> handleDepartmentCustomException(DepartmentException deptException) {
//        ApiError apiError = ApiError
//                .builder()
//                .status(HttpStatus.BAD_REQUEST)
//                .message(deptException.getMessage())
//                .subErrors(Collections.emptyList())
//                .build();
//        return new ResponseEntity<>(apiError, apiError.getStatus());
//    }
//
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<ApiError> handleInputValidationErrors(MethodArgumentNotValidException exception) {
//        List<String> errors = exception
//                .getBindingResult()
//                .getAllErrors()
//                .stream()
//                .map(error -> error.getDefaultMessage())
//                .collect(Collectors.toList());
//
//        ApiError apiError = ApiError
//                .builder()
//                .status(HttpStatus.BAD_REQUEST)
//                .message("Input validation failed")
//                .subErrors(errors)
//                .build();
//        System.out.println("------------------------");
//        return new ResponseEntity<>(apiError, apiError.getStatus());
//    }
}
