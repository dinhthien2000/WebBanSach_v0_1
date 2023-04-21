package phdhtl.cntt.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import phdhtl.cntt.dao.nhaxbDAO;
import phdhtl.cntt.model.nhaxbModel;

@WebServlet("/nhaxbServlet")
public class nhaxbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/views/admin/nhaxb.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String maxb = request.getParameter("maxb");
		String tenxb = request.getParameter("tenxb");
		String diachi = request.getParameter("diachi");
		String sdt = request.getParameter("sdt");
		String email = request.getParameter("email");
		
		nhaxbModel m = new nhaxbModel(maxb, tenxb, diachi, sdt, email);
		nhaxbDAO dao = new nhaxbDAO();
		int kq;
		
		switch (request.getParameter("action")) {
		case "add":
			kq = dao.insert(m);
			if(kq==1) {
				request.setAttribute("alert", "success");
			}else {
				request.setAttribute("alert", "fail");
			}
			break;
		case "update":
			kq = dao.update(m);
			if(kq==1) {
				request.setAttribute("alert", "success");
			}else {
				request.setAttribute("alert", "fail");
			}
			break;
		case "delete":
			kq = dao.delete(maxb);
			if(kq==1) {
				request.setAttribute("alert", "success");
			}else {
				request.setAttribute("alert", "fail");
			}
			break;

		default:
			break;
		}
		
		request.getRequestDispatcher("/views/admin/nhaxb.jsp").forward(request, response);
	}

}
