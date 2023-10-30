package DAO708;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model708.KhachHang708;

public class KhachHang708DAO extends ThanhVien708DAO {

    // Thêm khách hàng vào cơ sở dữ liệu
    public void addKhachHang(KhachHang708 khachHang) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = getConnection();
            String query = "INSERT INTO KhachHang708 (id, diaChi, email, sdt) VALUES (?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, khachHang.getId());
            preparedStatement.setString(2, khachHang.getDiaChi());
            preparedStatement.setString(3, khachHang.getEmail());
            preparedStatement.setString(4, khachHang.getSdt());
            preparedStatement.executeUpdate();
            System.out.println("KhachHang added to the database.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePreparedStatement(preparedStatement);
            closeConnection(connection);
        }
    }

    
}
