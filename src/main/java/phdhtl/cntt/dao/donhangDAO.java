package phdhtl.cntt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import phdhtl.cntt.model.donhangModel;
import phdhtl.cntt.util.connectSQL;

public class donhangDAO {
	final String insertSQL = "INSERT INTO DonHangDT(MaSach,Soluong,Gia,Ngaydat,MaKH) \r\n"
			+ "SELECT MaSach,Soluong,Gia,?,?\r\n" + "FROM GiohangDT\r\n" + "WHERE MaKH=? and Trangthai='0';";

	final String updateTrangThai = "update DonHangDT set Trangthai='1' where MaDH=?";
	final String deleteSQL = "delete form DonHangDT where MaGH=?";

	public int insert(donhangModel model) {
		Connection connection = connectSQL.getConnection();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setDate(1, model.getNgaydat());
			preparedStatement.setString(2, model.getMakh());
			preparedStatement.setString(3, model.getMakh());
			int kq = preparedStatement.executeUpdate();

			return kq;
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return 0;
	}

	// update giỏ hàng lại trạng thái thành 1 hết ( đã đặt hàng )
	public static int updateTrangThai(int kq, String ma) {
		if (kq >= 1) {
			String sql = "update GiohangDT set Trangthai='1' where MaKH=?";
			Connection connection = connectSQL.getConnection();
			try {
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, ma);
				int ketqua = preparedStatement.executeUpdate();
				return ketqua;
			} catch (SQLException e) {

				e.printStackTrace();
			}

		}
		return 0;
	}

	// update đơn hàng lại trạng thái thành 1 hết ( đã giao )
	public int updateTT(String MaDH) {
		Connection connection = connectSQL.getConnection();
		PreparedStatement preparedStatement;
		int kq = 0;
		try {
			preparedStatement = connection.prepareStatement(updateTrangThai);
			preparedStatement.setString(1, MaDH);
			return kq = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;

	}

}
