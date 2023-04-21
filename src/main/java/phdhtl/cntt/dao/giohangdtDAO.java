package phdhtl.cntt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



import phdhtl.cntt.model.giohangdtModel;
import phdhtl.cntt.model.sachModel;
import phdhtl.cntt.util.connectSQL;

public class giohangdtDAO {
	 final String insertSQL = "insert into GiohangDT(MaSach,Gia,MaKH) values (?,?,?);";
	 final String updateSQL = "update GiohangDT set MaSach=?,Soluong=?,Gia=?,MaKH=?,Trangthai=? where MaGH=?";
	 final String deleteSQl = "delete from GiohangDT where MaGH=?";
	 
	 Connection connection= null;
	 
	 public int insert(giohangdtModel model) {
		 connection = connectSQL.getConnection();
		 try {
			PreparedStatement preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, model.getMasach());
			preparedStatement.setFloat(2, model.getGia());
			preparedStatement.setString(3,model.getMakh());
			int kq = preparedStatement.executeUpdate();
			
			return kq;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		 return 0;
		 
	 }
	 
	 // xóa sản phẩm trong giỏ hàng
	 public static void delete(String ma)  {
		Connection connection = connectSQL.getConnection();
		String sql = "delete from GiohangDT where MaGH=?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, ma);
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	 
	 
	 // select lấy masach và giá 
	 public sachModel getSachGH (String ma) {
		 sachModel model = new sachModel();
		 String sql = "select * from Sach where MaSach=?";
		  
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, ma);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				model.setMasach(rs.getNString("MaSach"));
				model.setGia(rs.getFloat("Gia"));
				return model;
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return null;
		 
	 }
}
