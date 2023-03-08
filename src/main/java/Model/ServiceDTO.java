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
public class ServiceDTO {
    private EmployeeDTO employeeDTO;
    
    private String servID;
    private String servName;
    private double price;
    private String desc;

    public ServiceDTO(EmployeeDTO employeeDTO, String servID, String servName, double price, String desc) {
        this.employeeDTO = employeeDTO;
        this.servID = servID;
        this.servName = servName;
        this.price = price;
        this.desc = desc;
    }

    public ServiceDTO() {
    }

    @Override
    public String toString() {
        return "ServiceDTO{" + "employeeDTO=" + employeeDTO + ", servID=" + servID + ", servName=" + servName + ", price=" + price + ", desc=" + desc + '}';
    }

    public EmployeeDTO getEmployeeDTO() {
        return employeeDTO;
    }

    public void setEmployeeDTO(EmployeeDTO employeeDTO) {
        this.employeeDTO = employeeDTO;
    }

    public String getServID() {
        return servID;
    }

    public void setServID(String servID) {
        this.servID = servID;
    }

    public String getServName() {
        return servName;
    }

    public void setServName(String servName) {
        this.servName = servName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
    
}
