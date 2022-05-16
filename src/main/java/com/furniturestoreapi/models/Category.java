package com.furniturestoreapi.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categories", schema = "fs_main")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("id")
    @Column(name = "c_id")
    public Long Id;

    @JsonProperty("name")
    @Column(name = "c_name")
    public String Name;

   /* @ManyToOne //(cascade = {CascadeType.ALL})
    @JsonProperty("products")
    public Product Product;*/

    protected Category() {}

    public Category(String name){
        this.Name = name;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        this.Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) { this.Name = name; }

}
