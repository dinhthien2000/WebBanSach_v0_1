package phdhtl.cntt.dao;

import phdhtl.cntt.model.theloaiModel;
import phdhtl.cntt.util.connectSQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class theloaiDAO {
	private final String insertsql = "insert into TheLoai(MATL,TENTL) values(?,?);";
	private final String updatesql = "update TheLoai set TENTL=? where MATL=?";
	private final String deletesql = "delete from TheLoai where MATL=?";
	Connection connection = connectSQL.getConnection();
	
	public int insert(theloaiModel m) throws SQLException {
		
		PreparedStatement preparedStatement = connection.prepareStatement(insertsql);
		
		preparedStatement.setNString(1, m.getMatl());
		preparedStatement.setNString(2, m.getTentl());
		
		int kq = preparedStatement.executeUpdate();

		return kq;

	}
	
	public int update(theloaiModel m) throws SQLException {
		
		PreparedStatement preparedStatement = connection.prepareStatement(updatesql);
		
		
		preparedStatement.setNString(1, m.getTentl());
		
		preparedStatement.setNString(2, m.getMatl());
		
		int kq = preparedStatement.executeUpdate();

		return kq;

	}
	
	public int delete(String m) throws SQLException {
		
		PreparedStatement preparedStatement = connection.prepareStatement(deletesql);
		
		
		preparedStatement.setNString(1, m);
		
		
		
		int kq = preparedStatement.executeUpdate();

		return kq;

	}


}
