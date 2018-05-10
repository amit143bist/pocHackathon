<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
<title></title>
<link href="/css/Site.css" rel="stylesheet" type="text/css">
<style type="text/css">
.style1 {
	width: 319px;
}

.auto-style1 {
	width: 108px;
}

#docusignFrame2 {
	height: 992px;
	width: 1365px;
}
</style>
<script type="text/javascript">
	function updateWindowSize() {
		var width = window.innerWidth || document.documentElement.clientWidth
				|| document.body.clientWidth;
		var height = window.innerHeight
				|| document.documentElement.clientHeight
				|| document.body.clientHeight;

		if (parseInt(width) <= 1024) {
			document.getElementById("MainContent_docusignFrame2").className = "";
			document.getElementById("MainContent_docusignFrame2").className = "iframe-1024";
		} else if (parseInt(width) > 1024 && parseInt(width) <= 1280) {
			document.getElementById("MainContent_docusignFrame2").className = "";
			document.getElementById("MainContent_docusignFrame2").className = "iframe-1280";
		} else {
			document.getElementById("MainContent_docusignFrame2").className = "";
			document.getElementById("MainContent_docusignFrame2").className = "iframe-bigger";
		}
	};
	window.onload = updateWindowSize;
	window.onresize = updateWindowSize;
</script>
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
	<form method="post"
		action="./MultipleEmbeddedEnvelopes.aspx?usermail=test%40tes.com&amp;password=fsdfsfs&amp;ctl00=login"
		id="ctl01">

		<div class="page">
			<div class="header" style="text-align: center; width: 100%;">
				<img id="ImageMap1" horizontalalign="Center"
					src="img/Foremost-logo.jpg" usemap="#ImageMapImageMap1">
				<map name="ImageMapImageMap1" id="ImageMapImageMap1">
					<area shape="rect" coords="0,0,150,80" href="default.aspx"
						title="Home" alt="Home">
				</map>
				<div class="clear hideSkiplink">
					<a href="#NavigationMenu_SkipLink"><img
						alt="Skip Navigation Links"
						src="/Foremost/WebResource.axd?d=Vd5orDUsHtd-5LdVGs9rb_y4PKY8ukC0bIdMykVRRtaTakJ9KYRx2bfTi98IZs6uxcpn0eaJ5OeHTtp9CCMe8YSWGGE2lwCLrtRJV3utchs1&amp;t=636451358501568382"
						width="0" height="0" style="border-width: 0px;"></a>
				</div>
			</div>
			<div class="main">

				<!--div style="width: auto; margin: 0 10%;"-->
				<div class="iframe-wrapper">
					<br> <span id="MainContent_CustomerDataLabel"
						class="customerDataPanel"
						style="font-size: X-Large; font-weight: bold; font-style: italic;">Multiple,
						Separate Documents Signing Experience</span>
					<table>
						<tbody>
							<tr>
								<td>
									<table style="width: 90%;">
										<tbody>
											<tr>
												<td colspan="2">&nbsp;</td>
											</tr>
											<tr>
												<td>
													<div id="MainContent_Signer1" style="text-align: center;">

														<table id="MainContent_Table1" style="width: 500px;">
															<tbody>
																<tr>
																	<th colspan="2"><span
																		id="MainContent_FieldSection1"
																		style="font-size: Large; font-weight: bold;">Named
																			Insured</span></th>
																</tr>
																<tr>
																	<td><span id="MainContent_Label1"
																		style="font-weight: bold;">Name</span></td>
																	<td><input name="ctl00$MainContent$Name"
																		type="text" value="test@tes.com" id="MainContent_Name"></td>
																</tr>
																<tr>
																	<td><span id="MainContent_Label7"
																		style="font-weight: bold;">Email Address</span></td>
																	<td><input name="ctl00$MainContent$EmailAddress"
																		type="text" value="test@tes.com"
																		id="MainContent_EmailAddress"></td>
																</tr>
																<tr>
																	<td>&nbsp;</td>
																</tr>
																<tr>
																	<td align="center" colspan="1"><input
																		type="submit" name="ctl00$MainContent$SignDocument1"
																		value="Sign Document1" id="MainContent_SignDocument1"></td>
																	<td align="center" colspan="1"><input
																		type="submit" name="ctl00$MainContent$SignDocument2"
																		value="Sign Document 2" id="MainContent_SignDocument2"></td>
																	<td align="center" colspan="1"><input
																		type="submit" name="ctl00$MainContent$SignDocument3"
																		value="Sign Document 3" id="MainContent_SignDocument3"></td>
																</tr>
																<tr>
																	<td align="center" colspan="4"></td>
																</tr>
															</tbody>
														</table>

													</div>
												</td>
											</tr>
										</tbody>
									</table>
								</td>
								<td></td>
							</tr>
						</tbody>
					</table>
					<!--!--div-->
				</div>
				<div class="clear"></div>
			</div>
			<div class="footer"></div>

			<script type="text/javascript">
				new Sys.WebForms.Menu({
					element : 'NavigationMenu',
					disappearAfter : 500,
					orientation : 'horizontal',
					tabIndex : 0,
					disabled : false
				});
			</script>


		</div>
	</form>
</body>
</html>