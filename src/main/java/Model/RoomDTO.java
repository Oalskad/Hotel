/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author iba
 */
public class RoomDTO {
    private String roomID;
    private String type; //fk

    private int numberOfBed;
    private String bedType;
   
    
   
    private boolean status;

  
    private EmployeeDTO employeeDTO;
    private double dailyPrice;
    private String description;

  public RoomDTO() {
    }

    public RoomDTO(String type, int numberOfBed, String bedType, String description, String roomID, boolean status, EmployeeDTO employeeDTO, double dailyPrice) {
        this.type = type;
        this.numberOfBed = numberOfBed;
        this.bedType = bedType;
        this.description = description;
        this.roomID = roomID;
        this.status = status;
        this.employeeDTO = employeeDTO;
        this.dailyPrice = dailyPrice;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNumberOfBed() {
        return numberOfBed;
    }

    public void setNumberOfBed(int numberOfBed) {
        this.numberOfBed = numberOfBed;
    }

    public String getBedType() {
        return bedType;
    }

    public void setBedType(String bedType) {
        this.bedType = bedType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRoomID() {
        return roomID;
    }

    public void setRoomID(String roomID) {
        this.roomID = roomID;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public EmployeeDTO getEmployeeDTO() {
        return employeeDTO;
    }

    public void setEmployeeDTO(EmployeeDTO employeeDTO) {
        this.employeeDTO = employeeDTO;
    }

    public double getDailyPrice() {
        return dailyPrice;
    }

    public void setDailyPrice(double dailyPrice) {
        this.dailyPrice = dailyPrice;
    }

    @Override
    public String toString() {
        return "RoomDTO{" + "roomID=" + roomID + ", type=" + type + ", numberOfBed=" + numberOfBed + ", bedType=" + bedType + ", status=" + status + ", employeeDTO=" + employeeDTO + ", dailyPrice=" + dailyPrice + ", description=" + description + '}';
    }

    
   

    
}