package com.springsecurity2.Spring_security2.services;

import com.springsecurity2.Spring_security2.model.CustomUserDetails;
import com.springsecurity2.Spring_security2.model.User;
import com.springsecurity2.Spring_security2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService  implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.userRepository.findByUserName(username);
        if(user==null) {
            throw  new UsernameNotFoundException("user data not found");
        }
        return new CustomUserDetails(user);
    }
}
