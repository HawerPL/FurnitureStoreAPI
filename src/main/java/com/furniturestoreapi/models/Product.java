package com.furniturestoreapi.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "products", schema = "fs_main")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    @Column(name = "p_id")
    private Long Id;

    @JsonProperty("name")
    @Column(name = "p_name")
    private String Name;

    @JsonProperty("description")
    @Column(name = "p_description")
    private String Description;

    @JsonProperty("header")
    @Column(name = "p_header")
    private String Header;

    @JsonProperty("image")
    @Column(name = "p_image")
    private byte[] image;

    @ManyToMany()//(mappedBy="category")
    @JsonProperty("categories")
    private Set<Category> Categories;

    protected Product() {}

    public Product(String name, String description, String header, Set<Category> categories){
        this.Name = name;
        this.Description = description;
        this.Header = header;
        this.Categories = categories;
    }

/*    public Product(String name, String description, String header){
        this.Name = name;
        this.Description = description;
        this.Header = header;
    }*/

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

    public String getHeader() {
        return Header;
    }

    public void setHeader(String header) {
        Header = header;
    }

    public Set<Category> getCategories() {
        return Categories;
    }

    public void setCategories(Set<Category> categories) {
        Categories = categories;
    }
}
