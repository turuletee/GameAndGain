<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="../../assets/css/bootstrap-united.css" rel="stylesheet" />
<link href="../../assets/css/profile.css" rel="stylesheet" />

<title>Mi Perfil</title>
</head>
<body>

	<div class="navbar">
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
			<a href="#" class="menu_bar-link">INICIO</a>
			<a href="#" class="menu_bar-link">MI PERFIL</a>
			<a href="#" class="menu_bar-link">JUGAR</a>
			<a href="#" class="menu_bar-link">RANKINGS</a>
			<input class="menu_bar-link search" type="text" name="searchIn" placeholder="Buscar">

		</div>

		<!-- /.nav-collapse -->
	</div>
	<script src="../../jquery-1.8.3.js">
		
	</script>

	<script src="../../bootstrap/js/bootstrap.js">
		
	</script>

	<div class="div_profile">
	
		<table class="div_profile-table">
					<th class="div_profile-table-header">Mi Perfil</th>
			</table>
			<div class="profile-pic"></div>
			<form:form id="myForm" class="div_profile-form" method="post" action="login">
				<label for="emailAddressInput" class="div_profile-form-labels">Email</label>
				<input type="text" class="div_profile-form-inputs" name="emailAddress" id="emailAddressInput" placeholder="tomas.vuka23@me.com" value="${it.user.emailAddress}" />
				
				<label for="passwordInput" class="div_profile-form-labels">Password</label>
				<input type="password" class="div_profile-form-inputs" name="password" id="passwordInput"  value="${it.user.password}" />					
				
			
										
				<div class="div_profile-form-btns">
										<button class="btn btn-default">Cancel</button>
	
										<button class="btn btn-primary">Login</button>
									</div>
			</form:form>
	
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

</body>
</html>