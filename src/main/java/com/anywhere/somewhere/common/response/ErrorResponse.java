package com.anywhere.somewhere.common.response;


import com.anywhere.somewhere.common.exception.custom.ErrorData;
import com.anywhere.somewhere.common.exception.custom.ErrorType;

public class ErrorResponse extends ApiResponse<ErrorData> {

    public ErrorResponse(ErrorType errorCode) {
        super(errorCode);
    }

    public ErrorResponse(ErrorType errorCode, ErrorData errorData) {
        super(errorCode, errorData);
    }

}
