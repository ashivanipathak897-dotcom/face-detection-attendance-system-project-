package com.faceattendance.app.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    
    @Column(unique = true)
    private String email;
    
    private String password;
    
    private String role; // STUDENT, TEACHER, ADMIN
    
    private String rollNumber;
    
    private String department;
    
    // Store face encoding as byte array
    @Lob
    private byte[] faceEncoding;
    
    private LocalDateTime createdAt;
}
