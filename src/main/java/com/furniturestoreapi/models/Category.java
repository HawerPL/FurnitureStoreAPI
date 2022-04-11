package com.furniturestoreapi.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Category {

    @JsonProperty("id")
    public int Id;

    @JsonProperty("name")
    public String Name;

    @JsonProperty("description")
    public String Description;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        this.Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) { this.Name = name; }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        this.Description = description;
    }

}
