/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Admin;

import Utils.DBUtils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



/**
 *
 * @author Oalskad
 */
public class AdminDAO {
      public AdminDTO login(String user, String password) {
        String sql = "select adminName, adminPassword from admin"
                + " where adminName = ? and adminPassword = ?  ";
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setString(1, user);
            ps.setString(2, password);
            
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                
                AdminDTO adminDTO =  new AdminDTO();
                 adminDTO.setAdminName(rs.getString("adminName"));
                 adminDTO.setAdminPassword(rs.getString("adminPassword"));
                 return adminDTO;
                
            }
        }
        catch (Exception ex) {
            System.out.println("Query admin error!" + ex.getMessage());
        }
        return null;
    }
  
}
