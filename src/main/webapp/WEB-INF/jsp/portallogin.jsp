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
<style type="text/css">
a#link-to-fond:hover {
	background-color: #fff;
	color: #4e80ff !important
}

a#link-to-fond:visited {
	color: #fff
}

#close-fond-bar:hover {
	cursor: pointer
}

#fond-bar {
	display: block;
	height: 50px;
	max-height: 60px;
	min-height: 10px;
	background-color: #147bd1;
	padding: 5px 5px 5px 10px;
	position: fixed;
	left: 0;
	top: 42px;
	margin-top: -60px;
	width: 100%;
	z-index: 999999;
	text-align: center;
	-webkit-box-sizing: initial;
	box-sizing: initial
}

#fond-bar-container {
	display: inline-block;
	width: 98%;
	margin: 0;
	position: relative;
	line-height: 32px;
	max-height: 32px
}

#fond-text {
	position: relative;
	color: #fff !important;
	font-size: 16px !important;
	text-align: centecenter !important;
	margin: 0 !important;
	float: left !important;
	text-shadow: none !important;
	padding: 4px !important;
	line-height: 60px;
	vertical-align: middle;
	width: 100%
}

#fond-text, #link-to-fond {
	font-family: walsheim, Arial !important
}

#link-to-fond {
	color: #fff;
	font-size: 14px !important;
	font-weight: 400 !important;
	border: 1px solid #fff;
	padding: 6px 20px;
	border-radius: 2px;
	text-decoration: none !important;
	margin-left: 12px
}

#fond-small {
	width: 24px;
	height: 24px;
	margin-right: 8px;
	margin-top: -2px;
	vertical-align: middle;
	display: inline !important
}

#close-fond-bar {
	position: absolute;
	top: 26px;
	right: 5px;
	width: 14px;
	z-index: 999999;
	font-family: Arial;
	font-size: 12px
}
</style>
<style type="text/css">
.c1-ui-state-hover {
	background-color: yellow !important;
	padding: 5px !important
}
</style>
</head>
<body>
	<!-- <div class="header">
			<img id="Image1" src="images/Foremost-logo.jpg">
		</div> -->

	<div class="container">
		<header>
		<div>
			<img id="Image1" src="img/Foremost-logo.jpg">
		</div>
		</header>
		<section>
		<div id="container_demo">
			<a class="hiddenanchor" id="toregister"></a> <a class="hiddenanchor"
				id="tologin"></a>
			<div id="wrapper">
				<div id="login" class="animate form">
					<form:form method="POST" autocomplete="on" id="customerLoginForm"
						name="customerLoginForm" action="customerLogin">
						<h1>Customer Login</h1>
						<p>
							<label for="username" class="uname" data-icon="u"> Your
								email or username </label> <input id="username" name="username"
								required="required" type="text"
								placeholder="myusername or mymail@mail.com" />
						</p>
						<p>
							<label for="password" class="youpasswd" data-icon="p">
								Your password </label> <input id="password" name="password"
								required="required" type="password" placeholder="eg. X8df!90EO" />
						</p>
						<p class="login button">
							<input type="submit" value="Login" id="loginBtn" name="loginBtn" />
						</p>
						<p class="change_link">
							Agent Login ? <a href="#toregister" class="to_register">Agent
								Login</a>
						</p>
					</form:form>
				</div>

				<div id="register" class="animate form">
					<form:form method="POST" autocomplete="on" id="agentLoginForm"
						name="agentLoginForm" action="agentLogin">
						<h1>Agent Login</h1>
						<p>
							<label for="agentusername" class="uname" data-icon="u">
								Your email or username </label> <input id="agentusername"
								name="agentusername" required="required" type="text"
								placeholder="myusername or mymail@mail.com" />
						</p>
						<p>
							<label for="agentpassword" class="youpasswd" data-icon="p">
								Your password </label> <input id="agentpassword" name="agentpassword"
								required="required" type="password" placeholder="eg. X8df!90EO" />
						</p>
						<p class="login button">
							<input type="submit" value="Login" id="agentloginBtn"
								name="agentloginBtn" />
						</p>
						<p class="change_link">
							Customer Login ? <a href="#tologin" class="to_register">Customer
								Login</a>
						</p>
					</form:form>
				</div>

			</div>
		</div>
		</section>
	</div>

</body>
</html>