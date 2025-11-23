package com.example.demo.entity;

import java.time.LocalDate;
import org.springframework.beans.BeanUtils;
import com.example.demo.DTO.UserRequestDto;
import com.example.demo.DTO.UserResponseDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "Name is required!")
    @Size(min = 4, max = 50, message = "Invalid name length!")
    @Column(nullable = false, unique = true)
    private String name;

    @Email(message = "Invalid email!")
    @NotBlank(message = "Email is required!")
    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private LocalDate DateOfBirth;

    public User(UserResponseDto userDto){
            BeanUtils.copyProperties(userDto, this);
    }

    public User(UserRequestDto userCreateDto){
            BeanUtils.copyProperties(userCreateDto, this);
    }

}
