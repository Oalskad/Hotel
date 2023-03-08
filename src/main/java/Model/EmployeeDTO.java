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
public class EmployeeDTO {
    private String employeeID;
    private String fname, lname, address, department;
    private int phone;

    public EmployeeDTO(String employeeID, String fname, String lname, String address, String department, int phone) {
        this.employeeID = employeeID;
        this.fname = fname;
        this.lname = lname;
        this.address = address;
        this.department = department;
        this.phone = phone;
    }

    public EmployeeDTO() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return "EmployeeDTO{" + "employeeID=" + employeeID + ", fname=" + fname + ", lname=" + lname + ", address=" + address + ", department=" + department + ", phone=" + phone + '}';
    }

    
    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }
    
}
