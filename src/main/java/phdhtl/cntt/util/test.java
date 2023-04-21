package phdhtl.cntt.util;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class test {
	public static void main(String[] args) throws SQLException {

		Connection connection = connectSQL.getConnection();
		String id = "01";
		String sql = "select s.TenSach , s.Anhbia , s.Gia, s.SoTrang, tl.TENTL , tg.Tentg, xb.TenXB from Sach s , TheLoai tl , Tacgia tg , NhaXB xb"
				+ "where s.MaSach= '" + id + "' and s.MATL = tl.MATL and s.Matg =tg.Matg and s.MaXB = xb.MaXB;";
		String string = "select s.MaSach, s.TenSach , s.Anhbia , s.Gia, s.SoTrang, tl.TENTL , tg.Tentg, xb.TenXB\r\n"
				+ "from Sach s\r\n" + "left join TheLoai tl on s.MATL=tl.MATL \r\n"
				+ "left join Tacgia tg on s.Matg = tg.Matg\r\n" + "left join NhaXB xb on s.MaXB = xb.MaXB\r\n"
				+ "where s.MaSach= '01' ;";
		PreparedStatement preparedStatement = connection.prepareStatement(string);
		ResultSet rs = preparedStatement.executeQuery();
		while (rs.next()) {
			System.out.println(rs.getString(2));
		}
		int a = 1;
		a += 1;
		//System.out.println(a);
		String tk = "thiendnh";
		rs = gioHang_donHang.getGioHang(tk);
		while (rs.next()) {
			System.out.println(rs.getString(4));
		}
	
		Date ngaydat = dateUtil.dateCurrentSQL();
		System.out.println(ngaydat);
	}
}
