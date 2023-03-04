/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User;

import java.sql.Date;

/**
 *
 * @author Oalskad
 */
public class UserDTO {
    private String userID;
    private String userName;
    private String password;
    private String fname;
    private String lname;
    private Date dayOfBirth;
    private int visitFrequency;

    @Override
    public String toString() {
        return "UserDTO{" + "userID=" + userID + ", userName=" + userName + ", password=" + password + ", fname=" + fname + ", lname=" + lname + ", dayOfBirth=" + dayOfBirth + ", visitFrequency=" + visitFrequency + ", phoneNumber=" + phoneNumber + ", email=" + email + ", ID_PATTERN=" + ID_PATTERN + ", gender=" + gender + '}';
    }
    private String phoneNumber;
    private String email;
    private String ID_PATTERN ="USER";
    private String gender;

    public UserDTO() {
    }

    public UserDTO(String userID, String userName, String password, String fname, String lname, Date dayOfBirth, int visitFrequency, String phoneNumber, String email, String gender) {
        this.userID = userID;
        this.userName = userName;
        this.password = password;
        this.fname = fname;
        this.lname = lname;
        this.dayOfBirth = dayOfBirth;
        this.visitFrequency = visitFrequency;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.gender = gender;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public Date getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(Date dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public int getVisitFrequency() {
        return visitFrequency;
    }

    public void setVisitFrequency(int visitFrequency) {
        this.visitFrequency = visitFrequency;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getID_PATTERN() {
        return ID_PATTERN;
    }

    public void setID_PATTERN(String ID_PATTERN) {
        this.ID_PATTERN = ID_PATTERN;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

   
    
}
