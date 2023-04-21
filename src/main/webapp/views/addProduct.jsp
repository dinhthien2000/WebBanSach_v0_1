<%@page import="java.sql.ResultSet"%>
<%@page import="phdhtl.cntt.model.tacgiaModel"%>
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
</head>
<body>


	<%
	Connection connection = connectSQL.getConnectionSQLServer();
	PreparedStatement preparedStatement = null;
	ResultSet rs = null;
	%>

	<form action="" method="post" enctype="multipart/form-data" style="margin: auto;">
		<table>

			<tr>
				<td>Mã sách :</td>
				<td><input type="text" name="masach" placeholder="Mã sách">
				</td>
			</tr>

			<tr>
				<td>Tên sách :</td>
				<td><input type="text" name="tensach" placeholder="Tên sách" />
				</td>
			</tr>

			<tr>
				<td>Số trang :</td>
				<td><input type="number" name="sotrang" placeholder="Số trang" />
				</td>
			</tr>

			<tr>
				<td>Giá :</td>
				<td><input type="number" name="gia" placeholder="Giá" /></td>
			</tr>

			<tr>
				<td>Ngày thêm :</td>
				<td><input type="date" name="ngaythem" placeholder="Ngày thêm" />
				</td>
			</tr>

			<tr>
				<td>Mã tác giả :</td>
				<td><select name="matg" id="">
						<option>Chọn</option>
						<%
						String matg = "select * from Tacgia";
						preparedStatement = connection.prepareStatement(matg);

						rs = preparedStatement.executeQuery();

						while (rs.next()) {
						%>
						<option value="<%=rs.getString("Matg")%>"><%=rs.getString("Matg")%>
							-
							<%=rs.getString("Tentg")%></option>

						<%
						}
						%>
				</select></td>
			</tr>

			<tr>
				<td>Mã thể loại :</td>
				<td><select name="matl" id="">
						<option>Chọn</option>
						<%
						String matl = "select * from TheLoai";
						preparedStatement = connection.prepareStatement(matl);

						rs = preparedStatement.executeQuery();

						while (rs.next()) {
						%>

						<option value="<%=rs.getString("MATL")%>"><%=rs.getString("MATL")%>
							-
							<%=rs.getString("TENTL")%></option>
						<%
						}
						%>
				</select></td>
			</tr>

			<tr>
				<td>Mã xuất bản :</td>
				<td><select name="maxb" id="">
						<option>Chọn</option>
						<%
						String maxb = "select * from NhaXB";
						preparedStatement = connection.prepareStatement(maxb);

						rs = preparedStatement.executeQuery();

						while (rs.next()) {
						%>

						<option value="<%=rs.getString("MaXB")%>"><%=rs.getString("MaXB")%>
							-
							<%=rs.getString("TenXB")%></option>
						<%
						}
						%>

				</select></td>
			</tr>

			<tr>
				<td>Ảnh bìa :</td>
				<td><input type="file" name="anhbia" /></td>
			</tr>

			<tr>


				<td>
					<button type="submit" name="action" value="add">ADD</button>
					<button type="submit" name="action" value="update">Update</button>
					<button type="submit" name="action" value="delete">Delete</button>
					<button type="reset">Reset</button>
				</td>

			</tr>

		</table>
	</form>
	<p>${alert }</p>
</body>
</html>