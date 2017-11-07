<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
   <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Administrar Insignia</title>

<link href="../../assets/css/badges.css" rel="stylesheet" />



</head>
<body>
<div class="navbar">

		<div class="access_menu">

			<a class="access_menu-link" href="webapi/adminResource/signup">Signup</a>

			<a class="access_menu-link" href="webapi/adminResource/login">Login</a>

			<a class="access_menu-link" href="webapi/adminResource/temporalComment">Comentario</a>

			<a class="access_menu-link" href="webapi/adminResource/badges">Administrar Insignias</a>

		</div>

		<div class="logo_header">

			<section class="logo_title"></section>

		</div>

		<div class="navbar-header">

			<button type="button" class="navbar-toggle" data-toggle="collapse"

				data-target=".navbar-responsive-collapse">

				<span class="icon-bar"></span> <span class="icon-bar"></span> <span

					class="icon-bar"></span>

			</button>

		</div>

		

		<div class="menu_bar">

			<a class="menu_bar-link" href="#">INICIO</a>

			<a class="menu_bar-link" href="#">MI PERFIL</a>

			<a class="menu_bar-link" href="#">JUGAR</a>

			<a class="menu_bar-link" href="#">RANKINGS</a>

			<input class="menu_bar-link search" type="text" name="searchIn" placeholder="Buscar">

		</div>
	<div class="buttons-div">
	    <button class="buttons" onclick="showCreateForm()" >Create Badge</button>
	    <form action="createBadge" method="post" class="badges-form" id="creatBadge-form">
	        <h2 class="form-inputs">Nombre</h2>
	        <input type="text" name="badgeName" value="${it.badges.badgeName}">
	        <h2 class="form-inputs">Valor</h2>
	        <label for="range">
			      <input type="range" name="badgeValue" id="range" min="20" max="100" step="5"  value="${it.badges.badgeValue}"/>
			</label>
	        <%-- <input type="range" name="badgeValue" value="${it.badges.badgeValue}" min="0" max="10" >  --%>
	        <output for="range" class="output"></output>
	        <input type="submit" name="submitBadge" value="Enviar" class="buttons">
	    </form>
	    
	   
	    	<spring:url value="#" var="badgeListUrl" htmlEscape="true" />
       		 <a href="${badgeListUrl}" name="viewBadges"  class="buttons"  >Ver Insignias</a>
	    	
	            <table class="badges-table" id="badgesTable">
	             <tr>
	                <th class="badges-table-header">Nombre</th>
	                
	                <th class="badges-table-header">Valor</th>  
	                 
	             </tr>
	             <c:forEach var="i" items="${badge}" varStatus="loopCounter">
	             <tr>
	         
	            	 <td><c:out value="${loopCounter.count}" />hry</td>
	            	 <td><c:out value="${i.badgeName}" />hey</td>
	            	 <td><c:out value="${i.badgeValue}" /></td>
					
	             </tr>
	             </c:forEach>           
	            </table>
	           
	   

   

	    
	
	    <button class="buttons">Delete Badge</button>
	  </div>
	
	
	<footer class="footer">
		<img src="../../assets/img/gg.png" class="footer-img">
		<p class="footer-paragraph">2017 © puto el que copia</p>
		<div class="footer-div">
				<table class="footer_table-about">
					<th class="footer-table-about-header">About</th>
					<tr class="footer-table-row">
						<td class="footer-table-col">
							<a href="" class="footers-titles-links">FAQ</a>
						</td>
					</tr>
					<tr class="footer-table-row">
						<td class="footer-table-col">
							<a href="" class="footers-titles-links">Contact</a>
						</td>
					</tr>
					<tr class="footer-table-row">
						<td class="footer-table-col">
							<a href="" class="footers-titles-links">Tutorial</a>
						</td>
					</tr>
				</table>
				<table class="footer_table-social">
					<th class="footer-table-social-header">Follow Us</th>
					<tr class="footer-table-row">
						<td class="footer-table-col">
							<a href="" class="social-links">
								<img src="../../assets/img/face.png">
							</a>
							<a href="" class="social-links">
								<img src="../../assets/img/twitter.png">
							</a>
							<a href="" class="social-links">
								<img src="../../assets/img/gmail.png">
							</a>
							<a href="" class="social-links">
								<img src="../../assets/img/email.png">
							</a>
						</td>
					</tr>
				</table>
		 </div>
		 </footer>
    
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js" type="text/javascript"></script>
	
    <script type="text/javascript" src = "../../assets/js/badges.js"></script>
</body>

</html>
