package phdhtl.cntt.servlet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import phdhtl.cntt.dao.donhangDAO;
import phdhtl.cntt.dao.userDAO;
import phdhtl.cntt.model.donhangModel;
import phdhtl.cntt.util.dateUtil;

/**
 * Servlet implementation class donhangServlert
 */
@WebServlet("/donhangServlert")
public class donhangServlert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/views/donhang.jsp").forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Date d = dateUtil.dateCurrentSQL();
		System.out.println(d);

		HttpSession session = request.getSession();
		String tentk = (String) session.getAttribute("user");
		String ma = userDAO.getMakh(tentk);
		donhangModel model = new donhangModel(d,ma);
		
		
		donhangDAO dao = new donhangDAO();
		int kq = dao.insert(model);
		
		if (kq<1) {
			request.setAttribute("alert", "fail");
			request.getRequestDispatcher("/views/giohang.jsp").forward(request, response);
		}else {
			int k = donhangDAO.updateTrangThai(kq, ma);
			if(k>=1)
				request.setAttribute("alert", "success");
				request.getRequestDispatcher("/views/index.jsp").forward(request, response);
		}
	}

}
