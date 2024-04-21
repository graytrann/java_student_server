package com.luv2code.cruddemo.entity.dto;

public class StudentInfoDTO {
    private int id;
   
    private String first_name;
    
    private String last_name;
    private String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String data){
        this.first_name = data;
    }

    public void setLastName(String data){
        this.last_name = data;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName(){return this.first_name;}

    public String getLastName(){return this.last_name;}

    

    // public StudentInfoDTO(String firstName, String lastName){
    //     this.firstName = firstName;
    //     this.lastName = lastName;
    // }

    public StudentInfoDTO(int id,String first_name, String last_name,String email){
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
    }
}
