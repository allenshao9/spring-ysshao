package com.amarsoft.ysshao.exception;

/**
 * @author ysshao
 * @create 2020-05-03 21:58
 */
public class ErrorResponse {

    private String message;
    private String errorTypeName;

    public ErrorResponse(Exception e) {
        this(e.getClass().getName(),e.getMessage());
    }

    public ErrorResponse(String errorTypeName, String message) {
        this.errorTypeName = errorTypeName;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getErrorTypeName() {
        return errorTypeName;
    }
}
