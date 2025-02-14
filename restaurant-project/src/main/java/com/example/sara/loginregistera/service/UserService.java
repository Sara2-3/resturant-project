package com.example.sara.loginregistera.service;

import com.example.sara.loginregistera.model.LoginUser;
import com.example.sara.loginregistera.model.User;
import com.example.sara.loginregistera.repository.UserRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.Optional;

@Service

public class UserService {

    @Autowired
    private UserRepository userRepo;


    public User validateRegistration(User newUser, BindingResult result) {
        if(!newUser.getPassword().equals(newUser.getConfirmPassword())) {
            result.rejectValue("password","passwordDisagree.registerUser.password","Passwords do not match");
        }

        Optional<User>possibleUser = userRepo.findByEmail(newUser.getEmail());
        if(possibleUser.isPresent()) {
            result.rejectValue("email","emailDisagree.registerUser.email","Email already in use");
        }

        if (result.hasErrors()) {
            return null;
        }
        String hashedPassword = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
        newUser.setPassword(hashedPassword);
        User registeredUser = userRepo.save(newUser);
        return registeredUser;


    }

    public User validateLogin(LoginUser loginUser, BindingResult result) {

        Optional<User> possibleUser= userRepo.findByEmail(loginUser.getEmail());
        if(!possibleUser.isPresent()) {
            result.rejectValue("email","invalidCredentials.loginUser.email","Email does not exist!");
            return null;
        }
        User userToReturn = possibleUser.get();

        if(!BCrypt.checkpw(loginUser.getPassword(), userToReturn.getPassword())) {
            result.rejectValue("password","invalidCredentials.loginUser.password","Password is not correct!");
            return null;
        }
        if (result.hasErrors()){
            return null;
        }else{
            return userToReturn;
        }
    }

    public User getUserById(Long id) {
        Optional<User> possibleUser = userRepo.findById(id);
        return possibleUser.isPresent() ? possibleUser.get() : null;
    }

}
