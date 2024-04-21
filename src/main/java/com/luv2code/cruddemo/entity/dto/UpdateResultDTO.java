package com.luv2code.cruddemo.entity.dto;

public class UpdateResultDTO {
    private String message;

    public UpdateResultDTO(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
