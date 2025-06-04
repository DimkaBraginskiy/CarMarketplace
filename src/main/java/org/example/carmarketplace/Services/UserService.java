package org.example.carmarketplace.Services;

import org.example.carmarketplace.DTOs.Request.UserRequestDto;
import org.example.carmarketplace.DTOs.Response.UserResponseDto;
import org.example.carmarketplace.Mappers.UserMapper;
import org.example.carmarketplace.ENUMs.*;
import org.example.carmarketplace.Models.User;
import org.example.carmarketplace.Repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository,UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UserResponseDto getUserById(Long id){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return userMapper.toDto(user);
    }

    public User createUser(UserRequestDto dto){
        User user = userMapper.toEntity(dto);
        return userRepository.save(user);
    }

    public List<UserResponseDto> getAllUsers(){
        return userRepository.findAll()
                .stream()
                .map(userMapper::toDto)
                .toList();
    }
}
