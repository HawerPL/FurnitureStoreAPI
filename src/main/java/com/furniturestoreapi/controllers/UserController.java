package com.furniturestoreapi.controllers;


import com.furniturestoreapi.models.Enums;
import com.furniturestoreapi.models.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController()
@RequestMapping("User")
public class UserController {

    List<User> users = new ArrayList<>();

    public UserController(){
        User user0 = new User();
        user0.setId(0);
        user0.setLogin("Hawer");
        user0.setName("Hubert");
        user0.setSurname("Sobczyński");
        user0.setEmail("hawer123@gmail.com");
        user0.setRole(Enums.Role.ADMIN);
        user0.setToken("KochamKotki123");

        User user1 = new User();
        user1.setId(1);
        user1.setLogin("Dorad");
        user1.setName("Dominik");
        user1.setSurname("Radziszewski");
        user1.setEmail("dorad123@gmail.com");
        user1.setRole(Enums.Role.ADMIN);
        user1.setToken("KochamPieski123");

        User user2 = new User();
        user2.setId(2);
        user2.setLogin("Test");
        user2.setName("Imie");
        user2.setSurname("Nazwisko");
        user2.setEmail("test123@gmail.com");
        user2.setRole(Enums.Role.MODERATOR);
        user2.setToken("KochamKroliki123");

        users.add(user0);
        users.add(user1);
        users.add(user2);
    }

    @GetMapping()
    public ResponseEntity<List<User>> Get(){
        return ResponseEntity.ok(users);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> Get(@PathVariable int id) {

        User User = users.stream()
                .filter(x -> x.Id == id).findFirst().orElse(null);

        return ResponseEntity.ok(User);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> Delete(@PathVariable int id){

        User User = users.stream()
                .filter(x -> x.Id == id).findFirst().orElse(null);

        users.remove(User);

        return ResponseEntity.ok("User was deleted successfully");
    }

    @PostMapping()
    public ResponseEntity<String> Add(@RequestBody User User){
        users.add(User);
        return ResponseEntity.ok("User was added successfully");
    }
}
