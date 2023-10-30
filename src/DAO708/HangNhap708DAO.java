package DAO708;

import model708.HangNhap708;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HangNhap708DAO extends DAO708 {

    private Connection connection;

    public HangNhap708DAO() {
        try {
			this.connection = getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    public void closeConnection() {
        DAO708.closeConnection(connection);
    }

    public void addHangNhap(HangNhap708 hangNhap) throws SQLException {
        String query = "INSERT INTO hangnhap708 (idHangHoa, donGia, soLuong, idHoaDon) VALUES (?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, hangNhap.getIdHangHoa());
            preparedStatement.setDouble(2, hangNhap.getDonGia());
            preparedStatement.setInt(3, hangNhap.getSoLuong());
            preparedStatement.setInt(4, hangNhap.getIdHoaDon());
            preparedStatement.executeUpdate();
        }
    }

    public HangNhap708 getHangNhapById(int id) throws SQLException {
        String query = "SELECT * FROM hangnhap708 WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return extractHangNhapFromResultSet(resultSet);
                }
            }
        }
        return null;
    }

    public List<HangNhap708> getHangNhapByHoaDonId(int idHoaDon) throws SQLException {
        List<HangNhap708> hangNhapList = new ArrayList<>();
        String query = "SELECT hn.idHangNhap, hn.idHangHoa, hh.ten AS tenHangHoa, hn.donGia, hn.soLuong, hn.idHoaDon " +
                       "FROM hangnhap708 hn " +
                       "JOIN hanghoa708 hh ON hn.idHangHoa = hh.id " +
                       "WHERE hn.idHoaDon = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, idHoaDon);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    HangNhap708 hangNhap = extractHangNhapFromResultSet(resultSet);
                    hangNhapList.add(hangNhap);
                }
            }
        }
        return hangNhapList;
    }

    private HangNhap708 extractHangNhapFromResultSet(ResultSet resultSet) throws SQLException {
        HangNhap708 hangNhap = new HangNhap708();
        hangNhap.setId(resultSet.getInt("idHangNhap"));
        hangNhap.setIdHangHoa(resultSet.getInt("idHangHoa"));
        hangNhap.setTen(resultSet.getString("tenHangHoa"));
        hangNhap.setDonGia(resultSet.getDouble("donGia"));
        hangNhap.setSoLuong(resultSet.getInt("soLuong"));
        hangNhap.setIdHoaDon(resultSet.getInt("idHoaDon"));
        return hangNhap;
    }
}
