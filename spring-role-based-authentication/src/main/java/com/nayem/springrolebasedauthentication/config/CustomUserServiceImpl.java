package com.nayem.springrolebasedauthentication.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.nayem.springrolebasedauthentication.model.User;
import com.nayem.springrolebasedauthentication.repository.UserRepository;

@Service
public class CustomUserServiceImpl implements UserDetailsService{

    @Autowired
    private final UserRepository userRepository = null;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.userRepository.findByUseremail(username);
        if(user == null){
            System.out.println("User not found");
            throw new UsernameNotFoundException("User not found");
        }

        System.out.println("User found with + " + username);
        return new CustomUserDetails(user);

        // return userRepository
        //    .findByUseremail(username)
        //    .map(CustomUserDetails::new)
        //    .orElseThrow(new UsernameNotFoundException("User not found by : " +username));
    }
    
}
