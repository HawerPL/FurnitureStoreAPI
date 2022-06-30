package com.furniturestoreapi.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "users", schema = "fs_main")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    @Column(name = "u_id")
    public Long Id;

    @JsonProperty("login")
    @Column(name = "u_login")
    public String Login;

    @JsonProperty("name")
    @Column(name = "u_name")
    public String Name;

    @JsonProperty("surname")
    @Column(name = "u_surname")
    public String Surname;

    @JsonProperty("email")
    @Column(name = "u_email")
    public String Email;

    @JsonProperty("role")
    @Column(name = "u_role")
    public Enums.Role role;

    @JsonProperty("token")
    @Column(name = "u_token")
    public String Token;

    public User(String login, String name, String surname, String email, Enums.Role role, String token) {
        Login = login;
        Name = name;
        Surname = surname;
        Email = email;
        this.role = role;
        Token = token;
    }

    public User() {}
    public Long getId() {return Id;}

    public void setId(Long id) {Id = id;}

    public String getLogin() {return Login;}

    public void setLogin(String login) {Login = login;}

    public String getName() {return Name;}

    public void setName(String name) {Name = name;}

    public String getSurname() {return Surname;}

    public void setSurname(String surname) {Surname = surname;}

    public String getEmail() {return Email;}

    public void setEmail(String email) {Email = email;}

    public String getToken() {return Token;}

    public void setToken(String token) {Token = token;}

    public Enums.Role getRole() {
        return role;
    }

    public void setRole(Enums.Role role) {
        this.role = role;
    }
}
