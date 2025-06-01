package com.harsh.EventSphere.Service;

import com.harsh.EventSphere.Dto.UserDto.UserUpdateRequestDto;
import com.harsh.EventSphere.Exception.UserNotFoundException;
import com.harsh.EventSphere.Model.User;
import com.harsh.EventSphere.Repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public User findByID(Long id){
        Optional<User> userOptional = userRepository.findById(id);
        if(userOptional.isEmpty()){
            throw new UserNotFoundException("User not found!");
        }
        return userOptional.get();
    }



    public User findByEmail(String email){
        Optional<User> userOptional = userRepository.findByEmail(email);
        if(userOptional.isEmpty()){
            throw new UserNotFoundException("User not found!");
        }

        return userOptional.get();
    }


    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    public void updateUser(String email, @Valid UserUpdateRequestDto userUpdateRequestDto){
        Optional<User> userOptional = userRepository.findByEmail(email);
        if(userOptional.isEmpty()){
            throw new UserNotFoundException("User not found!");
        }
        User user = userOptional.get();

        user.setFirstName(userUpdateRequestDto.getFirstName());
        user.setLastName(userUpdateRequestDto.getLastName());
        user.setPhone(userUpdateRequestDto.getPhone());

        userRepository.save(user);
    }

}
