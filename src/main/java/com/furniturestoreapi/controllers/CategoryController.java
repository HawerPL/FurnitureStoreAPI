package com.furniturestoreapi.controllers;

import com.furniturestoreapi.models.Category;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController()
@RequestMapping("Category")
public class CategoryController {

    List<Category> categories = new ArrayList<>();

    public CategoryController(){
        Category category0 = new Category();
            category0.setId(0);
            category0.setName("Łazienka");
            category0.setDescription("TEST 0");

        Category category1 = new Category();
            category1.setId(1);
            category1.setName("Salon");
            category1.setDescription("TEST 1");

        Category category2 = new Category();
            category2.setId(2);
            category2.setName("Kuchnia");
            category2.setDescription("TEST 2");


        categories.add(category0);
        categories.add(category1);
        categories.add(category2);
    }

    @GetMapping()
    public ResponseEntity<List<Category>> Get(){
        return ResponseEntity.ok(categories);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Category> Get(@PathVariable int id) {

        Category category = categories.stream()
                .filter(x -> x.Id == id).findFirst().orElse(null);

        return ResponseEntity.ok(category);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> Delete(@PathVariable int id){

        Category category = categories.stream()
                .filter(x -> x.Id == id).findFirst().orElse(null);

        categories.remove(category);

        return ResponseEntity.ok("Category was deleted successfully");
    }

    @PostMapping()
    public ResponseEntity<String> Add(@RequestBody Category category){
        categories.add(category);
        return ResponseEntity.ok("Category was added successfully");
    }

}
