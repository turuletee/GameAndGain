<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="getProjectState" method="post">
		<label>Nombre de la obra:  </label>
		<input type="text" value="${it.projectStates.nameProject}" name="nameProject" id = "nameProjectId" placeholder="Una obra"/>
		<br>
		<input type="submit" value="Traer" id = "nameProjectT"/>
	</form>
</body>
</html>