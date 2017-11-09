<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="getRanking" method="post">
		<label>Nombre del usuario:  </label>
		<input type="text" value="${it.campaignsHasUsers.name}" name="name" id = "userId" placeholder="Pepe"/>
		<br>
		<input type="submit" value="Traer" id = "nameT"/>
	</form>
</body>
</html>