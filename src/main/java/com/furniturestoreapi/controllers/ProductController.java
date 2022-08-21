package com.furniturestoreapi.controllers;

import com.furniturestoreapi.accessingDataJPA.CategoryRepository;
import com.furniturestoreapi.accessingDataJPA.ProductRepository;
import com.furniturestoreapi.models.Message;
import com.furniturestoreapi.models.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController()
@RequestMapping("Product")
@CrossOrigin()
public class ProductController {

    ProductRepository productRepository;
    CategoryRepository categoryRepository;

    public ProductController(ProductRepository repository, CategoryRepository catRepository){
        this.productRepository = repository;
        this.categoryRepository = catRepository;
        /*
        Category category0 =
        Category category1 = new Category("Kuchnia");

        Set<Category> categories = new HashSet();
        categories.add(category0);
        categories.add(category1);*/

        Product product0 = new Product("Szafka wisząca", "To jest długi opis szafki wiszącej.", "Szafka wisząca", null, "");
        Product product1 = new Product("Narożnik", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam sit amet placerat metus. Sed porta neque lacus, ac iaculis dolor faucibus id. Fusce rutrum gravida libero id rutrum. Ut diam urna, feugiat vitae varius vitae, dignissim consectetur eros.", "Narożnik", null, "");
        Product product2 = new Product("Półka", "Nam lobortis orci a elit molestie maximus. Curabitur erat dolor, bibendum sed pretium in, ultricies vitae purus. Vestibulum in risus a dolor fermentum fermentum et eu est. Ut a mi mollis erat laoreet facilisis eu nec elit. Sed a turpis quam. Nam suscipit arcu eu neque porta, in accumsan quam semper.","Półka", null, "");

        if(productRepository.count() == 0){
            productRepository.save(product0);
            productRepository.save(product1);
            productRepository.save(product2);
        }
    }

    @GetMapping()
    public ResponseEntity<Iterable<Product>> Get(){
        return ResponseEntity.ok(productRepository.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Product>> Get(@PathVariable Long id) {

        return ResponseEntity.ok(productRepository.findById(id));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Message> Delete(@PathVariable Long id){

        productRepository.deleteById(id);
        Message message = new Message("Product was deleted successfully");

        return ResponseEntity.ok(message);
    }

    @PostMapping()
    public ResponseEntity<Message> Add(@RequestBody Product product){

        productRepository.save(product);
        Message message = new Message("Product was added successfully");

        return ResponseEntity.ok(message);
    }

}
