package org.danielreed.model;

import jakarta.validation.constraints.NotEmpty;

/**
 * RegisterUserDto is a class used to hold the registration information for a new user
 * that's sent from the client to the server for the register endpoint.
 *
 * The acronym DTO is being used for "data transfer object". It means that this type of
 * class is specifically created to transfer data between the client and the server.
 */
public class RegisterUserDto {

    @NotEmpty
    private String username;
    @NotEmpty
    private String password;
    @NotEmpty
    private String confirmPassword;
    @NotEmpty(message = "Please select a role for this user.")
    private String role;
    @NotEmpty(message = "Name is required.")
    private String name;
    @NotEmpty(message = "Please supply your full mailing address, including state and zip.")
    private String address;
    @NotEmpty(message = "City is required.")
    private String city;
    @NotEmpty(message = "State code is required.")
    private String stateCode;
    @NotEmpty(message = "Zip code is required.")
    private String zipCode;

    public RegisterUserDto(String username, String password, String confirmPassword, String role, String name, String address, String city, String stateCode, String zipCode) {
        this.username = username;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.role = role;
        this.name = name;
        this.address = address;
        this.city = city;
        this.stateCode = stateCode;
        this.zipCode = zipCode;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }
    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    public String getStateCode() {
        return stateCode;
    }
    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public String getZipCode() {
        return zipCode;
    }
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public boolean isPasswordsMatch(){
        return password.equals(confirmPassword);
    }
}
