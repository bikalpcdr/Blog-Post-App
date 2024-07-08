package com.bikalp.blogApp.Service.Implementation;

import com.bikalp.blogApp.DTO.UserDto;
import com.bikalp.blogApp.Entity.User;
import com.bikalp.blogApp.Exception.ResourceNotFoundException;
import com.bikalp.blogApp.Repository.UserRepo;
import com.bikalp.blogApp.Service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepo userRepo, ModelMapper modelMapper) {
        this.userRepo = userRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public UserDto registerUser(UserDto userDto) {
        this.modelMapper.map(userDto, UserDto.class);
        User user = this.modelMapper.map(userDto, User.class);
        User newUser = this.userRepo.save(user);
        return this.modelMapper.map(newUser, UserDto.class);
    }

    @Override
    public UserDto updateUser(UserDto userDto, Long id) {
        User user = this.userRepo.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("User", "Id",id));
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());

        User updatedUser = this.userRepo.save(user);
        return this.modelMapper.map(updatedUser,UserDto.class);
    }


    @Override
    public UserDto getUserById(Long id) {
        User user = this.userRepo.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("User", "Id",id));
        return this.modelMapper.map(user,UserDto.class);
    }

    @Override
    public List<UserDto> getAllUser() {
        List<User> users = this.userRepo.findAll();
        return users.stream()
                .map(user -> this.modelMapper.map(user,UserDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public boolean deleteUser(Long id) {
        userRepo.deleteById(id);
        return true;
    }
}
