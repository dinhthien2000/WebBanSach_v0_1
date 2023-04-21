package phdhtl.cntt.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import phdhtl.cntt.dao.userDAO;
import phdhtl.cntt.model.userModel;
import phdhtl.cntt.util.connectSQL;
import phdhtl.cntt.util.idString;

/**
 * Servlet implementation class userServlet
 */
@WebServlet(urlPatterns = { "/userServlet", "/dangxuatServlet" })
public class userServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/views/dangky.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		userModel model = new userModel();
		userDAO dao = new userDAO();

		// lớp BeanUtils gọi phương thức có hai tham số : obj student và Collect Map để
		// lưu vào dữ liệu vào mảng trước và chuyển đổi kiểu dữ liệu (datatype ) để lưu
		// vào các trường dữ liệu của obj student
		if (request.getParameter("action").equalsIgnoreCase("dangky")) {
			try {
				BeanUtils.populate(model, request.getParameterMap());
				String string = idString._createID(model.getTaikhoan());
				model.setMakh(string);

				int kq = dao.insert(model);
				if (kq == 1) {
					// khác null là đăng nhập thành công
					HttpSession session = request.getSession(false);
					if (session == null) {
						// Not created yet. Now do so yourself.
						session = request.getSession();
						session.setAttribute("user", model.getTaikhoan());
						session.setAttribute("pass", model.getMatkhau());

					} else {
						// Already created. // đổi tài khoản khác nên xóa cái cũ
						session = request.getSession();
						session.removeAttribute("user");
						session.removeAttribute("pass");
						session.setAttribute("user", model.getTaikhoan());
						session.setAttribute("pass", model.getMatkhau());
					}
					request.setAttribute("alert", "success");
					request.getRequestDispatcher("/views/index.jsp").forward(request, response);
				} else {
					request.setAttribute("alert", "fail");
					System.out.println(model.getMakh());
					System.out.println(model.getTaikhoan());
					System.out.println(model.getMatkhau());
					System.out.println(model.getDiachi());
					System.out.println(model.getSdt());
					System.out.println(model.getEmail());
				}

			} catch (Exception e) {

				e.printStackTrace();
			}

			request.getRequestDispatcher("/views/dangky.jsp").forward(request, response);
		} else if (request.getParameter("action").equalsIgnoreCase("dangnhap")) {
			switch (request.getParameter("check")) {
			case "admin":
				String tk = request.getParameter("taikhoan");
				String mk = request.getParameter("matkhau");
				// check tk ad
				String sql ="select * from Admin where Taikhoan=? and Matkhau=? ";
				Connection connection = connectSQL.getConnection();
				try {
					PreparedStatement preparedStatement = connection.prepareStatement(sql);
					preparedStatement.setString(1, tk);
					preparedStatement.setString(2, mk);
					ResultSet rs = preparedStatement.executeQuery();
					if (rs.next()) {
						HttpSession session = request.getSession(false);
						if (session == null) {
							// Not created yet. Now do so yourself.
							session = request.getSession();
							session.setAttribute("userAD", tk);
							session.setAttribute("passAD",mk);

						} else {
							// Already created. // đổi tài khoản khác nên xóa cái cũ
							session = request.getSession();
							session.removeAttribute("userAD");
							session.removeAttribute("passAD");
							session.setAttribute("userAD", tk);
							session.setAttribute("passAD",mk);
						}
						request.getRequestDispatcher("/views/admin/indexAD.jsp").forward(request, response);
					}else {
						request.setAttribute("alert", "fail");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
				
				break;
			case "user": // đăng nhập trạng thái user
				try {
					BeanUtils.populate(model, request.getParameterMap()); // sài thư viện bean util
					if (dao.checkDangNhap(model) != null) {

						System.out.println(model.getTaikhoan());
						System.out.println(model.getMatkhau());
						// khác null là đăng nhập thành công
						HttpSession session = request.getSession(false);
						if (session == null) {
							// Not created yet. Now do so yourself.
							session = request.getSession();
							session.setAttribute("user", model.getTaikhoan());
							session.setAttribute("pass", model.getMatkhau());

						} else {
							// Already created. // đổi tài khoản khác nên xóa cái cũ
							session = request.getSession();
							session.removeAttribute("user");
							session.removeAttribute("pass");
							session.setAttribute("user", model.getTaikhoan());
							session.setAttribute("pass", model.getMatkhau());
						}
						request.getRequestDispatcher("/views/index.jsp").forward(request, response);
					} else {
						request.setAttribute("alert", "Fail");
						request.getRequestDispatcher("/views/dangnhap.jsp").forward(request, response);
					}

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			default:
				break;
			}
			
		} else { // đăng xuất admin and user
			HttpSession session = request.getSession(false);
			if (session != null) {
				session.removeAttribute("user");
				session.removeAttribute("pass");
				session.removeAttribute("admin");
				session.removeAttribute("passAD");
				request.getRequestDispatcher("/views/index.jsp").forward(request, response);
			}
		}

	}

}
