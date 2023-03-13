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
public class ImageDTO {
   private String roomID;
   private String imgSrc;

    public String getRoomID() {
        return roomID;
    }

    public void setRoomID(String roomID) {
        this.roomID = roomID;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    public ImageDTO() {
    }

    public ImageDTO(String roomID, String imgSrc) {
        this.roomID = roomID;
        this.imgSrc = imgSrc;
    }
   
}
