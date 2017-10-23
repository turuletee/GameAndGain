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
<title>User Enrollment Signup</title>
<link href="../../bootstrap/css/bootstrap.css" rel="stylesheet" />
<link href="../../datepicker/css/datepicker.css" rel="stylesheet" />
<link href="../../assets/css/bootstrap-united.css" rel="stylesheet" />
<link href="../../assets/css/signup.css" rel="stylesheet" />

<style>
.green {
	font-weight: bold;
	color: green;
}

.message {
	margin-bottom: 10px;
}

.error {
	color: #ff0000;
	font-size: 0.9em;
	font-weight: bold;
}

.errorblock {
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}
</style>
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

	<script src="../../datepicker/js/bootstrap-datepicker.js">
		
	</script>


	<div class="container">
		

		<div></div>
	</div>

	<c:if test="${not empty it.message}">
		<div class="green">${it.message}</div>
	</c:if>

	
	<section class="signup_section">
		<table class="signup_section-table">
				<th class="signup_section-table-header">Registrate</th>
		</table>

		<form:form id="myForm" class="signup_section-form" method="post" action="signup">
			<label for="firstNameInput" class="signup_section-form-labels">Nombre</label>
			<input type="text" class="signup_section-form-inputs" name="firstName" id="firstNameInput" placeholder="Tomas" value="${it.user.firstName}" />
			
			<label for="lastNameInput" class="signup_section-form-labels">Apellido</label>
			<input type="text" class="signup_section-form-inputs" name="lastName" id="lastNameInput" placeholder="Vuka" value="${it.user.lastName}" />
			
			<label for="emailAddressInput" class="signup_section-form-labels">Email</label>
			<input type="text" class="signup_section-form-inputs" name="emailAddress" id="emailAddressInput" placeholder="tomas.vuka23@me.com" value="${it.user.emailAddress}" />
			
			<label for="passwordInput" class="signup_section-form-labels">Password</label>
			<input type="password" class="signup_section-form-inputs" name="password" id="passwordInput"  value="${it.user.password}" />					
			
			<label for="birthdateInput" class="signup_section-form-labels">Fecha de Nacimiento</label>
			<div class="date form_date"
			data-date-format="mm/dd/yyyy" data-date-viewmode="years">
					<c:set var="myDate">
						<fmt:formatDate pattern="MM/dd/yyyy" value="${it.user.birthdate}" />
					</c:set>
					<input type="text" class="signup_section-form-inputs" name="birthdate" id="birthdateInput" placeholder="09/11/2001" value="${myDate}" />
			</div>
								
			<label for="phoneInput" class="signup_section-form-labels">Telefono</label>
			<input type="text" class="signup_section-form-inputs" name="phone" id="phoneInput" placeholder="156660911" value="${it.user.phone}" />
									
			<label for="countryInput" class="signup_section-form-labels">Pais</label>
			<input type="text" class="signup_section-form-inputs" name="country" id="countryInput" placeholder="Argentina" value="${it.user.country}" />
									
			<label for="interestInput" class="signup_section-form-labels">Interes</label>
			<select class="signup_section-form-option" name="interest" id="interestInput" value="${it.user.interest}" >
				  <option disabled selected>Selecciona un Interes</option>
				  <option value="1">Educativo</option>
				  <option value="2">Cultural</option>
				  <option value="3">Ambiental</option>
				</select >
												
			<label for="roleInput" class="signup_section-form-labels">Rol</label>
			<select class="signup_section-form-option" name="role" id="roleInput" value="${it.user.role}">
				  <option disabled selected>Selecciona un Rol</option>
				  <option value="1" >Jugador</option>
				  <option value="2">Donante</option>
				  <option value="3">Beneficiario</option>
				  <option value="4" >Gestor de Campañas</option>
				</select>
									
			<div class="signup_section-form-btns">
				<button class="btn btn-default">Cancel</button>
				<button class="btn btn-primary" data-toggle="modal" data-target="#themodal">Submit</button>
				<div id="themodal" class="modal fade" data-backdrop="static">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
								<h3>Signup Form Submission</h3>
							</div>
							<div class="modal-body">
								<p>Are you sure you want to do this?</p>
								<div class="progress progress-striped active">
									<div id="doitprogress" class="progress-bar"></div>
								</div>
							</div>
							<div class="modal-footer">
								<a href="#" class="btn btn-default" data-dismiss="modal">Close</a>
								<input type="submit" value="Yes" id="yesbutton" class="btn btn-primary" data-loading-text="Saving.." data-complete-text="Submit Complete!">
							</div>
						</div>
					</div>
				</div>
			</div>
		</form:form>
	</section>
	
	
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

	<script>
		$(function() {
			$('#dateOfBirthInput').datepicker();
		});
	</script>

	<script type="text/javascript">
		$(function() {
			var yesButton = $("#yesbutton");
			var progress = $("#doitprogress");

			yesButton.click(function() {
				yesButton.button("loading");

				var counter = 0;
				var countDown = function() {
					counter++;
					if (counter == 11) {
						yesButton.button("complete");
					} else {
						progress.width(counter * 10 + "%");
						setTimeout(countDown, 100);
					}
				};

				setTimeout(countDown, 100);
			});

		});
	</script>


</body>
</html>