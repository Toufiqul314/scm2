package com.scm.scm2.repsitories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scm.scm2.entities.User;

@Repository
public interface UserRepo extends JpaRepository<User,String>{
    //extra methods database releatedoperations
    //custom query methods
    //custom finder methods

    Optional<User> findByEmail(String email);
    Optional<User>findByEmailAndPassword(String email,String password);
}
