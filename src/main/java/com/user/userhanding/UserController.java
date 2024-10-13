package com.user.userhanding;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")

public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public UserEntity createUser(@RequestBody UserEntity userEntity) {
       return userService.createUser(userEntity);
    }

    @GetMapping
    public List<UserEntity> getUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("{id}")
    public UserEntity getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }
}
