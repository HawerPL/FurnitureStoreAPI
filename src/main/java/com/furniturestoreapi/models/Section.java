package com.furniturestoreapi.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "sections", schema = "fs_main")
public class Section {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    @Column(name = "s_id")
    public Long Id;

    @JsonProperty("name")
    @Column(name = "s_name")
    public String Name;

    @JsonProperty("description")
    @Column(name = "s_description")
    public String Description;

    @JsonProperty("order")
    @Column(name = "s_order")
    public int Order;

    protected Section(){}

    public Section(String name, String description, int order){
        this.Name = name;
        this.Description = description;
        this.Order = order;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getOrder() {
        return Order;
    }

    public void setOrder(int order) {
        Order = order;
    }
}
