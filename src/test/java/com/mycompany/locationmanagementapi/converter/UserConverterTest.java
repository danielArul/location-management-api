package com.mycompany.locationmanagementapi.converter;

import com.mycompany.locationmanagementapi.entity.UserEntity;
import com.mycompany.locationmanagementapi.model.UserModel;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class UserConverterTest {

    @InjectMocks
    private UserConverter userConverter;

    @Test
    public void test_convertModelToEntity(){
        UserModel userModel = new UserModel();
        userModel.setEmail("abc@gmail.com");
        userModel.setFullName("ABC Pvt Ltd");
        userModel.setMobileNumber("989887878");
        userModel.setPassword("secret");

        UserEntity userEntity = userConverter.convertModelToEntity(userModel);
        assertEquals("abc@gmail.com",userEntity.getEmail());
        assertEquals(userModel.getFullName() ,userEntity.getFullName());
        assertEquals(userModel.getMobileNumber(),userEntity.getMobileNumber());
        assertEquals(userModel.getPassword(),userEntity.getPassword());
    }
}
