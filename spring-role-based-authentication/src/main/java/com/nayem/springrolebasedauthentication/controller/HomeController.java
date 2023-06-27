package com.nayem.springrolebasedauthentication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nayem.springrolebasedauthentication.Service.UserService;
import com.nayem.springrolebasedauthentication.model.User;

@RestController
@RequestMapping("/")
public class HomeController {

    @Autowired
    private UserService userService;
    
    @GetMapping("/")
    public String home(){
        return "<h1>Welcome Home</h1>";
    }

    @PreAuthorize("hasAnyAuthority('ROLE_USER', 'ROLE_ADMIN')")
    @GetMapping("user")
    public String user(){
        return "<h1>Welcome User</h1>";
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("/user/new")
    public User creatUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("admin")
    public String admin(){
        return "Hello Admin";
    }
}

