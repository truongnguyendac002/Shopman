package DAO708;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model708.ThanhVien708;

public class ThanhVien708DAO extends DAO708 {

    public void addThanhVien(ThanhVien708 thanhVien) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = getConnection();
            String query = "INSERT INTO ThanhVien708 (tenTaiKhoan, matKhau, vaiTro) VALUES (?, ?, ?)";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, thanhVien.getTenTaiKhoan());
            preparedStatement.setString(2, thanhVien.getMatKhau());
            preparedStatement.setString(3, thanhVien.getVaiTro());
            preparedStatement.executeUpdate();
            System.out.println("ThanhVien added to the database.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePreparedStatement(preparedStatement);
            closeConnection(connection);
        }
    }

    public int getIdByTaiKhoan(String taiKhoan) {
        int thanhVienId = 0;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = getConnection();
            String query = "SELECT id FROM ThanhVien708 WHERE tenTaiKhoan = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, taiKhoan);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                thanhVienId = resultSet.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResultSet(resultSet);
            closePreparedStatement(preparedStatement);
            closeConnection(connection);
        }

        return thanhVienId;
    }

}
