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
    private String firstName;

    @Column(length=50, nullable = true)
    private String middleName;

    @Column(length=50, nullable = false)
    private String lastName;

    @Column(length=50, nullable = false)
    private String email;

    @Column(length=20, nullable = false)
    private String phoneNumber;

    @Column(length=100, nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(length = 50, nullable = false)
    private RoleName role;

    @OneToMany(mappedBy = "writtenBy")
    private List<Feedback> feedbacksWritten;

    @OneToMany(mappedBy = "toWhom")
    private List<Feedback> feedbacksReceived;


    public User(Long id, String firstName, String middleName, String lastName, String email, String phoneNumber, String password, RoleName role, List<Feedback> feedbacksWritten, List<Feedback> feedbacksReceived) {
        this.id = id;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.role = role;
        this.feedbacksWritten = feedbacksWritten;
        this.feedbacksReceived = feedbacksReceived;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public RoleName getRole() {
        return role;
    }

    public List<Feedback> getFeedbacksWritten() {
        return feedbacksWritten;
    }

    public List<Feedback> getFeedbacksReceived() {
        return feedbacksReceived;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(RoleName role) {
        this.role = role;
    }

    public void setFeedbacksWritten(List<Feedback> feedbacksWritten) {
        this.feedbacksWritten = feedbacksWritten;
    }

    public void setFeedbacksReceived(List<Feedback> feedbacksReceived) {
        this.feedbacksReceived = feedbacksReceived;
    }
}
