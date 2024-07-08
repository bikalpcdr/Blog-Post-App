package com.bikalp.blogApp.Service;

import com.bikalp.blogApp.DTO.UserDto;
import com.bikalp.blogApp.Entity.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {

    UserDto registerUser(UserDto userDto);

    UserDto updateUser(UserDto userDto, Long id);

    UserDto getUserById(Long id);

    List<UserDto> getAllUser();

    boolean deleteUser(Long id);
}
