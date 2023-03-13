/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbmanager;

import Model.ImageDTO;
import Model.UserDTO;
import Utils.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Oalskad
 */
public class ImageDAO implements DAOInterface<ImageDTO> {

    @Override
    public boolean insert(ImageDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(ImageDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(ImageDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean select(ImageDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ImageDTO> list() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<ImageDTO> listImageSelectById(String imgID) {
        ImageDTO imageDTO = null;
        List<ImageDTO> listImg = new ArrayList();
        try {

            // Bước 1: tạo kết nối đến CSDL
            Connection con = DBUtils.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "SELECT * FROM [dbo].[Image] where roomID=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, imgID);

            // Bước 3: thực thi câu lệnh SQL
            System.out.println(sql);
            ResultSet rs = st.executeQuery();

            // Bước 4:
            while (rs.next()) {
                imageDTO = new ImageDTO();
                imageDTO.setRoomID(rs.getString("roomID"));
                imageDTO.setImgSrc(rs.getString("imgSrc"));
                listImg.add(imageDTO);

            }

            // Bước 5:
            DBUtils.closeConnection(con);
            return listImg;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return listImg;
    }

    public static void main(String[] args) {
        ImageDAO imgDAO = new ImageDAO();
        List<ImageDTO> listImg = imgDAO.listImageSelectById("RO001");
        System.out.println(listImg.size());
        for (ImageDTO a : listImg) {
            System.out.println(a.getImgSrc());
        }
    }

}
