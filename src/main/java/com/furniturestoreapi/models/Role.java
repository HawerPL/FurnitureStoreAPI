package com.furniturestoreapi.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Role {

    @JsonProperty("id")
    public int Id;

    @JsonProperty("role")
    public Enums.Role Rola;

    public int getId() {return Id;}

    public void setId(int id) {Id = id;}

    public Enums.Role getRola() {
        return Rola;
    }

    public void setRola(Enums.Role rola) {
        Rola = rola;
    }
}


