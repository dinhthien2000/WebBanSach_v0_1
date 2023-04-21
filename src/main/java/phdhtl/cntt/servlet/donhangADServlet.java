package phdhtl.cntt.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import phdhtl.cntt.dao.donhangADDAO;

/**
 * Servlet implementation class donhangADServlet
 */
@WebServlet("/donhangADServlet")
public class donhangADServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String madh = request.getParameter("id");
		donhangADDAO dao = new donhangADDAO();
		
		int kq = dao.xacnhanDH(madh);
		if (kq==0) {
			request.setAttribute("alert", "Thất bại");
		}else {
			request.setAttribute("alert", "Thành công");
		}
		
		request.getRequestDispatcher("/views/admin/donhangAD.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
