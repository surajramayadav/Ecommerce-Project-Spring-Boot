package com.adminpanel.adminpanel.services;

import com.adminpanel.adminpanel.models.UserModel;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public interface UserService {

    public List<UserModel> getAllUsers();
    public UserModel addUser(UserModel userModel);
    public HashMap<String,Boolean> deleteUser(long id);
    public Optional<UserModel> updateUser(long id, UserModel userModel);
    public Optional<UserModel> getUserById(long id);
}
