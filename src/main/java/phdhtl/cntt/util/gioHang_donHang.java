package phdhtl.cntt.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import phdhtl.cntt.model.sachModel;

// class bao gôm các hàm liên quan đến giỏ hàng và đơn hàng
public class gioHang_donHang {

	// check coi có tồn tại sp chưa với điều kiện là mã sách
	public static int checkExitsSach(String mas,String makh) {
		Connection connection = connectSQL.getConnection();
		String sql = "Select * from GiohangDT where MaSach=? and MaKH=? and Trangthai='0';";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, mas);
			preparedStatement.setString(2, makh);
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				return rs.getInt("MaGH"); // có tồn tại tra~ ve` ma~ gio~ hang`

			} else {
				return 0; // không tồn tại
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return 0;
	}

	// hàm truy vấn bảng giỏ hàng
	public static ResultSet queryGioHang() {
		Connection connection = connectSQL.getConnection();
		String sql = "Select * from GiohangDT;";
		ResultSet rs = null;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			rs = preparedStatement.executeQuery();
			return rs;
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return rs;
	}

	// hàm lấy số lượng từ giỏ hàng
	public static int queryGioHangSL(int magh) {
		Connection connection = connectSQL.getConnection();
		String sql = "Select * from GiohangDT where MaGH=?;";
		ResultSet rs = null;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, magh);
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				return rs.getInt("Soluong");
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return 0;
	}

	// cập nhật giỏ hàng
	// hàm nếu tồn tại trong giỏ hàng rồi thì tăng số lượng
	public static int upToSoluong(int magh) {
		// gọi hàm truy vấn giỏ hàng lấy số lượng
		int soluong = queryGioHangSL(magh);
		try {

			soluong++;
			String sql = "update GiohangDT set Soluong=? where MaGH=?;"; // update khi số lượng khi sách đã tồn tại
			Connection connection = connectSQL.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, soluong);
			preparedStatement.setInt(2, magh);
			int kq = preparedStatement.executeUpdate();
			return kq;

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return 0;

	}

	// cập nhật giỏ hàng
	// chưa tồn tại sản phẩm add sp (đợi DAO ở giỏ hàng hàm add)

	// hàm lấy makh từ username
	public static String getMaKH(String taikhoan) throws SQLException {
		String sql = "select*from KhachHang where TaiKhoan=?";
		Connection connection = connectSQL.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, taikhoan);
		ResultSet rs = preparedStatement.executeQuery();

		while (rs.next()) {
			return rs.getString("MaKH");
		}
		return null;
	}

	// lấy thuộc tính của Sách
	public sachModel getSach(String Ma) throws SQLException {

		String sql = "select*from Sach where MaSach=?";
		Connection connection = connectSQL.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, Ma);
		ResultSet rs = preparedStatement.executeQuery();

		while (rs.next()) {
			sachModel model = new sachModel(rs.getString(1), rs.getNString(2), rs.getString(3), rs.getInt(4),
					rs.getFloat(5), rs.getInt(6), rs.getDate(7), rs.getString(8), rs.getString(9), rs.getString(10),
					rs.getString(11));
			return model;
		}
		return null;
	}

	// chi tiết giỏ hàng
	public static ResultSet getGioHang(String ma) throws SQLException {
		Connection connection = connectSQL.getConnection();
		String sql = "select gh.MaGH,gh.Soluong,gh.Gia, s.TenSach,s.Anhbia \r\n"
				+ "from GiohangDT gh left join Sach s on s.MaSach=gh.MaSach where gh.MaKH=? and Trangthai='0';";
		// String tk = getMaKH();
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, ma);
		ResultSet rs = preparedStatement.executeQuery();

		return rs;

	}

	// hàm get mã giỏ hàng, trả về các mã số giỏ hàng vào một mảng theo điều kiện username
	public static ArrayList<Integer> getMaGH(String makh) throws SQLException {
		ArrayList<Integer> getGH =new ArrayList<Integer>();
		String sql ="select * from GiohangDT where MaKH=? and Trangthai='0';";
		Connection connection = connectSQL.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet rs = preparedStatement.executeQuery();
		while(rs.next()) {
			getGH.add(rs.getInt(1));
		}
		return  getGH;
	}
	
	
	// hàm copy mã giỏ hàng
	public static int copyMaGH(String makh) throws SQLException {
		Connection connection = connectSQL.getConnection();
		String sql = "INSERT INTO DonHangDT(MaGH)\r\n" + "SELECT MaGH\r\n" + "FROM GiohangDT\r\n"
				+ "WHERE MaKH=? and Trangthai='0';";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, makh);
		int kq = preparedStatement.executeUpdate();
		return kq;
	}
	// hàm update lại các giá trị của đơn đặt hàng
	public static int updateValueDH() {
		return 0;
	}
	
	// hàm update số lượng 
	public static int updateSoLuong(String ma,int soluong) throws SQLException {
		String sql ="update GiohangDT set Soluong=? where MaGH=?";
		Connection connection = connectSQL.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, soluong);
		preparedStatement.setString(2,ma );
		int kq=preparedStatement.executeUpdate();
		
		return kq;
	}
	
	
	// hàm trạng thái đã giao hay đang giao
	public static String _TrangThai(Boolean b) {
		if (b) {
			return "Đã giao";
		}else {
			return "Đang giao";
		}
	}
	
	// hàm đổi trạng thái của giỏ hàng từ false sang true ( để sau này người dùng
	// coi giỏ hàng false là chưa đặt, còn true là đã đặt không hiện ra nữa )
	// hàm trạng thái đã giao đơn hàng cho admin xử lý

}
