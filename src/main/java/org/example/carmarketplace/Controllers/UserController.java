package org.example.carmarketplace.Controllers;

import org.example.carmarketplace.DTOs.Request.UserRequestDto;
import org.example.carmarketplace.DTOs.Response.UserResponseDto;
import org.example.carmarketplace.Mappers.UserMapper;
import org.example.carmarketplace.Models.User;
import org.example.carmarketplace.Services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> getUserById(@PathVariable long id){
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDto>> getAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PostMapping
    public ResponseEntity<UserResponseDto> createUser(@RequestBody UserRequestDto dto){
        User user = userService.createUser(dto);
        return new ResponseEntity<>(userMapper.toDto(user), HttpStatus.CREATED);
    }

    @GetMapping("/details")
    public String userDetailsPage(Model model, Principal principal) {
        String email = principal.getName();

        User user = userService.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));


        UserResponseDto userDto = userMapper.toDto(user);
        model.addAttribute("user", userDto);

        return "user-details";
    }
}
