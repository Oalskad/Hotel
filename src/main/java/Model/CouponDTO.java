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
public class CouponDTO {
    private String couponID;
    private String name;
    private double discount;

    public CouponDTO(String couponID, String name, double discount) {
        this.couponID = couponID;
        this.name = name;
        this.discount = discount;
    }

    public CouponDTO() {
    }

    public String getCouponID() {
        return couponID;
    }

    public void setCouponID(String couponID) {
        this.couponID = couponID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "CouponDTO{" + "couponID=" + couponID + ", name=" + name + ", discount=" + discount + '}';
    }
    
    
}
