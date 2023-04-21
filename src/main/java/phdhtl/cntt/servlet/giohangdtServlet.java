package phdhtl.cntt.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import phdhtl.cntt.dao.giohangdtDAO;
import phdhtl.cntt.dao.userDAO;
import phdhtl.cntt.model.giohangdtModel;
import phdhtl.cntt.util.gioHang_donHang;

/**
 * Servlet implementation class giohangdtServlet
 */
@WebServlet(urlPatterns = { "/giohangdtServlet", "/soluongServlet", "/deleteGH" })
public class giohangdtServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String servletPath = request.getServletPath();
		HttpSession session = request.getSession();
		String user = (String) session.getAttribute("user");
		if(user!=null) {
			// thêm sản phẩm
			if (servletPath.equals("/giohangdtServlet")) {
				String masach = request.getParameter("id");
				// String tensach = request.getParameter("ten");
				float gia = Float.parseFloat(request.getParameter("gia"));
				int kq = 0;

				// sachModel modelS = new sachModel();
				giohangdtModel modelGH = new giohangdtModel();
				giohangdtDAO dao = new giohangdtDAO();

				//HttpSession session = request.getSession();
				 
				String taikhoan = (String) session.getAttribute("user");
				String makh = userDAO.getMakh(taikhoan);
				System.out.println(makh);
				// thêm thông tin sách user mua vào model
				modelGH.setMasach(masach);
				modelGH.setGia(gia);
				modelGH.setMakh(makh);
				System.out.println(makh);

				int isExits = gioHang_donHang.checkExitsSach(masach,makh); // lấy mã giỏ hàng, kiểm tra hàng đã tồn tại chưa
				if (isExits >0 ) {
					kq = gioHang_donHang.upToSoluong(isExits);
					if (kq == 1) {
						request.setAttribute("alert", "update success");
						request.getRequestDispatcher("/views/giohang.jsp").forward(request, response);
					} else {
						request.setAttribute("alert", "update fail");
						request.getRequestDispatcher("/views/index.jsp").forward(request, response);
					}

				} else {
					// modelS=dao.getSachGH(masach);
					// System.out.println(""+modelS.getGia());

					kq = dao.insert(modelGH);

					if (kq == 1) {
						request.setAttribute("alert", "add success");
						request.getRequestDispatcher("/views/giohang.jsp").forward(request, response);
					} else {
						request.setAttribute("alert", "add fail");
						request.getRequestDispatcher("/views/index.jsp").forward(request, response);
					}
				}

			}
			// xóa sản phẩm trong giỏ hàng
			else if (servletPath.equals("/deleteGH")) {
				String ma = request.getParameter("id");
				giohangdtDAO.delete(ma);
				request.getRequestDispatcher("/views/giohang.jsp").forward(request, response);
			}
			// cập nhật số lượng
			else {
				String ma = request.getParameter("id");
				int soluong = Integer.parseInt(request.getParameter("soluong"));
				String updateSL = request.getParameter("updateSL"); // 0: giảm 1 , 1: thêm 1

				// tăng số lượng
				if (updateSL.equalsIgnoreCase("1")) {
					try {
						soluong++;
						int kq = gioHang_donHang.updateSoLuong(ma, soluong);
						if (kq == 1) {
							request.setAttribute("alert", "success");
						} else {
							request.setAttribute("alert", "fail");
						}
					} catch (SQLException e) {

						e.printStackTrace();
					}
					request.getRequestDispatcher("/views/giohang.jsp").forward(request, response);
				}
				// giảm số lượng
				else {
					try {
						soluong--;
						int kq = gioHang_donHang.updateSoLuong(ma, soluong);
						if (kq == 1) {
							request.setAttribute("alert", "success");
						} else {
							request.setAttribute("alert", "fail");
						}
					} catch (SQLException e) {

						e.printStackTrace();
					}
					request.getRequestDispatcher("/views/giohang.jsp").forward(request, response);
				}
			}
		}else {
			request.getRequestDispatcher("/views/dangnhap.jsp").forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
