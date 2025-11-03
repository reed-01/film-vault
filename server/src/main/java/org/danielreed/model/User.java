package org.danielreed.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Objects;

/**
 * Model class representing an application user.
 *
 * Contains information about the user - their id, username, address information,
 * password (hashed) and authorities (user roles).
 */
public class User {

    private int id;
    private String username;
    @JsonIgnore
    private String hashedPassword;
    private String role;
    private String name;
    private String address;
    private String city;
    private String stateCode;
    private String zipCode;
    private Integer rating;

    public User() { }

    public User(int id, String username, String hashedPassword, String role, String name, String address, String city, String stateCode, String zipCode, Integer rating) {
        this.id = id;
        this.username = username;
        this.hashedPassword = hashedPassword;
        this.role = role;
        this.name = name;
        this.address = address;
        this.city = city;
        this.stateCode = stateCode;
        this.zipCode = zipCode;
        this.rating = rating;
    }

    public User(String username, String hashedPassword, String role, String name, String address, String city, String stateCode, String zipCode, Integer rating) {
        this(0, username, hashedPassword, role, name, address, city, stateCode, zipCode, rating);
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }
    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role != null && !role.startsWith("ROLE_")
                ? "ROLE_" + role.toUpperCase()
                : role;
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

    public Integer getRating() {
        return rating;
    }
    public void setRating(Integer rating) {
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                Objects.equals(username, user.username) &&
                Objects.equals(hashedPassword, user.hashedPassword) &&
                Objects.equals(role, user.role) &&
                Objects.equals(name, user.name) &&
                Objects.equals(address, user.address) &&
                Objects.equals(city, user.city) &&
                Objects.equals(stateCode, user.stateCode) &&
                Objects.equals(zipCode, user.zipCode) &&
                Objects.equals(rating, user.rating);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, hashedPassword, role, name, address, city, stateCode, zipCode, rating);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", hashedPassword='" + hashedPassword + '\'' +
                ", role='" + role + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", stateCode='" + stateCode + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", rating='" + rating + '\'' +
                '}';
    }
}
