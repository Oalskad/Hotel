/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Oalskad
 */
public class ReviewDTO {
    String reviewID;
    ReceiptDTO receiptDTO_ID;
    UserDTO userDTO_ID;
    RoomDTO roomDTO_ID;
    String description;
    int Rating;

    public ReviewDTO(String reviewID, ReceiptDTO receiptDTO_ID, UserDTO userDTO_ID, RoomDTO roomDTO_ID, String description, int Rating) {
        this.reviewID = reviewID;
        this.receiptDTO_ID = receiptDTO_ID;
        this.userDTO_ID = userDTO_ID;
        this.roomDTO_ID = roomDTO_ID;
        this.description = description;
        this.Rating = Rating;
    }

    public ReviewDTO() {
    }

    public String getReviewID() {
        return reviewID;
    }

    public void setReviewID(String reviewID) {
        this.reviewID = reviewID;
    }

    public ReceiptDTO getReceiptDTO_ID() {
        return receiptDTO_ID;
    }

    public void setReceiptDTO_ID(ReceiptDTO receiptDTO_ID) {
        this.receiptDTO_ID = receiptDTO_ID;
    }

    public UserDTO getUserDTO_ID() {
        return userDTO_ID;
    }

    public void setUserDTO_ID(UserDTO userDTO_ID) {
        this.userDTO_ID = userDTO_ID;
    }

    public RoomDTO getRoomDTO_ID() {
        return roomDTO_ID;
    }

    public void setRoomDTO_ID(RoomDTO roomDTO_ID) {
        this.roomDTO_ID = roomDTO_ID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRating() {
        return Rating;
    }

    public void setRating(int Rating) {
        this.Rating = Rating;
    }

    @Override
    public String toString() {
        return "ReviewDTO{" + "reviewID=" + reviewID + ", receiptDTO_ID=" + receiptDTO_ID + ", userDTO_ID=" + userDTO_ID + ", roomDTO_ID=" + roomDTO_ID + ", description=" + description + ", Rating=" + Rating + '}';
    }
    
    
}
