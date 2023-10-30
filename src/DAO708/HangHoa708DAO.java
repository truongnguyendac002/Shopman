package DAO708;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model708.HangHoa708;

public class HangHoa708DAO extends DAO708 {

	public void addHangHoa(HangHoa708 hangHoa) {
	    Connection connection = null;
	    PreparedStatement preparedStatement = null;

	    try {
	        connection = getConnection();
	        String query = "INSERT INTO HangHoa708 (ten, loai, mota, nhaCungCapID) VALUES (?, ?, ?, ?)";
	        preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
	        preparedStatement.setString(1, hangHoa.getTen());
	        preparedStatement.setString(2, hangHoa.getLoai());
	        preparedStatement.setString(3, hangHoa.getMota());
	        preparedStatement.setInt(4, hangHoa.getNhaCungCapID());
	        preparedStatement.executeUpdate();

	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        closePreparedStatement(preparedStatement);
	        closeConnection(connection);
	    }
	}
    
    public static List<HangHoa708> timKiemHangHoa(String tenHangHoa, int idNhaCungCap) {
        List<HangHoa708> result = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = getConnection();
            String query = "SELECT * FROM HangHoa708 WHERE nhaCungCapID = ? AND ten LIKE ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, idNhaCungCap);
            preparedStatement.setString(2, "%" + tenHangHoa + "%");
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String ten = resultSet.getString("ten");
                String loai = resultSet.getString("loai");
                String moTa = resultSet.getString("mota");
                int nhaCungCapID = resultSet.getInt("nhaCungCapID");

                HangHoa708 hangHoa = new HangHoa708(id, ten, loai, moTa, nhaCungCapID);
                result.add(hangHoa);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResultSet(resultSet);
            closePreparedStatement(preparedStatement);
            closeConnection(connection);
        }

        return result;
    }
    
    public static HangHoa708 getHangHoaById(int hangHoaId) {
        HangHoa708 hangHoa = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = getConnection();
            String query = "SELECT * FROM HangHoa708 WHERE id = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, hangHoaId);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String ten = resultSet.getString("ten");
                String loai = resultSet.getString("loai");
                String moTa = resultSet.getString("mota");
                int nhaCungCapID = resultSet.getInt("nhaCungCapID");

                hangHoa = new HangHoa708(hangHoaId, ten, loai, moTa, nhaCungCapID);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResultSet(resultSet);
            closePreparedStatement(preparedStatement);
            closeConnection(connection);
        }

        return hangHoa;
    }

    }
