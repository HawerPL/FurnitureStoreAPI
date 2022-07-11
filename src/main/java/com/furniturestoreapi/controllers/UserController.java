package com.furniturestoreapi.controllers;


import com.furniturestoreapi.accessingDataJPA.UserRepository;
import com.furniturestoreapi.models.Message;
import com.furniturestoreapi.models.User;
import com.furniturestoreapi.services.JwtUserDetailsService;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController()
@RequestMapping("User")
public class UserController {

    PasswordEncoder passwordEncoder =  new BCryptPasswordEncoder();
    UserRepository userRepository;

    public UserController(UserRepository repository){
        this.userRepository = repository;


        User user0 = new User();
        user0.setLogin("Hawer");
        user0.setName("Hubert");
        user0.setSurname("Sobczyński");
        user0.setEmail("hawer123@gmail.com");
        //user0.setRole(Enums.Role.ADMIN);
        user0.setPassword(passwordEncoder.encode("test"));

        User user1 = new User();
        user1.setLogin("Dorad");
        user1.setName("Dominik");
        user1.setSurname("Radziszewski");
        user1.setEmail("dorad123@gmail.com");
        //user1.setRole(Enums.Role.ADMIN);
        user1.setPassword(passwordEncoder.encode("test123"));

        User user2 = new User();
        user2.setLogin("Test");
        user2.setName("Imie");
        user2.setSurname("Nazwisko");
        user2.setEmail("test123@gmail.com");
        //user2.setRole(Enums.Role.MODERATOR);
        user2.setPassword(passwordEncoder.encode("Test"));

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

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        userRepository.save(user);

        Message message = new Message("User was added successfully");
        return ResponseEntity.ok(message);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Message> Update(@PathVariable Long id, @RequestBody User user) throws Exception {
        Message message = new Message("");
        try {
            if (userRepository.existsByLogin(user.getLogin()) && userRepository.findByLogin(user.getLogin()).getId() != user.getId()) {
                throw new Exception("User with this login " + user.getLogin() + " already exists.");
            }
            user.setPassword(userRepository.getById(id).getPassword());

            if(userRepository.existsById(user.id)){
                userRepository.save(user);
                message.setMessage("User was updated successfully");
                return ResponseEntity.ok(message);
            } else {
                return (ResponseEntity<Message>) ResponseEntity.notFound();
            }
        } catch (Exception e) {
            message.setMessage(e.getMessage());
            return ResponseEntity.ok(message);
        }
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<Message> UpdatePassword(@PathVariable Long id, @RequestBody User user) throws Exception{
        Message message = new Message("");
        try {
            if (user.getPassword().length() < 6) {
                throw new Exception("Password is too short");
            }
            if(userRepository.existsById(user.id)){
                userRepository.updatePassword(passwordEncoder.encode(user.getPassword()), user.getLogin());
                message.setMessage("User's password was updated successfully");
            }
            return ResponseEntity.ok(message);
        } catch (Exception e) {
            message.setMessage(e.getMessage());
            return ResponseEntity.ok(message);
        }
    }
}
