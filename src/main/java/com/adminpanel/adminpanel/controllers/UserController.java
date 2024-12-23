package com.adminpanel.adminpanel.controllers;

import com.adminpanel.adminpanel.models.UserModel;
import com.adminpanel.adminpanel.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/view")
    public ResponseEntity<List<UserModel>> getUser(){

        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/view/{id}")
    public ResponseEntity<Optional<UserModel>> getUserById(@PathVariable long id){
       return new ResponseEntity<>(userService.getUserById(id),HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Optional<UserModel>> updateUser(@PathVariable long id, @RequestBody UserModel userModel){
        return new ResponseEntity<>(userService.updateUser(id,userModel),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HashMap<String,Boolean>> deleteUser(@PathVariable long id){
        return new ResponseEntity<>(userService.deleteUser(id),HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<UserModel> addUser(@RequestBody UserModel userModel){
        return new ResponseEntity<>(userService.addUser(userModel),HttpStatus.CREATED);
    }







}
