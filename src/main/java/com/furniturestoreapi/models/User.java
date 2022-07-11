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
    public Long id;

    @JsonProperty("login")
    @Column(name = "u_login")
    public String login;

    @JsonProperty("name")
    @Column(name = "u_name")
    public String name;

    @JsonProperty("surname")
    @Column(name = "u_surname")
    public String surname;

    @JsonProperty("email")
    @Column(name = "u_email")
    public String email;

    @JsonProperty("role")
    @Column(name = "u_role")
    public Enums.Role role;

    @JsonProperty("password")
    @Column(name = "u_password")
    public String password;

    public User(String login, String name, String surname, String email, Enums.Role role, String password) {
        this.login = login;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.role = role;
        this.password = password;
    }

    public User(String login, String password){
        this.login = login;
        this.password = password;
    }

    public User() {}
    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public String getLogin() {return login;}

    public void setLogin(String login) {this.login = login;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public String getSurname() {return surname;}

    public void setSurname(String surname) {this.surname = surname;}

    public String getEmail() {return email;}

    public void setEmail(String email) {this.email = email;}

    public String getPassword() {return password;}

    public void setPassword(String password) {this.password = password;}

    public Enums.Role getRole() {
        return role;
    }

    public void setRole(Enums.Role role) {
        this.role = role;
    }
}
