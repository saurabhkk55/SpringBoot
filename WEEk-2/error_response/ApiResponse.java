package com.web.webApplication.department.error_response;

import employee.response.ApiError;
import lombok.Builder;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Builder
public class ApiResponse<T> {
    private LocalDateTime timeStamp;
    private T data;
    private ApiError error;
}
