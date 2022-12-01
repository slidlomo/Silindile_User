package za.flatrock.assessment.demo.models;

import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import za.flatrock.assessment.demo.exceptions.ErrorMessage;

@NoArgsConstructor
public class CreateUserResponse {

    Long id;
    String name;
    String surname;

    String phoneNumber;

    String role;

    String errorMessage;
    HttpStatus errorStatus;


    public CreateUserResponse(Long id, String name, String surname, String phoneNumber, String role) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.phoneNumber=phoneNumber;
        this.role=role;


    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public HttpStatus  getErrorStatus() {
        return errorStatus;
    }

    public void setErrorStatus(HttpStatus errorStatus) {
        this.errorStatus = errorStatus;
    }
}
