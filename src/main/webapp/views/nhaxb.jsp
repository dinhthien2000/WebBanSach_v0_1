<%@page import="java.sql.ResultSet"%>
<%@page import="phdhtl.cntt.util.connectSQL"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>


<%@page import="phdhtl.cntt.servlet.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="nhaxbServlet" method="post">
	
		<input type="text" name="maxb" placeholder="Mã nhà xuất bản" />
		<input type="text" name="tenxb" placeholder="Tên nhà xuất bản" />
		<input type="text" name="diachi" placeholder="Địa chỉ" />
		<input type="number" name="sdt" placeholder="Số điện thoại" maxlength="10" />
		<input type="email" name="email" placeholder="Email" />
		
		<button type="submit" name="action" value="add">ADD</button>
		<button type="submit" name="action" value="update">Update</button>
		<button type="submit" name="action" value="delete">Delete</button>
	
	</form>
	<p>${alert }</p>
	
	<hr />
	
	<table>
		<tr>
			<td></td>
			<td>Mã nhà xuất bản</td>
			<td>Tên nhà xuất bản</td>
			<td>Địa chỉ</td>
			<td>Số điện thoại</td>
			<td>Email</td>
			
		
		</tr>
		<%
			
			String sql = "select*from NhaXB";
			Connection connection = connectSQL.getConnectionSQLServer();
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()){
		
		%>
		<tr>
			<td></td>
			<td><%=rs.getNString(1) %></td>
			<td><%=rs.getNString(2) %></td>
			<td><%=rs.getNString(3) %></td>
			<td><%=rs.getNString(4) %></td>
			<td><%=rs.getNString(5) %></td>
		</tr>
		<%} %>
	
	</table>
</body>
</html>