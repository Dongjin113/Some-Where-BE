package com.anywhere.somewhere.common.response.dto;


import com.anywhere.somewhere.common.exception.custom.ErrorType;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Status {
    private String code;
    private String message;

    public Status(ErrorType errorCode) {
        this.code = errorCode.getCode();
        this.message = errorCode.getMessage();
    }
}
