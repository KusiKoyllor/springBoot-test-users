package com.user.userhanding;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserService {
    @Autowired
    private UserRespository userRespository;

    public UserEntity createUser(UserEntity user) {
        return userRespository.save(user);
    }

    public List<UserEntity> getAllUsers() {
        return userRespository.findAll();
    }

    public UserEntity getUserById(Long id){
        return userRespository.findById(id).orElseThrow(() -> new RuntimeException(("User not found")));
    }

    public void deleteUser(Long id){
        userRespository.findById(id).orElseThrow(() -> new RuntimeException(("User not found")));
        userRespository.deleteById(id);
    }

    public UserEntity updateUser(Long id, UserEntity userDetails) {
        UserEntity currentUser =  userRespository.findById(id).orElseThrow(() -> new RuntimeException(("User not found")));
        String newEmail = userDetails.getEmail();
        currentUser.setEmail(newEmail);
        return userRespository.save(currentUser);
    }

}
