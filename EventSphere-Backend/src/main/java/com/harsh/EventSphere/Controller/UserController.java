package com.harsh.EventSphere.Controller;


import com.harsh.EventSphere.Dto.AuthDto.LoginRequestDto;
import com.harsh.EventSphere.Dto.AuthDto.LoginResponseDto;
import com.harsh.EventSphere.Dto.AuthDto.UserRegistrationRequestDto;
import com.harsh.EventSphere.Dto.UserDto.UserUpdateRequestDto;
import com.harsh.EventSphere.Model.User;
import com.harsh.EventSphere.Model.Ticket;
import com.harsh.EventSphere.Service.UserService;
import com.harsh.EventSphere.Service.TicketService;
import com.harsh.EventSphere.Utils.SecurityUtils.SecurityUtils;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Marks this class as a REST controller where each method returns a ResponseEntity or JSON response
@RequestMapping("/api/user") // Base path for all endpoints in this controller
@RequiredArgsConstructor // Lombok will automatically create a constructor for final fields (Dependency Injection)
public class UserController {


    private final SecurityUtils securityUtils;
    private final TicketService ticketService;
    private final UserService userService;




    @GetMapping("/me")
    public ResponseEntity<?> getCurrentUser(){
        UserDetails userDetails = securityUtils.getAuthenticatedUserDetails();
        String username = userDetails.getUsername();
        User user = userService.findByEmail(username);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/me")
    public ResponseEntity<?> updateUser(@Valid @RequestBody UserUpdateRequestDto userDto){

        UserDetails userDetails = securityUtils.getAuthenticatedUserDetails();
        String username = userDetails.getUsername();

        userService.updateUser(username, userDto);
        return ResponseEntity.ok("User updated successfully!");
    }
    @GetMapping("/{userId}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> getUserById(@PathVariable Long userId){
        User user = userService.findByID(userId);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/getAll")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> getAllUsers(){
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/tickets")
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<?> getTickets(){
        List<Ticket> tickets = ticketService.getTickets();
        return ResponseEntity.ok(tickets);
    }

    //////////////////////////////////// Helper Methods ////////////////////////////////////

}