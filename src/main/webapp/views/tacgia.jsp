<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tác giả</title>
</head>
<body>
	<form action="tacgiaServlet" method="post">
	
	<input type="text" name="matg" placeholder="Mã tác giả" />
	<input type="text" name="tentg" placeholder="Tên tác giả" />
	<input type="text" name="quoctich" placeholder="Quốc tịch" />
	
	<button type="submit" name="action" value="add">ADD</button>
	<button type="submit" name="action" value="update">Update</button>
	<button type="submit" name="action" value="delete">Delete</button>
	
	</form>
	<p>${alert }</p>
</body>
</html>