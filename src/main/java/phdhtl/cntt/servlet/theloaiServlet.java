package phdhtl.cntt.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import phdhtl.cntt.dao.theloaiDAO;
import phdhtl.cntt.model.theloaiModel;

/**
 * Servlet implementation class theloaiServlet
 */
@WebServlet("/theloaiServlet")
public class theloaiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/views/admin/theloai.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String matl = request.getParameter("matl");
		String tentl = request.getParameter("tentl");
		
		theloaiModel m = new theloaiModel(matl,tentl);
		theloaiDAO d = new theloaiDAO();
		
		if (request.getParameter("action").equalsIgnoreCase("add")) {

			try {
				int kq = d.insert(m);

				if (kq == 1) {
					request.setAttribute("alert", "success");
				} else {
					request.setAttribute("alert", "fail");
				}

			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}else if (request.getParameter("action").equalsIgnoreCase("update")) {
			try {
				int kq = d.update(m);

				if (kq == 1) {
					request.setAttribute("alert", "success");
				} else {
					request.setAttribute("alert", "fail");
				}


			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}else {
			try {
				int kq = d.delete(matl);

				if (kq == 1) {
					request.setAttribute("alert", "success");
				} else {
					request.setAttribute("alert", "fail");
				}


			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		

		request.getRequestDispatcher("/views/admin/theloai.jsp").forward(request, response);
	}

}
