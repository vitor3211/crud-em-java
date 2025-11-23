package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.User;
import com.example.demo.exception.UserAlreadyExistsException;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.DTO.UserRequestDto;
import com.example.demo.DTO.UserResponseDto;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    
    public List<UserResponseDto> listAll(){
        List<User> users = userRepository.findAll();
        return users.stream().map(UserResponseDto::new).toList();
    }

    public UserResponseDto createUser(UserRequestDto userRequestDto){
        if(userRepository.existsByName(new User(userRequestDto).getName())){
            throw new UserAlreadyExistsException("Username is already in use!");
        }
        if(userRepository.existsByEmail(new User(userRequestDto).getEmail())){
            throw new UserAlreadyExistsException("Email address is already in use!");
        }
        User user = userRepository.save(new User(userRequestDto));
        return new UserResponseDto(user);
    }

    public UserResponseDto updateUser(UserRequestDto userRequestDto, Long id){
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found with id "+id));
        user.setName(userRequestDto.getName());
        user.setEmail(userRequestDto.getEmail());
        user.setDateOfBirth(userRequestDto.getDateOfBirth());
        User newUser = userRepository.save(user);
        return new UserResponseDto(newUser);
    }

    public void deleteById(Long id){
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found with id "+id));
        userRepository.delete(user);
    }
    

}
