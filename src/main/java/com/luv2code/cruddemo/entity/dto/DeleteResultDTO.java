package com.luv2code.cruddemo.entity.dto;

public class DeleteResultDTO {
    private String message;

    public DeleteResultDTO(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
