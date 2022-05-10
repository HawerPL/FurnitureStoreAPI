package com.furniturestoreapi.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {

    @JsonProperty("id")
    public int Id;

    @JsonProperty("nick")
    public String Nick;

    @JsonProperty("email")
    public String Email;

    @JsonProperty("password")
    public String Password;

    public int getId() {return Id;}

    public void setId(int id) {Id = id;}

    public String getNick() {return Nick;}

    public void setNick(String nick) {Nick = nick;}

    public String getEmail() {return Email;}

    public void setEmail(String email) {Email = email;}

    public String getPassword() {return Password;}

    public void setPassword(String password) {Password = password;}
}
