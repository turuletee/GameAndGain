<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

</head>
<body>
    <button>Create Badge</button>
    <form action="createBadge" method="post">
        <h2>Nombre</h2>
        <input type="text" name="badgeName" value="${it.badges.badgeName}">
        <h2>Valor</h2>
        <label for="range">
		      <input type="range" name="badgeValue" id="range" min="20" max="100" step="5"  value="${it.badges.badgeValue}"/>
		</label>
        <%-- <input type="range" name="badgeValue" value="${it.badges.badgeValue}" min="0" max="10" >  --%>
        <output for="range" class="output"></output>
        <input type="submit" name="submitBadge">
    </form>
    <form action="showBadges" method="post">
    	<input type="submit" name="createBadge" label="editar Insignias" onclick="showTable('table1')">
    </form>
    <form action="updateBadge" method="post">
    	<h2>ID</h2>
        <input type="text" name="update_badgeId" value="${it.badges.update_badgeId}">
        <h2>Nombre</h2>
        <input type="text" name="update_badgeName" value="${it.badges.update_badgeName}">
        <h2>Valor</h2>
        <label for="range">
		      <input type="range" name="update_badgeValue" id="range" min="20" max="100" step="5"  value="${it.badges.update_badgeValue}"/>
		</label>
        <%-- <input type="range" name="badgeValue" value="${it.badges.badgeValue}" min="0" max="10" >  --%>
        <output for="range" class="output"></output>
        <input type="submit" name="submit_updateBadge">
    </form>

    <button>Delete Badge</button>
    <form action="deleteBadge" method="post">
    	<h2>ID</h2>
        <input type="text" name="delete_badgeId" value="${it.badges.update_badgeId}">
        <input type="submit" name="delete_updateBadge">
    </form>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js" type="text/javascript"></script>
	
    <script type="text/javascript" src = "../../assets/js/badges.js"></script>
</body>

</html>
