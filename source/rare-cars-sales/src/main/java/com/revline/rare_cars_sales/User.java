package com.revline.rare_cars_sales;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userID;

    @Column(unique = true)
    private String username;

    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private boolean isAdministrator = false;

    public User() {}

    //constructor
    public User(String username, String password, String firstName, String lastName, String email, boolean isAdministrator) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.isAdministrator = isAdministrator;
    }

    //Getters
    public Long getUserID() {
        return userID;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public boolean isAdministrator() {
        return isAdministrator;
    }

    //Setters
    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAdministrator(boolean administrator) {
        isAdministrator = administrator;
    }
}
