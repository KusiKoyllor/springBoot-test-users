package com.user.userhanding;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")

public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserEntity> createUser(@RequestBody UserEntity userEntity) {
       return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser((userEntity)));
    }

    @GetMapping
    public ResponseEntity<List<UserEntity>> getUsers() {
        // ResponseEntity.status(HttpStatus.OK).body(userService.getAllUsers());
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("{id}")
    public ResponseEntity<UserEntity> getUserById(@PathVariable Long id){
        return ResponseEntity.ok(userService.getUserById(id));
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
       return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<UserEntity> updateUser(@PathVariable Long id, @RequestBody UserEntity userDetails) {
        UserEntity userUpdated =  userService.updateUser(id, userDetails);
        return ResponseEntity.ok(userUpdated);
    }
}
