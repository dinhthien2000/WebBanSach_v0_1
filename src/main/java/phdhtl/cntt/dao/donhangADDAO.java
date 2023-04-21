package phdhtl.cntt.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import phdhtl.cntt.util.connectSQL;
import phdhtl.cntt.util.dateUtil;

public class donhangADDAO {
	String trangthaiSQL ="update DonHangDT set TrangthaiDH='1',Ngaygiao=? where MaDH=?";
	
	public int xacnhanDH(String madh) {
		Connection  connection = connectSQL.getConnection();
		PreparedStatement preparedStatement;
		Date ngaygiao =dateUtil.dateCurrentSQL();
		try {
			preparedStatement = connection.prepareStatement(trangthaiSQL);
			preparedStatement.setDate(1, ngaygiao);
			preparedStatement.setString(2, madh);
			int kq = preparedStatement.executeUpdate();
			return kq;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		
	}
	
}
