

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="temporalComment" method="post">
		<input type="text" value="${it.comment.users_UserIdFrom}" name="users_UserIdFrom" id = "userIdFrom" placeholder="1"/>
		<input type="text" value="${it.comment.users_UserIdTo}" name="users_UserIdTo" id = "userIdTo" placeholder="2"/>
		<input type="text" value="${it.comment.date}" name="date" id = "date" placeholder="10-9-17"/>
		<textarea id="txtComment" value="${it.comment.comment}" name="comment" style="width: 300px; height: 100px;">
			
		</textarea>
		<br>
		<input type="submit" value="Comment" id = "comment"/>
	</form>
</body>
</html>
