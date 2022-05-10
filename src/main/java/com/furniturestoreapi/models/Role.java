package com.furniturestoreapi.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Role {

    @JsonProperty("id")
    public int Id;

    public Enums.Rola Rola;

    public int getId() {return Id;}

    public void setId(int id) {Id = id;}

    public Enums.Rola getRola() {return Rola;}

    public void setRola(Enums.Rola rola) {Rola = rola;}
}


