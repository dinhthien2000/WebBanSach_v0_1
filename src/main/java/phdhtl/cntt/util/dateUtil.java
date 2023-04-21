package phdhtl.cntt.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class dateUtil {
	// lấy ngày hiện tại từ String sang Date (dùng để lưu vào sql)
	public static Date dateCurrentSQL() {
		LocalDate date = LocalDate.now(); // lấy ngày hiện tại

		// định dạng ngày theo kiểu dd-MM-yyyy
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		// đổi từ String sang date
		Date dateSQL = Date.valueOf(date.format(formatter));

		// trả về
		return dateSQL;
	}

	
	
	// Date to String định dạng lại format
	public static String dateFormat(Date date) {
		// date sql sài phương thức trên kia ( trên kìa trả về String ) đây là kiểu Date
		DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		String dateString = formatter.format(date);

		return dateString;
	}

	
	
	// lấy ngày hiện tại String
	public static void dateS() {
		LocalDate date = LocalDate.now(); // lấy ngày hiện tại

		// định dạng ngày theo kiểu dd-MM-yyyy
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		// đổi từ String sang date
		System.out.println(date.format(formatter));
	}

	
	public static void main(String[] args) {
		Date date = dateCurrentSQL();
		String s = dateFormat(date);
		System.out.println(s);
		dateS();
	}
}
