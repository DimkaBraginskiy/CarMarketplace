package org.example.carmarketplace.Mappers;

import org.example.carmarketplace.DTOs.Request.UserRequestDto;
import org.example.carmarketplace.DTOs.Response.UserResponseDto;
import org.example.carmarketplace.ENUMs.RoleName;
import org.example.carmarketplace.ENUMs.*;
import org.example.carmarketplace.Models.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserResponseDto toDto(User user){
        UserResponseDto dto = new UserResponseDto();
        dto.setId(user.getId());
        dto.setFirstName(user.getFirstName());
        dto.setMiddleName(user.getMiddleName());
        dto.setLastName(user.getLastName());
        dto.setEmail(user.getEmail());
        dto.setPhoneNumber(user.getPhoneNumber());
        dto.setRoleName(user.getRole());

        return dto;
    }

    public User toEntity(UserRequestDto dto) {
        User user = new User();
        user.setFirstName(dto.getFirstName());
        user.setMiddleName(dto.getMiddleName());
        user.setLastName(dto.getLastName());
        user.setEmail(dto.getEmail());
        user.setPhoneNumber(dto.getPhoneNumber());
        user.setPassword(dto.getPassword());
        user.setRole(dto.getRoleName());
        return user;
    }

}
