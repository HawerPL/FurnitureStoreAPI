package com.furniturestoreapi.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Role {

    @JsonProperty("id")
    public int Id;

    @JsonProperty("role")
    public Enums.Role Role;

    public int getId() {return Id;}

    public void setId(int id) {Id = id;}

    public Enums.Role getRola() {
        return Role;
    }

    public void setRola(Enums.Role rola) {
        Role = rola;
    }
}


