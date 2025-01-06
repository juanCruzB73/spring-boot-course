package com.security.springSecurity.service;

import com.security.springSecurity.repository.UserRepository;
import com.security.springSecurity.model.User;
import com.security.springSecurity.model.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);

        if(user==null){
            System.out.println("user 404");
            throw new UsernameNotFoundException("User doesnt exist with that username");
        }

        //implements userDetail interface
        return new UserPrincipal(user);
    }

}
