package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.DTO.UserRequestDto;
import com.example.demo.DTO.UserResponseDto;
import com.example.demo.service.UserService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserResponseDto>> listAll(){
        return ResponseEntity.status(HttpStatus.OK).body(userService.listAll());
    }

    @PostMapping
    public ResponseEntity<UserResponseDto> createUser(@Valid @RequestBody UserRequestDto userCreateDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(userCreateDto));
    } 

    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDto> updateUser(@Valid @RequestBody UserRequestDto userCreateDto, @PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(userService.updateUser(userCreateDto, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        userService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
