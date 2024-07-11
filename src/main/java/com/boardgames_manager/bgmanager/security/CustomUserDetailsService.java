package com.boardgames_manager.bgmanager.security;

import java.util.Collections;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.boardgames_manager.bgmanager.models.User;
import com.boardgames_manager.bgmanager.repositories.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{
    
    private UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException
    {
        User user = userRepository.findByEmail(email);

        if (user != null)
        {
            return new org.springframework.security.core.userdetails.User(
                                                                        user.getEmail(),
                                                                        user.getPassword(),
                                                                        Collections.emptyList()
            );
        }

        throw new UsernameNotFoundException("Invalid username or password");
    }
}
