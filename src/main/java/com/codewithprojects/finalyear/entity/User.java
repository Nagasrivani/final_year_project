package com.codewithprojects.finalyear.entity;

import com.codewithprojects.finalyear.roles.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id //primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sno;

    @Column(unique = true)
    private String rollno;

    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(unique = true, nullable = false)
    private String stuTag;

    @Enumerated(EnumType.STRING)
    private Role role; // Role can be STUDENT,STAFF

    private boolean checkedIn;

    public String getPassword() {
        return null;
    }
}
