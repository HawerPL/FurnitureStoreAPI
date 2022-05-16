package com.furniturestoreapi.controllers;

import com.furniturestoreapi.accessingDataJPA.CategoryRepository;
import com.furniturestoreapi.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController()
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

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> Delete(@PathVariable Long id){

        categoryRepository.deleteById(id);

        return ResponseEntity.ok("Category was deleted successfully");
    }

    @PostMapping()
    public ResponseEntity<String> Add(@RequestBody Category category){
        categoryRepository.save(category);
        return ResponseEntity.ok("Category was added successfully");
    }

}
