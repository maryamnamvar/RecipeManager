package com.recipeapplication.service;

import com.recipeapplication.dto.UserRepresentation;
import com.recipeapplication.entity.User;

public interface UserService {

    Iterable<User> getAllUsers();

    void blockUser(long id);

    void unblockUser(long id);

    User create(UserRepresentation userRepr);

    User create(User user);

    User update(User user);

    void delete(long id);

    User find(long id);

    User findByEmail(String username);
}