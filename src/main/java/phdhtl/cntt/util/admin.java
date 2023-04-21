package phdhtl.cntt.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class admin {
	public static int _DangGiao() {
		String sql = "SELECT COUNT(*) as dgg FROM DonHangDT WHERE  TrangthaiDH='0'";
		Connection connection = connectSQL.getConnection();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return 0;
		
	}
	
	public static int _DaGiao() {
		String sql = "SELECT COUNT(*) as dg FROM DonHangDT WHERE  TrangthaiDH='1'";
		Connection connection = connectSQL.getConnection();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return 0;
		
	}
}
