package org.example.carmarketplace.Models;

import org.example.carmarketplace.ENUMs.*;

import jakarta.persistence.*;
import org.example.carmarketplace.Models.Feedback;

import java.util.List;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(length=50, nullable = false)
    private String FirstName;

    @Column(length=50, nullable = true)
    private String MiddleName;

    @Column(length=50, nullable = false)
    private String LastName;

    @Column(length=50, nullable = false)
    private String Email;

    @Column(length=20, nullable = false)
    private String PhoneNumber;

    @Column(length=50, nullable = false)
    private String Password;

    @Enumerated(EnumType.STRING)
    @Column(length = 50, nullable = false)
    private RoleName role;

    @OneToMany(mappedBy = "writtenBy")
    private List<Feedback> feedbacksWritten;

    @OneToMany(mappedBy = "toWhom")
    private List<Feedback> feedbacksReceived;



    public User(String firstName, String middleName, String lastName, String email, String phoneNumber, String password, RoleName role) {
        FirstName = firstName;
        MiddleName = middleName;
        LastName = lastName;
        Email = email;
        PhoneNumber = phoneNumber;
        Password = password;
        this.role = role;
    }
    public User() {
    }


    public Long getId() {
        return id;
    }
    public String getFirstName() {
        return FirstName;
    }
    public String getMiddleName() {
        return MiddleName;
    }
    public String getLastName() {
        return LastName;
    }
    public String getEmail() {
        return Email;
    }
    public String getPhoneNumber() {
        return PhoneNumber;
    }
    public String getPassword() {
        return Password;
    }
    public RoleName getRole() {
        return role;
    }


    public void setId(Long id) {
        this.id = id;
    }
    public void setFirstName(String firstName) {
        FirstName = firstName;
    }
    public void setMiddleName(String middleName) {
        MiddleName = middleName;
    }
    public void setLastName(String lastName) {
        LastName = lastName;
    }
    public void setEmail(String email) {
        Email = email;
    }
    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }
    public void setPassword(String password) {
        Password = password;
    }
    public void setRole(RoleName role) {
        this.role = role;
    }
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", FirstName='" + FirstName + '\'' +
                ", MiddleName='" + MiddleName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", Email='" + Email + '\'' +
                ", PhoneNumber='" + PhoneNumber + '\'' +
                ", Password='" + Password + '\'' +
                ", role=" + role +
                '}';
    }
}
