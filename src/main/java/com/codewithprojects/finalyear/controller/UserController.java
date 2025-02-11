package com.codewithprojects.finalyear.controller;

import com.codewithprojects.finalyear.entity.User;
import com.codewithprojects.finalyear.repository.UserRepo;
import com.codewithprojects.finalyear.roles.Role;
import com.codewithprojects.finalyear.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Create a new user
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    // Get all users
//    @GetMapping
//    public ResponseEntity<List<User>> getAllUsers() {
//        List<User> users = userRepo.findAll();
//        return ResponseEntity.ok(users);
//    }

    // Get a user by roll number
//    @GetMapping("/rollno")
//    public ResponseEntity<User> getUserByRollno(@PathVariable String rollno) {
//        Optional<User> user = userRepo.findByRollno(rollno);
//        return user.map(ResponseEntity::ok)
//                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
//    }
//
//    // Update a user's information
//    @PutMapping("/rollno")
//    public ResponseEntity<User> updateUser(@PathVariable String rollno, @RequestBody User userDetails) {
//        Optional<User> userOptional = userRepo.findByRollno(rollno);
//        if (userOptional.isPresent()) {
//            User user = userOptional.get();
////            user.setName(userDetails.getName());
////            user.setEmail(userDetails.getEmail());
////            user.setRole(userDetails.getRole());
////            user.setCheckedIn(userDetails.isCheckedIn());
//            User updatedUser = userRepo.save(user);
//            return ResponseEntity.ok(updatedUser);
//        } else {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//        }
//    }
//
//    // Delete a user
//    @DeleteMapping("/rollno")
//    public ResponseEntity<Void> deleteUser(@PathVariable String rollno) {
//        Optional<User> userOptional = userRepo.findByRollno(rollno);
//        if (userOptional.isPresent()) {
//            userRepo.delete(userOptional.get());
//            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
//        } else {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//        }
   // }

    // Check-in a user
//    @PostMapping("/checkin")
//    public ResponseEntity<String> checkIn(@RequestBody Map<String, String> request) {
//        String rollno = request.get("rollno");
//        Optional<User> userOptional = userRepo.findByRollno(rollno);
//        if (userOptional.isPresent()) {
//            User user = userOptional.get();
//            user.setCheckedIn(true);
//            userRepo.save(user);
//            return ResponseEntity.ok(user.getRole() + " check-in successful");
//        } else {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
//        }
//    }

    // Get users by role
//    @GetMapping("/role/student")
//    public ResponseEntity<List<User>> getUsersByRole(@PathVariable Role role) {
//        List<User> users = userRepo.findByRole(role);
//        return ResponseEntity.ok(users);
//    }
}

