/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Date;

/**
 *
 * @author iba
 */
public class ReceiptDTO {
    private CouponDTO couponDTO;
    private UserDTO userDTO;
    private RoomDTO roomDTO;
    private EmployeeDTO employeeDTO;
    private ServiceDTO serviceDTO;
    
    private String receiptID, detail;
    private int cardNumber;
    private Date startDate, endDate;
    private double finalPrice;

    public ReceiptDTO() {
    }

    public ReceiptDTO(CouponDTO couponDTO, UserDTO userDTO, RoomDTO roomDTO, EmployeeDTO employeeDTO, ServiceDTO serviceDTO, String receiptID, String detail, int cardNumber, Date startDate, Date endDate, double finalPrice) {
        this.couponDTO = couponDTO;
        this.userDTO = userDTO;
        this.roomDTO = roomDTO;
        this.employeeDTO = employeeDTO;
        this.serviceDTO = serviceDTO;
        this.receiptID = receiptID;
        this.detail = detail;
        this.cardNumber = cardNumber;
        this.startDate = startDate;
        this.endDate = endDate;
        this.finalPrice = finalPrice;
    }

    @Override
    public String toString() {
        return "ReceiptDTO{" + "couponDTO=" + couponDTO + ", userDTO=" + userDTO + ", roomDTO=" + roomDTO + ", employeeDTO=" + employeeDTO + ", serviceDTO=" + serviceDTO + ", receiptID=" + receiptID + ", detail=" + detail + ", cardNumber=" + cardNumber + ", startDate=" + startDate + ", endDate=" + endDate + ", finalPrice=" + finalPrice + '}';
    }

    public CouponDTO getCouponDTO() {
        return couponDTO;
    }

    public void setCouponDTO(CouponDTO couponDTO) {
        this.couponDTO = couponDTO;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    public RoomDTO getRoomDTO() {
        return roomDTO;
    }

    public void setRoomDTO(RoomDTO roomDTO) {
        this.roomDTO = roomDTO;
    }

    public EmployeeDTO getEmployeeDTO() {
        return employeeDTO;
    }

    public void setEmployeeDTO(EmployeeDTO employeeDTO) {
        this.employeeDTO = employeeDTO;
    }

    public ServiceDTO getServiceDTO() {
        return serviceDTO;
    }

    public void setServiceDTO(ServiceDTO serviceDTO) {
        this.serviceDTO = serviceDTO;
    }

    public String getReceiptID() {
        return receiptID;
    }

    public void setReceiptID(String receiptID) {
        this.receiptID = receiptID;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public double getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(double finalPrice) {
        this.finalPrice = finalPrice;
    }
    
    
}
