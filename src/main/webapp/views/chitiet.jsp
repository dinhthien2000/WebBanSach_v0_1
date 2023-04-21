<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="phdhtl.cntt.util.connectSQL"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">Navbar</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page"
						href="${pageContext.request.contextPath}/views/index.jsp">Trang
							chủ</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Link</a></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
						role="button" data-bs-toggle="dropdown" aria-expanded="false">
							Dropdown </a>
						<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
							<li><a class="dropdown-item" href="#">Action</a></li>
							<li><a class="dropdown-item" href="#">Another action</a></li>
							<li>
								<hr class="dropdown-divider">
							</li>
							<li><a class="dropdown-item" href="#">Something else
									here</a></li>
						</ul></li>
					<li class="nav-item"><a class="nav-link disabled">Disabled</a>
					</li>
				</ul>
				<form class="d-flex">
					<input class="form-control me-2" type="search" placeholder="Search"
						aria-label="Search">
					<button class="btn btn-outline-success" type="submit">Search</button>
				</form>
			</div>
		</div>
	</nav>

	<div class="container">
		<%
		Connection connection = connectSQL.getConnectionSQLServer();
		String id = request.getParameter("id");
		/* String sql="select s.TenSach , s.Anhbia , s.Gia, s.SoTrang, tl.TENTL , tg.Tentg, xb.TenXB from Sach s , TheLoai tl , Tacgia tg , NhaXB xb" 
				+"where s.MaSach=? and s.MATL = tl.MATL and s.Matg =tg.Matg and s.MaXB = xb.MaXB;";  */
		String sql = "select s.MaSach, s.TenSach , s.Anhbia , s.Gia, s.SoTrang, tl.TENTL , tg.Tentg, xb.TenXB\r\n"
				+ "from Sach s\r\n" + "left join TheLoai tl on s.MATL=tl.MATL \r\n"
				+ "left join Tacgia tg on s.Matg = tg.Matg\r\n" + "left join NhaXB xb on s.MaXB = xb.MaXB\r\n"
				+ "where s.MaSach= ? ;";
		//String sql ="select * from Sach where MaSach=?;";		
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, id);
		ResultSet rs = preparedStatement.executeQuery();

		while (rs.next()) {
		%>
		<div class="row" style="margin-top: 20px;">
			<div class="col" style="border: 0.5px solid; margin: 0 10px;">
				<img
					src="${pageContext.request.contextPath}/views/img/<%=rs.getString("Anhbia") %>"
					alt="" style="height: 400px; width: 100%; padding: 5% 30%" />

			</div>
			<div class="col" style="margin: 0 10px; border: 1px solid">
				<div style="margin: 10px 10%;">
					<p><%=rs.getNString("MaSach")%></p>
					<p><%=rs.getNString("TenSach")%></p>
					<p><%=rs.getInt("SoTrang")%></p>
					<p><%=rs.getFloat("Gia")%></p>
					<p><%=rs.getNString("TENTL")%></p>
					<p><%=rs.getNString("Tentg")%></p>
					<p><%=rs.getNString("TenXB")%></p>
				</div>


			</div>

		</div>
		<%
		}
		%>
	</div>

	<!-- Option 1: Bootstrap Bundle with Popper -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
</body>
</html>