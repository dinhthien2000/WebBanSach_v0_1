package phdhtl.cntt.dao;

import phdhtl.cntt.model.nhaxbModel;
import phdhtl.cntt.util.connectSQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class nhaxbDAO {
	private final String insertSQL = "insert into NhaXB(MaXB,TenXB,Diachi,SDT,Email) values(?,?,?,?,?);";
	private final String updateSQL = "update NhaXB set TenXB=?,Diachi=?,SDT=?,Email=? where MaXB=?;";
	private final String deleteSQL = "delete from NhaXB where MaXB=?";

	Connection connection = connectSQL.getConnection();

	public int insert(nhaxbModel m) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setNString(1, m.getMaxb());
			preparedStatement.setNString(2, m.getTenxb());
			preparedStatement.setNString(3, m.getDiachi());
			preparedStatement.setNString(4, m.getSdt());
			preparedStatement.setNString(5, m.getEmail());

			int kq = preparedStatement.executeUpdate();
			return kq;

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return 0;
	}

	public int update(nhaxbModel m) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(updateSQL);

			preparedStatement.setNString(1, m.getTenxb());
			preparedStatement.setNString(2, m.getDiachi());
			preparedStatement.setNString(3, m.getSdt());
			preparedStatement.setNString(4, m.getEmail());
			preparedStatement.setNString(5, m.getMaxb());

			int kq = preparedStatement.executeUpdate();
			return kq;

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return 0;
	}

	public int delete(String ma) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL);
			preparedStatement.setNString(1, ma);
			

			int kq = preparedStatement.executeUpdate();
			return kq;

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return 0;
	}
}
