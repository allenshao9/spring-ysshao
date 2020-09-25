package com.amarsoft.ysshao.exception;

/**
 * @author ysshao
 * @create 2020-05-03 21:59
 */
public class ResourceNotFoundException extends RuntimeException{
    private String message;

    public ResourceNotFoundException() {
        super();
    }

    public ResourceNotFoundException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
