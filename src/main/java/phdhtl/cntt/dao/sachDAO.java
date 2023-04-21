package phdhtl.cntt.dao;

import phdhtl.cntt.model.sachModel;
import phdhtl.cntt.util.connectSQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class sachDAO {
	private final String insertSQL = "insert into Sach(MaSach,TenSach,Anhbia,SoTrang,Gia,SoLuong,Ngaythem,Mota,Matg,MATL,MaXB)"
			+ "values (?,?,?,?,?,?,?,?,?,?,?);";
	private final String updateImgSQL = "update Sach set "
			+ "TenSach=?,Anhbia=?,SoTrang=?,Gia=?,SoLuong=?,Ngaythem=?,Mota=?,Matg=?,MATL=?,MaXB=? where MaSach=?; ";
	private final String updateSQL = "update Sach set "
			+ "TenSach=?,SoTrang=?,Gia=?,SoLuong=?,Ngaythem=?,Mota=?,Matg=?,MATL=?,MaXB=? where MaSach=?; ";
	
	private final String deleteSQL = "delete from Sach where MaSach=?";
	
	Connection connection = connectSQL.getConnection();
	
	public int insert(sachModel m) {	
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setNString(1, m.getMasach());
			preparedStatement.setNString(2, m.getTensach());
			preparedStatement.setNString(3, m.getAnhbia());
			preparedStatement.setInt(4, m.getSotrang());
			preparedStatement.setFloat(5, m.getGia());
			preparedStatement.setFloat(6, m.getSoluong());
			preparedStatement.setDate(7, m.getNgaythem());
			preparedStatement.setNString(8, m.getMota());
			preparedStatement.setNString(9, m.getMatg());
			preparedStatement.setNString(10, m.getMatl());
			preparedStatement.setNString(11, m.getMaxb());
			
			int kq = preparedStatement.executeUpdate();
			
			return kq;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
		
	}
	
	// thay đổi hình ảnh 
	public int updateImg(sachModel m) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(updateImgSQL);
			
			preparedStatement.setNString(1, m.getTensach());
			preparedStatement.setNString(2, m.getAnhbia());
			preparedStatement.setInt(3, m.getSotrang());
			preparedStatement.setFloat(4, m.getGia());
			preparedStatement.setInt(5, m.getSoluong());
			preparedStatement.setDate(6, m.getNgaythem());
			preparedStatement.setNString(7, m.getMota());
			preparedStatement.setNString(8, m.getMatg());
			preparedStatement.setNString(9, m.getMatl());
			preparedStatement.setNString(10, m.getMaxb());
			preparedStatement.setNString(11, m.getMasach());
			int kq = preparedStatement.executeUpdate();
			
			return kq;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
		
	}
	
	// giữ nguyên hình ảnh
	public int update(sachModel m) {	
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(updateSQL);
			
			preparedStatement.setNString(1, m.getTensach());
			
			preparedStatement.setInt(2, m.getSotrang());
			preparedStatement.setFloat(3, m.getGia());
			preparedStatement.setInt(4, m.getSoluong());
			preparedStatement.setDate(5, m.getNgaythem());
			preparedStatement.setNString(6, m.getMota());
			preparedStatement.setNString(7, m.getMatg());
			preparedStatement.setNString(8, m.getMatl());
			preparedStatement.setNString(9, m.getMaxb());
			preparedStatement.setNString(10, m.getMasach());
			int kq = preparedStatement.executeUpdate();
			
			return kq;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
		
	}
	
	
}
