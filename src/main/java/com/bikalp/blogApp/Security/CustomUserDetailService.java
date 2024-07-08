package com.bikalp.blogApp.Security;

import com.bikalp.blogApp.Entity.User;
import com.bikalp.blogApp.Exception.ResourceNotFoundException;
import com.bikalp.blogApp.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {

    private final UserRepo userRepo;

    public CustomUserDetailService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // Loading user from database by username
        User user = this.userRepo.findByUsername(username).orElseThrow(()-> new ResourceNotFoundException("User","name: "+username,0L));
        return user;
    }
}
