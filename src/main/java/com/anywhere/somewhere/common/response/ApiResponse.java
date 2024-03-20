package com.anywhere.somewhere.common.response;

import com.anywhere.somewhere.common.exception.custom.ErrorType;
import com.anywhere.somewhere.common.response.dto.Status;
import lombok.Getter;

@Getter
public class ApiResponse<T> {

    private Status status;

    private T data;

    public ApiResponse(ErrorType errorCode) {
        this.status = new Status(errorCode);
    }

    public ApiResponse(ErrorType errorCode, T data) {
        this.status = new Status(errorCode);
        this.data = data;
    }
}
