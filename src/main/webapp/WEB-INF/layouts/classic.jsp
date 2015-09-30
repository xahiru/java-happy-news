<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.0/jquery.min.js"></script>

<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:getAsString name="title" /></title>
</head>
<body>
	<tiles-x:useAttribute name="current" />
	<div class="container">
		<!-- Static navbar -->
		<nav class="navbar navbar-default">
			<div class="container-fluid">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#navbar" aria-expanded="false"
						aria-controls="navbar">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="#">Happy News</a>
				</div>
				<div id="navbar" class="navbar-collapse collapse">
					<ul class="nav navbar-nav">
						<li class="${current == 'index'? 'active':'' }"><a
							href='<spring:url value="/happynews/index"/>'>Home</a></li>

						<li><a href="/">About</a></li>
						<security:authorize access="hasRole('ROLE_ADMIN')">
						<li class="${current == 'users'? 'active':'' }"><a
							href="<spring:url value="/happynews/users.html"/>">Users</a></li>
						
						</security:authorize>
												<li class="${current == 'register'? 'active':'' }"><a
							href="<spring:url value="/happynews/register.html"/>">Register</a></li>
						<security:authorize access="! isAuthenticated()">
							<li class="${current == 'login'? 'active':'' }"><a
								href="<spring:url value="/happynews/login.html"/>">Login</a></li>
						</security:authorize>
						<security:authorize access="isAuthenticated()">
							<li class="${current == 'users'? 'active':'' }"><a
							href="<spring:url value="/happynews/account.html"/>">My Account</a></li>
				
							<li><a href="<spring:url value="/logout"/>">Logout</a></li>
						</security:authorize>

					</ul>
					<ul class="nav navbar-nav navbar-right">
						<li class="active"><a href="./">Default <span
								class="sr-only">(current)</span></a></li>
						<li><a href="../navbar-static-top/">Static top</a></li>
						<li><a href="../navbar-fixed-top/">Fixed top</a></li>
					</ul>
				</div>
				<!--/.nav-collapse -->
			</div>
			<!--/.container-fluid -->
		</nav>
		<tiles:insertAttribute name="body" />
		<br> <br>

		<tiles:insertAttribute name="footer" />


	</div>
</body>
</html>