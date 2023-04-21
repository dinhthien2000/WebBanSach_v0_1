package phdhtl.cntt.util;

import java.util.Random;


// class tạo Mã id
public class idString {

	public static String _createID(String s) {
		// cắt chuỗi từ index 0 - 4 nối với mã băm của chuỗi
		//return s.substring(0, 4)+Integer.toString(s.hashCode()); //
		return s.substring(0,5)+randomNumber();
		  
	}
	// random từ 0-9999
	public static int randomNumber() {
		Random verification = new Random();
		int key= verification.nextInt(9999);
		return key;
	}
}
