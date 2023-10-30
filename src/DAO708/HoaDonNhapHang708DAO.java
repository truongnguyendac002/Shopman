package DAO708;

import model708.HoaDonNhapHang708;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class HoaDonNhapHang708DAO extends DAO708 {

    private Connection connection;

    public HoaDonNhapHang708DAO() {
        try {
            this.connection = DAO708.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        DAO708.closeConnection(connection);
    }
    
    public HoaDonNhapHang708 getHoaDonNhapById(int id) throws SQLException {
        String query = "SELECT * FROM hoadonhangnhap708 WHERE id = ?";
        try (Connection connection = DAO708.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return extractHoaDonNhapFromResultSet(resultSet);
                }
            }
        }
        return null;
    }

    public int luuHoaDonNhapHang(HoaDonNhapHang708 hoaDonNhap) throws SQLException {
        String query = "INSERT INTO hoadonhangnhap708 (ngayNhapHang, tongTien) VALUES (?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setDate(1, Date.valueOf(hoaDonNhap.getNgayNhapHang()));
            preparedStatement.setDouble(2, hoaDonNhap.getTongTien());
            preparedStatement.executeUpdate();

            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                }
            }
        }
        return -1; 
    }
    
    private HoaDonNhapHang708 extractHoaDonNhapFromResultSet(ResultSet resultSet) throws SQLException {
        HoaDonNhapHang708 hoaDonNhap = new HoaDonNhapHang708();
        hoaDonNhap.setId(resultSet.getInt("id"));

        Date ngayNhapHangSql = resultSet.getDate("ngayNhapHang");
        LocalDate ngayNhapHang = ngayNhapHangSql.toLocalDate();
        hoaDonNhap.setNgayNhapHang(ngayNhapHang);

        hoaDonNhap.setTongTien(resultSet.getDouble("tongTien"));
        return hoaDonNhap;
    }

}
