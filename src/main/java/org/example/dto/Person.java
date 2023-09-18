package org.example.dto;

import org.example.annotation.*;

@ValidBean("person")
public class Person {

    @MinLength(6)
    @MaxLength(12)
    @NotEmpty
    private String login;
    @MinLength(8)
    private String password;
    @Email(regex = "^[A-Z0-9._]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$")
    private String email;
    @NotEmpty
    private String firstName;
    @NotEmpty
    private String lastName;


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}