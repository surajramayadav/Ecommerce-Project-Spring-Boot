package com.adminpanel.adminpanel.services;

import com.adminpanel.adminpanel.exception.ErrorMessage;
import com.adminpanel.adminpanel.models.UserModel;
import com.adminpanel.adminpanel.repository.UserRepository;
import com.adminpanel.adminpanel.utils.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {

    ApiResponse apiResponse = new ApiResponse();

    ErrorMessage errorMessage=new ErrorMessage();

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserModel> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserModel addUser(UserModel userModel) {
        return userRepository.save(userModel);
    }

    @Override
    public HashMap<String, Boolean> deleteUser(long id) {
        userRepository.deleteById(id);
        Optional<UserModel> user=userRepository.findById(id);
        if(user.isEmpty()){
           return apiResponse.addKeyValue(true);
        }
        return apiResponse.addKeyValue(false);
    }

    @Override
    public Optional<UserModel> updateUser(long id,UserModel userModel) {
        userRepository.updateUser(userModel.getUser_age(),userModel.getPhone_number(),userModel.getUser_name(),id);
        return userRepository.findById(id);
    }

    @Override
    public Optional<UserModel> getUserById(long id) {
        return userRepository.findById(id);
    }
}
