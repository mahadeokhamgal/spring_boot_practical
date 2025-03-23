package com.practice.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.demo.Pojo.User;
import com.practice.demo.exeptions.ResourceNotFoundException;
import com.practice.demo.services.UserCrud;

@RestController
@RequestMapping("/api/user")
public class AllCrud {
    UserCrud allCrud;

    @Autowired
    public AllCrud(UserCrud crudAPI) {
        this.allCrud = crudAPI;
    }

    @GetMapping("")
    public ResponseEntity<User[]> getUsers() {
        User[] users = this.allCrud.getUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUser(@PathVariable Long userId) {
        User user = this.allCrud.getUser(userId);
        if (user == null) {
            throw new ResourceNotFoundException("User not found with");
        }
        return ResponseEntity.ok(user);
    }

    @PostMapping("")
    public ResponseEntity<String> createUser(@RequestBody User user) {
        this.allCrud.createUser(user);
        return ResponseEntity.ok("Created successfully");
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable long userId) {
        this.allCrud.deleteUser(userId);
        return ResponseEntity.ok("Deleted successfully");
    }

    @PatchMapping("")
    public ResponseEntity<String> updateUser(@RequestBody User user) {
        if (this.allCrud.getUser(user.getProfileId()) == null) {
            throw new ResourceNotFoundException("User not found to update");
        } else {
            this.allCrud.updateUser(user);
        }
        return ResponseEntity.ok("Success");
    }

}
