package com.furniturestoreapi.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.furniturestoreapi.accessingDataJPA.CategoryRepository;
import com.furniturestoreapi.models.Category;
import com.furniturestoreapi.models.Message;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController()
@CrossOrigin()
@RequestMapping("Category")
public class CategoryController {

    CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository repository){
        this.categoryRepository = repository;

        Category category0 = new Category("Łazienka");
        Category category1 = new Category("Salon");
        Category category2 = new Category("Kuchnia");

        if(categoryRepository.count() == 0){
            categoryRepository.save(category0);
            categoryRepository.save(category1);
            categoryRepository.save(category2);
        }
    }

    @GetMapping()
    public ResponseEntity<Iterable<Category>> Get(){
        return ResponseEntity.ok(categoryRepository.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Category>> Get(@PathVariable Long id) {
        return ResponseEntity.ok(categoryRepository.findById(id));
    }

    @DeleteMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<Message> Delete(@PathVariable Long id){

        categoryRepository.deleteById(id);
        Message message = new Message("Category was deleted successfully");

        return ResponseEntity.ok(message);
    }

    @PostMapping()
    public ResponseEntity<Message> Add(@RequestBody Category category){
        categoryRepository.save(category);

        Message message = new Message("Category was added successfully");
        return ResponseEntity.ok(message);
    }

}
