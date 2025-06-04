package org.example.carmarketplace.DTOs.Request;

import org.example.carmarketplace.ENUMs.RoleName;
import org.example.carmarketplace.ENUMs.*;

public class UserRequestDto {
    private String FirstName;
    private String MiddleName;
    private String LastName;
    private String Email;
    private String PhoneNumber;
    private String Password;
    private RoleName roleName;

    public UserRequestDto(String firstName, String middleName, String lastName, String email, String phoneNumber, String password, RoleName roleName) {
        FirstName = firstName;
        MiddleName = middleName;
        LastName = lastName;
        Email = email;
        PhoneNumber = phoneNumber;
        Password = password;
        this.roleName = roleName;
    }

    public UserRequestDto() {
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

    public void setRoleName(RoleName roleName) {
        this.roleName = roleName;
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

    public RoleName getRoleName() {
        return roleName;
    }
}
