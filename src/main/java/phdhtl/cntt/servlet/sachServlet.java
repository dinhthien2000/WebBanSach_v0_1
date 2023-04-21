package phdhtl.cntt.servlet;

import phdhtl.cntt.dao.sachDAO;
import phdhtl.cntt.model.sachModel;
import phdhtl.cntt.util.*;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class sachServlet
 */
@WebServlet("/sachServlet")
@MultipartConfig(maxFileSize = 4194304) // upload 4MB img
public class sachServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/views/admin/sanphamAD.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			request.setCharacterEncoding("UTF-8");



		if (request.getParameter("action").equalsIgnoreCase("add")) {
			String masach = request.getParameter("masach");
			String tensach = request.getParameter("tensach");

			Part img = request.getPart("anhbia");// get Part đường dẫn
			String anhbia = getNameImg.imgFileName(img, request); // truyển tham số là Part ròi lấy tên tên file Img

			int sotrang = Integer.parseInt(request.getParameter("sotrang"));
			float gia = Float.parseFloat(request.getParameter("gia"));
			int soluong = Integer.parseInt(request.getParameter("soluong"));
			Date ngaythem = dateUtil.dateCurrentSQL(); // lấy ngày hiện tại
			String mota = request.getParameter("mota");
			String matg = request.getParameter("matg");
			String matl = request.getParameter("matl");
			String maxb = request.getParameter("maxb");

			sachModel m = new sachModel(masach, tensach, anhbia, sotrang, gia,soluong, ngaythem,mota, matg, matl, maxb);
			sachDAO d = new sachDAO();
			int kq = d.insert(m);

			if (kq == 1) {
				request.setAttribute("alert", "success");
			} else {
				request.setAttribute("alert", "fail");
			}
			
			
		} else if (request.getParameter("action").equalsIgnoreCase("update")) {
			
			
			if (request.getPart("anhbia").getSize() > 0) {
				String masach = request.getParameter("masach");
				String tensach = request.getParameter("tensach");

				Part img = request.getPart("anhbia");// get Part đường dẫn
				String anhbia = getNameImg.imgFileName(img, request); // truyển tham số là Part ròi lấy tên tên file Img

				int sotrang = Integer.parseInt(request.getParameter("sotrang"));
				float gia = Float.parseFloat(request.getParameter("gia"));
				int soluong = Integer.parseInt(request.getParameter("soluong"));
				Date ngaythem = dateUtil.dateCurrentSQL(); // lấy ngày hiện tại
				String mota = request.getParameter("mota");
				String matg = request.getParameter("matg");
				String matl = request.getParameter("matl");
				String maxb = request.getParameter("maxb");

				sachModel m = new sachModel(masach, tensach, anhbia, sotrang, gia,soluong, ngaythem,mota, matg, matl, maxb);
				sachDAO d = new sachDAO();
				int kq = d.updateImg(m);

				if (kq == 1) {
					request.setAttribute("alert", "success");
				} else {
					request.setAttribute("alert", "fail");
				}
			}else {
				String masach = request.getParameter("masach");
				String tensach = request.getParameter("tensach");

				/*
				 * Part img = request.getPart("anhbia");// get Part đường dẫn String anhbia =
				 * getNameImg.imgFileName(img, request); // truyển tham số là Part ròi lấy tên
				 * tên file Img
				 */
				int sotrang = Integer.parseInt(request.getParameter("sotrang"));
				float gia = Float.parseFloat(request.getParameter("gia"));
				int soluong = Integer.parseInt(request.getParameter("soluong"));
				Date ngaythem = dateUtil.dateCurrentSQL(); // lấy ngày hiện tại
				String mota = request.getParameter("mota");
				String matg = request.getParameter("matg");
				String matl = request.getParameter("matl");
				String maxb = request.getParameter("maxb");

				sachModel m = new sachModel(masach, tensach, sotrang, gia,soluong, ngaythem,mota, matg, matl, maxb);
				sachDAO d = new sachDAO();
				int kq = d.update(m);

				if (kq == 1) {
					request.setAttribute("alert", "success");
				} else {
					request.setAttribute("alert", "fail");
				}
			}
			
			
			
		} else {
			String masach = request.getParameter("masach");
			
			sachDAO d = new sachDAO();
			
			int kq = d.delete(masach);

			if (kq == 1) {
				request.setAttribute("alert", "success");
			} else {
				request.setAttribute("alert", "fail");
			}
		}

		request.getRequestDispatcher("/views/admin/sanphamAD.jsp").forward(request, response);

	}

}
