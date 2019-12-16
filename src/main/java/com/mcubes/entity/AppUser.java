package com.mcubes.entity;

import javax.persistence.*;

/**
 * Created by A.A.MAMUN on 12/15/2019.
 */
@Entity(name = "app_user")
public class AppUser {

    @Id
    @SequenceGenerator(name = "app_user_sequence", sequenceName = "app_user_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE ,generator = "app_user_sequence")
    private Long id;
    @Column(unique = true)
    private String email;
    private String password;
    private String name;
    private String role;

    public AppUser(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "AppUser{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
