package com.codewithprojects.finalyear.repository;

import com.codewithprojects.finalyear.entity.User;
import com.codewithprojects.finalyear.roles.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
//    User findByStuTag(String stuTag);
  //    List<User> findByRole(Role role);
//    Optional<User> findByRollno(String rollno);
}
