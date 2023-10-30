package DAO708;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model708.NhaCungCap708;

public class NhaCungCap708DAO extends DAO708 {

	public void addNhaCungCap(NhaCungCap708 nhaCungCap) {
	    Connection connection = null;
	    PreparedStatement preparedStatement = null;

	    try {
	        connection = getConnection();
	        String query = "INSERT INTO NhaCungCap708 (tenNhaCungCap, diaChi, sdt) VALUES (?, ?, ?)";
	        preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
	        preparedStatement.setString(1, nhaCungCap.getTenNhaCungCap());
	        preparedStatement.setString(2, nhaCungCap.getDiaChi());
	        preparedStatement.setString(3, nhaCungCap.getSdt());

	        int affectedRows = preparedStatement.executeUpdate();

	        if (affectedRows > 0) {
	            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
	            if (generatedKeys.next()) {
	                int generatedId = generatedKeys.getInt(1);
	                nhaCungCap.setId(generatedId);
	                System.out.println("NhaCungCap added to the database with id: " + generatedId);
	            } else {
	                System.out.println("Failed to retrieve auto-generated key.");
	            }
	        } else {
	            System.out.println("Failed to add NhaCungCap to the database.");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        closePreparedStatement(preparedStatement);
	        closeConnection(connection);
	    }
	}


    public List<NhaCungCap708> searchNhaCungCap(String keyword) {
        List<NhaCungCap708> result = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = getConnection();
            String query = "SELECT * FROM NhaCungCap708 WHERE tenNhaCungCap LIKE ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "%" + keyword + "%");
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String tenNhaCungCap = resultSet.getString("tenNhaCungCap");
                String diaChi = resultSet.getString("diaChi");
                String sdt = resultSet.getString("sdt");

                NhaCungCap708 nhaCungCap = new NhaCungCap708(id, tenNhaCungCap, diaChi, sdt);
                result.add(nhaCungCap);
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
}
