package com.example.todo_api.controller;

import com.example.todo_api.entity.User;
import com.example.todo_api.sercvice.UserService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User registerUser(@RequestBody AuthRequest registerRequest) {
        return userService.registerNewUser(
                registerRequest.getUsername(),
                registerRequest.getPassword(),
                registerRequest.getAuthority()
        );
    }
}

@Getter
@Setter
class AuthRequest {
    private String username;
    private String password;
    private String authority;
}
