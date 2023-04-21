package phdhtl.cntt.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;


// lấy tên file ảnh từ đường dẫn part ở input ( đường dẫn );
public class getNameImg {
	// hàm trả về tên file ảnh và lưu ảnh vào thư mục img
	public static String imgFileName(Part imgPart,HttpServletRequest request) throws IOException {

		// lấy filename
		String fileNameImg = imgPart.getSubmittedFileName();
		// chọn thư mục để lưu trữ
		String folderUpload = request.getServletContext().getRealPath("/views/img1");
		// tạo đường dẫn đến thư múc upload (path)
		Path uploadPath = Paths.get(folderUpload);
		// kiểm tra đường dẫn đến thư mục upload coi có tồn tại chưa
		if (!Files.exists(uploadPath)) {
			Files.createDirectories(uploadPath);
		}
		// ghi ( lưu) fileName tên file ( là file cần lưu vào thư mục upload) vào đường
		// dẫn file Upload
		imgPart.write(Paths.get(uploadPath.toString(), fileNameImg).toString());
		
		// trả về tên file ảnh
		return fileNameImg;
	}
	
	// test lưu vào thư mục img
	public static void imgFileNameRootFolder(Part imgPart,HttpServletRequest request) throws IOException {

		// lấy filename
		String fileNameImg = imgPart.getSubmittedFileName();
		// chọn thư mục để lưu trữ
		String folderUpload = request.getServletContext().getRealPath("D:\\java1\\webBanSach\\src\\main\\webapp\\img");
		// tạo đường dẫn đến thư múc upload (path)
		Path uploadPath = Paths.get(folderUpload);
		// kiểm tra đường dẫn đến thư mục upload coi có tồn tại chưa
		if (!Files.exists(uploadPath)) {
			Files.createDirectories(uploadPath);
		}
		// ghi ( lưu) fileName tên file ( là file cần lưu vào thư mục upload) vào đường
		// dẫn file Upload
		imgPart.write(Paths.get(uploadPath.toString(), fileNameImg).toString());
		
		// trả về tên file ảnh
		
	}
}
