package com.example.draftlab.user;

import com.example.draftlab.user.dto.UserResponse;
import com.example.draftlab.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    
    @Autowired
    private UserService userService;
    
    @GetMapping("/users")
    public ResponseEntity<UserResponse> getUsers() {
        List<User> users = userService.getAllUsers();
        if (!users.isEmpty()) {
            User user = users.get(0);
            UserResponse response = new UserResponse(
                user.getIdx(),
                user.getName(),
                user.getEmail()
            );
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}