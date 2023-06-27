package com.nayem.springrolebasedauthentication.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.nayem.springrolebasedauthentication.model.User;
import com.nayem.springrolebasedauthentication.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user){
        user.setPassword(userPasswordEncoder().encode(user.getPassword()));
        System.out.println(user.getPassword());
        return userRepository.save(user);
    }

    @Bean
    public PasswordEncoder userPasswordEncoder(){
        return new BCryptPasswordEncoder();        
    }

}
