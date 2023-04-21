package phdhtl.cntt.dao;

import phdhtl.cntt.model.tacgiaModel;
import phdhtl.cntt.util.connectSQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class tacgiaDAO {
	private static String insertSQL = "insert into Tacgia(Matg,Tentg,Quoctich) values (?,?,?);";
	private static String updateSQL = "update Tacgia set Tentg=?,Quoctich=? where Matg=?;";
	private static String deleteSQL = "delete from Tacgia where Matg=?;";
	
	Connection connection = connectSQL.getConnection();
	
	public int insert(tacgiaModel m) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setNString(1, m.getMatg());
			preparedStatement.setNString(2, m.getTentg());
			preparedStatement.setNString(3, m.getQuoctich());
			
			int kq = preparedStatement.executeUpdate();
			
			return kq;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return 0;
	}
	
	public int update(tacgiaModel m) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(updateSQL);
			preparedStatement.setNString(3, m.getMatg());
			preparedStatement.setNString(1, m.getTentg());
			preparedStatement.setNString(2, m.getQuoctich());
			
			int kq = preparedStatement.executeUpdate();
			
			return kq;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return 0;
	}
	

	public int delete(String  matg) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL);
			preparedStatement.setNString(1,matg);
		
			
			int kq = preparedStatement.executeUpdate();
			
			return kq;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return 0;
	}
	
	
}
