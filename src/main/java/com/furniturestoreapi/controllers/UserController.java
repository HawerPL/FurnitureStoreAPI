package com.furniturestoreapi.controllers;


import com.furniturestoreapi.accessingDataJPA.UserRepository;
import com.furniturestoreapi.models.Enums;
import com.furniturestoreapi.models.Message;
import com.furniturestoreapi.models.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController()
@RequestMapping("User")
public class UserController {

    UserRepository userRepository;

    public UserController(UserRepository repository){
        this.userRepository = repository;


        User user0 = new User();
        user0.setLogin("Hawer");
        user0.setName("Hubert");
        user0.setSurname("Sobczyński");
        user0.setEmail("hawer123@gmail.com");
        //user0.setRole(Enums.Role.ADMIN);
        user0.setToken("KochamKotki123");

        User user1 = new User();
        user1.setLogin("Dorad");
        user1.setName("Dominik");
        user1.setSurname("Radziszewski");
        user1.setEmail("dorad123@gmail.com");
        //user1.setRole(Enums.Role.ADMIN);
        user1.setToken("KochamPieski123");

        User user2 = new User();
        user2.setLogin("Test");
        user2.setName("Imie");
        user2.setSurname("Nazwisko");
        user2.setEmail("test123@gmail.com");
        //user2.setRole(Enums.Role.MODERATOR);
        user2.setToken("KochamKroliki123");

        if(userRepository.count() == 0){
            userRepository.save(user0);
            userRepository.save(user1);
            userRepository.save(user2);
        }
    }

    @GetMapping()
    public ResponseEntity<Iterable<User>> Get(){
        return ResponseEntity.ok(userRepository.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<User>> Get(@PathVariable Long id) {

        return ResponseEntity.ok(userRepository.findById(id));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Message> Delete(@PathVariable Long id){

        userRepository.deleteById(id);
        Message message = new Message("User was deleted successfully");

        return ResponseEntity.ok(message);
    }

    @PostMapping()
    public ResponseEntity<Message> Add(@RequestBody User user){
        userRepository.save(user);

        Message message = new Message("User was added successfully");
        return ResponseEntity.ok(message);
    }
}
