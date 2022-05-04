package com.furniturestoreapi.controllers;

import com.furniturestoreapi.models.Category;
import com.furniturestoreapi.models.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController()
@RequestMapping("Product")
public class ProductController {

    List<Product> products = new ArrayList<>();

    public ProductController(){
        Product product0 = new Product();
        product0.setId(0);
        product0.setName("Szafka wisząca");
        product0.setDescription("To jest długi opis szafki wiszącej.");
        product0.setHeader("Szafka wisząca");

        Product product1 = new Product();
        product1.setId(1);
        product1.setName("Narożnik");
        product1.setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam sit amet placerat metus. Sed porta neque lacus, ac iaculis dolor faucibus id. Fusce rutrum gravida libero id rutrum. Ut diam urna, feugiat vitae varius vitae, dignissim consectetur eros.");
        product1.setHeader("Narożnik");

        Product product2 = new Product();
        product2.setId(2);
        product2.setName("Półka");
        product2.setDescription("Nam lobortis orci a elit molestie maximus. Curabitur erat dolor, bibendum sed pretium in, ultricies vitae purus. Vestibulum in risus a dolor fermentum fermentum et eu est. Ut a mi mollis erat laoreet facilisis eu nec elit. Sed a turpis quam. Nam suscipit arcu eu neque porta, in accumsan quam semper.");
        product2.setHeader("Półk");


        products.add(product0);
        products.add(product1);
        products.add(product2);
    }

    @GetMapping()
    public ResponseEntity<List<Product>> Get(){
        return ResponseEntity.ok(products);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> Get(@PathVariable int id) {

        Product Product = products.stream()
                .filter(x -> x.Id == id).findFirst().orElse(null);

        return ResponseEntity.ok(Product);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> Delete(@PathVariable int id){

        Product Product = products.stream()
                .filter(x -> x.Id == id).findFirst().orElse(null);

        products.remove(Product);

        return ResponseEntity.ok("Product was deleted successfully");
    }

    @PostMapping()
    public ResponseEntity<String> Add(@RequestBody Product Product){
        products.add(Product);
        return ResponseEntity.ok("Product was added successfully");
    }

}
