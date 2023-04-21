package phdhtl.cntt.servlet;

import phdhtl.cntt.util.getNameImg;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class testImgServlet
 */
@WebServlet("/testImgServlet")
@MultipartConfig(maxFileSize = 4194304)// upload 4MB img
public class testImgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/test/testImg.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			Part file = request.getPart("file");
			getNameImg.imgFileNameRootFolder(file, request);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("/test/testImg.jsp").forward(request, response);
	}

}
