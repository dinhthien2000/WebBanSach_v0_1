package phdhtl.cntt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import phdhtl.cntt.model.userModel;
import phdhtl.cntt.util.connectSQL;

public class userDAO {
	// gồm : đăng ký , đăng nhập, sửa , xóa;
	final String insertSQL = "insert into KhachHang(MaKH,Taikhoan,Matkhau,Diachi,SDT,Email) values(?,?,?,?,?,?) ";
	final String updateSQL = "update KhachHang set MatKhau=?,Diachi=?,SDT=?,Email=? where MaKH=?";
	final String deleteSQL = "delete from KhachHang where MaKH=?";

	Connection connection = connectSQL.getConnection();

	public int insert(userModel m) {
		PreparedStatement preparedStatement;
		try {
			if (checkTaiKhoan(m) == null) {
				preparedStatement = connection.prepareStatement(insertSQL);
				preparedStatement.setNString(1, m.getMakh());
				preparedStatement.setNString(2, m.getTaikhoan());
				preparedStatement.setNString(3, m.getMatkhau());
				preparedStatement.setNString(4, m.getDiachi());
				preparedStatement.setNString(5, m.getSdt());
				preparedStatement.setNString(6, m.getEmail());

				int kq = preparedStatement.executeUpdate();
				return kq;

			} else {
				return 0;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;

	}

	public int update(userModel m) {
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(updateSQL);

			
			preparedStatement.setNString(1, m.getMatkhau());
			preparedStatement.setNString(2, m.getDiachi());
			preparedStatement.setNString(3, m.getSdt());
			preparedStatement.setNString(4, m.getEmail());
			preparedStatement.setNString(5, m.getMakh());

			int kq = preparedStatement.executeUpdate();
			return kq;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;

	}

	int delete(String makh) {
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(deleteSQL);

			preparedStatement.setNString(1, makh);
			int kq = preparedStatement.executeUpdate();
			return kq;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	// đăng nhập
	public userModel checkDangNhap(userModel model) {
		String sql = "select * from KhachHang where Taikhoan=? and Matkhau=?"; // chạy sql điều kiện là taikhoan
		try {
			// thực thi câu sql
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, model.getTaikhoan());
			preparedStatement.setString(2, model.getMatkhau());
			ResultSet rs = preparedStatement.executeQuery();

			// chạy vòng bảng KhachHang rồi lưu vào đối tượng ResultSet
			while (rs.next()) {
				model.setTaikhoan(rs.getString("Taikhoan"));
				model.setMatkhau(rs.getString("Matkhau"));
				return model; // nếu đã tồn tại thì return taikhoan để đăng nhập
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null; // tài khoản không tồn return null ( sai tài khoản hoặc mật khẩu )

	}

	// check tồn tại để đăng ký
	public userModel checkTaiKhoan(userModel model) {
		String sql = "select * from KhachHang where Taikhoan=?"; // chạy sql điều kiện là taikhoan
		try {
			// thực thi câu sql
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, model.getTaikhoan());
			ResultSet rs = preparedStatement.executeQuery();

			// chạy vòng bảng KhachHang rồi lưu vào đối tượng ResultSet
			while (rs.next()) {
				model.setTaikhoan(rs.getString("Taikhoan"));
				return model; // nếu đã tồn tại thì return taikhoan
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null; // tài khoản chưa đăng ký thì return null

	}

	// lấy makh bằng tên tài khoản
	public static String getMakh (String taikhoan) {
		userModel model = new userModel();
		String sql ="select * from Khachhang where Taikhoan=?";
		Connection connection = connectSQL.getConnection();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, taikhoan);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				model.setMakh(rs.getString(1));
				return model.getMakh();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
