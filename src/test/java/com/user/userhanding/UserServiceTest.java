package com.user.userhanding;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @InjectMocks
    UserService userService;

    @Mock
    UserRespository userRespository;

    @Test
    void testCreateUser() {
        UserEntity userTest = new UserEntity();
        userTest.setEmail("test@gmail.com");
        userTest.setName("Test");

        when(userRespository.save(userTest)).thenReturn(userTest);

        UserEntity userSaved = userService.createUser(userTest);
        Assertions.assertEquals("test@gmail.com",userSaved.getEmail());
        verify(userRespository, times(1)).save(userTest);
    }

    @Test
    void testGetAllUser() {
        UserEntity userTest = new UserEntity();
        userTest.setId(1L);
        userTest.setEmail("test@gmail.com");
        userTest.setName("Test");

        when(userRespository.findAll()).thenReturn(List.of(userTest));

        List<UserEntity> userList = userService.getAllUsers();
        Assertions.assertEquals("test@gmail.com",userList.get(0).getEmail());
        Assertions.assertEquals(1,userList.size());
        verify(userRespository, times(1)).findAll();
    }
}
