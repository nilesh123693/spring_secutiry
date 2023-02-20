package com.springsecurity2.Spring_security2.services;

import com.springsecurity2.Spring_security2.model.User;
import com.springsecurity2.Spring_security2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegisterUserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public String RegisterUser(User user) {
        if(userRepository.existsById(user.getId()) || userRepository.existsByUserName(user.getUserName())) {
            return "user id or email already exists";
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return "user added sucessfully";

    }

    public String updateUser(User user, int sid) {
        if(userRepository.existsById(sid)) {
            user.setUserName(user.getUserName());
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save((user));
            return "data updated successfully";
        }
        return "data not found";

    }

    public User deleteUser(Integer sid) {
        if(userRepository.existsById(sid)) {
            User user = userRepository.findById(sid).get();
            userRepository.deleteById(sid);
            return user;

        }
        return null;
    }
    public User getUserById(Integer sid) {
        return this.userRepository.findById(sid).orElse(null);
    }
}
