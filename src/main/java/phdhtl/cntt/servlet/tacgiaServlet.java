package phdhtl.cntt.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import phdhtl.cntt.dao.tacgiaDAO;
import phdhtl.cntt.model.tacgiaModel;

/**
 * Servlet implementation class tacgiaServlet
 */
@WebServlet("/tacgiaServlet")
public class tacgiaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("/views/admin/tacgia.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		/*
		 * if (request.getParameter("action").equalsIgnoreCase("add")) { String matg =
		 * request.getParameter("matg"); String tentg = request.getParameter("tentg");
		 * String quoctich = request.getParameter("quoctich");
		 * 
		 * tacgiaModel m = new tacgiaModel(matg,tentg,quoctich); tacgiaDAO d = new
		 * tacgiaDAO();
		 * 
		 * 
		 * int kq = d.insert(m); if (kq==1) { request.setAttribute("alert", "success");
		 * 
		 * }else { request.setAttribute("alert", "fail"); }
		 * 
		 * request.getRequestDispatcher("/views/tacgia.jsp").forward(request, response);
		 * }
		 */
		String matg = request.getParameter("matg");
		String tentg = request.getParameter("tentg");
		String quoctich = request.getParameter("quoctich");

		tacgiaModel m = new tacgiaModel(matg, tentg, quoctich);
		tacgiaDAO d = new tacgiaDAO();
		int kq;
		
		switch (request.getParameter("action")) {


		case "add":
		

			 kq = d.insert(m);
			if (kq == 1) {
				request.setAttribute("alert", "success");

			} else {
				request.setAttribute("alert", "fail");
			}


			break;
		case "update":


			 kq = d.update(m);
			if (kq == 1) {
				request.setAttribute("alert", "success");

			} else {
				request.setAttribute("alert", "fail");
			}
			
			
			break;
			
		case "delete":


			 kq = d.delete(matg);
			if (kq == 1) {
				request.setAttribute("alert", "success");

			} else {
				request.setAttribute("alert", "fail");
			}
			
			
			break;
		default:
			break;
		}
		request.getRequestDispatcher("/views/admin/tacgia.jsp").forward(request, response);
	}

}
