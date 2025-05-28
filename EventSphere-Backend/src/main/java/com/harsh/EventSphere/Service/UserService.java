package com.harsh.EventSphere.Service;

import com.harsh.EventSphere.Exception.EmailAlreadyInUseException;
import com.harsh.EventSphere.Exception.UserNotFoundException;
import com.harsh.EventSphere.Model.User;
import com.harsh.EventSphere.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public boolean existsByEmail(String email){
        return userRepository.existsByEmail(email);
    }

    public User findByID(Long id){
        if (userRepository.findById(id).isEmpty()) {
            throw new UserNotFoundException("User not found!");
        }
        return userRepository.findById(id).get();
    }

    public String encodePassword(String password){
        return passwordEncoder.encode(password);
    }

    public void saveUser(User user){

        // check if user already exists
        if(userRepository.existsByEmail(user.getEmail())){
            throw new EmailAlreadyInUseException("Email already in use!");
        }

        //Encode the password
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        userRepository.save(user);
    }


    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
