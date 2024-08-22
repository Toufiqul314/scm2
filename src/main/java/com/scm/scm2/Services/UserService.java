package com.scm.scm2.Services;

import java.util.List;
import java.util.Optional;

import com.scm.scm2.entities.User;

public interface UserService {
    User savUser(User user);

    Optional<User> getUserByUserId(String id);
    Optional<User> updateUser(User user);

    Void deleteUser(String id);

    boolean isUserExist(String userId);

    boolean isUserexistByEmail(String email);

    List<User> getAllUsers();

    //add more methods here related user service[logic]
}
