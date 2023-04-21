<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="theloaiServlet" method="post">
	
	<input type="text" name="matl" placeholder="Mã thể loại" />
	<input type="text" name="tentl" placeholder="Tên thể loại" />
	<button type="submit" name="action" value="add">ADD</button>
	<button type="submit" name="action" value="update">Update</button>
	<button type="submit" name="action" value="delete">Delete</button>
	
	</form>
	<p>${alert }</p>
</body>
</html>