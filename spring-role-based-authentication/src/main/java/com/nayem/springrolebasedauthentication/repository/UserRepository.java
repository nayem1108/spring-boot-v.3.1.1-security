package com.nayem.springrolebasedauthentication.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nayem.springrolebasedauthentication.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
    
    // Optional<User> findByUsername(String username);

    // or using HQL query for custom query
    @Query("SELECT u FROM User u WHERE u.email = :email")
    public User findByUseremail(@Param("email") String email);
    
}
