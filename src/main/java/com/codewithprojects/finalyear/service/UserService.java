package com.codewithprojects.finalyear.service;

import com.codewithprojects.finalyear.entity.User;
import com.codewithprojects.finalyear.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepo userRepo;

    @Autowired //injects the UserRepo into the service
    public UserService(UserRepo userRepo)
    {
        this.userRepo = userRepo;
    }

    public User createUser(User user)
    {
        return userRepo.save(user);
    }

//    public List<User> getAllUsers()
//    {
//        return userRepo.findAll();
//    }
    public Optional<User> getUserByRollno(String rollno)
    {
        return userRepo.findByRollno(rollno);
    }
}
