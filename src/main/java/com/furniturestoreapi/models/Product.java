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
    private Long id;

    @JsonProperty("name")
    @Column(name = "p_name")
    private String name;

    @JsonProperty("description")
    @Column(name = "p_description")
    private String description;

    @JsonProperty("header")
    @Column(name = "p_header")
    private String header;

    @JsonProperty("image")
    @Column(name = "p_image")
    //private byte[] image;
    private String image;

    @ManyToMany()//(mappedBy="category")
    @JsonProperty("categories")
    private Set<Category> categories;

    protected Product() {}

    public Product(String name, String description, String header, Set<Category> categories, String image){
        this.name = name;
        this.description = description;
        this.header = header;
        this.categories = categories;
        this.image = image;
    }

/*    public Product(String name, String description, String header){
        this.Name = name;
        this.Description = description;
        this.Header = header;
    }*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }
}
