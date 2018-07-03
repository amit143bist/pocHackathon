<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Login Screen</title>
	<link rel="stylesheet" href="/css/site.css">
	<link rel="stylesheet" href="/css/normalize.css">
	<link rel="stylesheet" href="/css/style.css">
	<link rel="stylesheet" type="text/css" href="/css/demo.css" />
	<link rel="stylesheet" type="text/css" href="/css/styledemo.css" />
	<link rel="stylesheet" type="text/css" href="/css/animate-custom.css" />
</head>
<body>
	<div class="container">
		<header>
		<div>
			<img id="Image1" src="img/Foremost-logo.jpg">
		</div>
		</header>
		<section>
		<div id="container_demo">
			<a class="hiddenanchor"
				id="tologin"></a>
			<div id="wrapper">
				<div id="login" class="animate form">
					<form:form method="POST" autocomplete="on" id="customerLoginForm"
						name="customerLoginForm" action="customerLoginIframe">
						<h1>Customer Login</h1>
						<p>
							<label for="username" class="uname" data-icon="u"> Your
								email </label> <input id="username" name="username"
								required="required" type="text"
								placeholder="mymail@mail.com" />
						</p>
						<p>
							<label for="password" class="youpasswd" data-icon="p">
								Your password </label> <input id="password" name="password"
								required="required" type="password" placeholder="eg. X8df!90EO" />
						</p>
						<p class="login button">
							<input type="submit" value="Login" id="loginBtn" name="loginBtn" />
						</p>
					</form:form>
				</div>

			</div>
		</div>
		</section>
	</div>

</body>
</html>