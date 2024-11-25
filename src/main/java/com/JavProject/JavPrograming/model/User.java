package com.JavProject.JavPrograming.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private int userId;


    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "STU_NUMBER", nullable = false)
    private int stuNumber;

    // Getters and setters
    public int getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) { this.userId = userId; }

    public String getName() {
        return name;
    }

    public int getStuNumber() {
        return stuNumber;
    }

}
