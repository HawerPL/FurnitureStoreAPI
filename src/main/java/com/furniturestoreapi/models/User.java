package com.furniturestoreapi.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {

    @JsonProperty("id")
    public int Id;

    @JsonProperty("login")
    public String Login;

    @JsonProperty("name")
    public String Name;

    @JsonProperty("surname")
    public String Surname;

    @JsonProperty("email")
    public String Email;

    @JsonProperty("role")
    public String Role;

    @JsonProperty("token")
    public String Token;

    public int getId() {return Id;}

    public void setId(int id) {Id = id;}

    public String getLogin() {return Login;}

    public void setLogin(String login) {Login = login;}

    public String getName() {return Name;}

    public void setName(String name) {Name = name;}

    public String getSurname() {return Surname;}

    public void setSurname(String surname) {Surname = surname;}

    public String getEmail() {return Email;}

    public void setEmail(String email) {Email = email;}

    public String getRole() {return Role;}

    public void setRole(String role) {Role = role;}

    public String getToken() {return Token;}

    public void setToken(String token) {Token = token;}
}
