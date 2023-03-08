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
    private String type; //fk
    private String name;
    private int numberOfBed;
    private String bedType;
    private String desc;
    
    private String roomID;
    private boolean status;
    private EmployeeDTO employeeDTO;
    private double dailyPrice;

    public RoomDTO(String type, String name, int numberOfBed, String bedType, String desc, String roomID, boolean status, EmployeeDTO employeeDTO_ID, double dailyPrice) {
        this.type = type;
        this.name = name;
        this.numberOfBed = numberOfBed;
        this.bedType = bedType;
        this.desc = desc;
        this.roomID = roomID;
        this.status = status;
        this.employeeDTO = employeeDTO;
        this.dailyPrice = dailyPrice;
    }

    public RoomDTO() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
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
        return "RoomDTO{" + "type=" + type + ", name=" + name + ", numberOfBed=" + numberOfBed + ", bedType=" + bedType + ", desc=" + desc + ", roomID=" + roomID + ", status=" + status + ", employeeDTO=" + employeeDTO + ", dailyPrice=" + dailyPrice + '}';
    }

   

    
}