<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
<title></title>
<link rel="stylesheet" href="/css/site.css">
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
		action="createWorkspaceRemoteEnvelope"
		id="ctl01">

		<div class="page">
			<div class="header" style="text-align: center; width: 100%;">
				<img id="Image1" src="img/Foremost-logo.jpg">
			</div>
			<div class="main">

				<!--div style="width: auto; margin: 0 10%;"-->
				<div class="iframe-wrapper">
					<br> <span id="MainContent_CustomerDataLabel"
						class="customerDataPanel"
						style="font-size: X-Large; font-weight: bold; font-style: italic;">New
						Account Customer Data Screen</span>
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
													<div id="MainContent_Signer2" style="text-align: center;">

														<table id="MainContent_Table2" style="width: 500px;">
															<tbody>
																<tr>
																	<th colspan="2"><span
																		id="MainContent_FieldSection2"
																		style="font-size: Large;">PNI Details</span></th>
																</tr>
																<tr>
																	<td colspan="1"><span id="MainContent_Label10"
																		style="font-weight: bold;">Name</span></td>
																	<td><input name="recipientName"
																		type="text" id="MainContent_JointName"
																		autocomplete="off"></td>
																</tr>
																<tr>
																	<td><span id="MainContent_Label8"
																		style="font-weight: bold;">Email Address</span></td>
																	<td><input
																		name="recipientEmail" type="text"
																		id="MainContent_JointEmailAddress" autocomplete="off"></td>
																</tr>
																<tr>
																	<td align="center" colspan="4"><input
																		type="submit" name="ctl00$MainContent$Sign"
																		value="Send Envelope" id="MainContent_Sign"></td>
																</tr>
															</tbody>
														</table>

													</div>
												</td>

												<td valign="middle" class="auto-style1">
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
	<div id="__lpform_MainContent_Name_numspan"
		style="display: none; z-index: 37 !important;"></div>
	<div id="__lpform_MainContent_Name"
		style="max-height: 16px; vertical-align: top; position: absolute; top: 231px; left: 411px; z-index: 36;">
		<img id="__lpform_MainContent_Name_icon"
			src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABAAAAAQCAYAAAAf8/9hAAAAAXNSR0IArs4c6QAAARNJREFUOBGlU72ORWAQPYREq9CtRryBQqJSaGziATyB1/AaV3c7ryAegUZHfxM1hUTiZ82EXbvVcicx35yZOWe+nxDiOP4E8FjX9WNb/22CILy25kjc3GUyTdkHPsSrk4l8GHFpB2/ZbQFVVXnwbQHXdX8EJEkCJRzHwXa7XLAsC57nQVEUxoZhwPd9aJrG+HASBbZtswDFXdeh73sEQUAQsiwjz3OEYcixrutIkoRr5PgI0zR9Jyj+i7fbxjzP3HOuUYJ3UBQFlmXBOI5omoYb0zQFXVRZlkx+Pp8wTRNVVXH9cCxAZBI5W13XZ4i2bfn7ldzA7VfIsoy1bgsMw/CewHEUcf+rDnxpJS4dIbojsnOiL0hfafwTOClcAAAAAElFTkSuQmCC"
			style="opacity: 0.6; vertical-align: top;">
	</div>
	<div id="__lpform_MainContent_EmailAddress_numspan"
		style="display: none; z-index: 37 !important;"></div>
	<div id="__lpform_MainContent_EmailAddress"
		style="max-height: 16px; vertical-align: top; position: absolute; top: 276px; left: 411px; z-index: 36;">
		<img id="__lpform_MainContent_EmailAddress_icon"
			src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABAAAAAQCAYAAAAf8/9hAAAAAXNSR0IArs4c6QAAARNJREFUOBGlU72ORWAQPYREq9CtRryBQqJSaGziATyB1/AaV3c7ryAegUZHfxM1hUTiZ82EXbvVcicx35yZOWe+nxDiOP4E8FjX9WNb/22CILy25kjc3GUyTdkHPsSrk4l8GHFpB2/ZbQFVVXnwbQHXdX8EJEkCJRzHwXa7XLAsC57nQVEUxoZhwPd9aJrG+HASBbZtswDFXdeh73sEQUAQsiwjz3OEYcixrutIkoRr5PgI0zR9Jyj+i7fbxjzP3HOuUYJ3UBQFlmXBOI5omoYb0zQFXVRZlkx+Pp8wTRNVVXH9cCxAZBI5W13XZ4i2bfn7ldzA7VfIsoy1bgsMw/CewHEUcf+rDnxpJS4dIbojsnOiL0hfafwTOClcAAAAAElFTkSuQmCC"
			style="opacity: 0.6; vertical-align: top;">
	</div>
	<div id="__lpform_MainContent_JointName_numspan"
		style="display: none; z-index: 37 !important;"></div>
	<div id="__lpform_MainContent_JointName"
		style="max-height: 16px; vertical-align: top; position: absolute; top: 384px; left: 422px; z-index: 36;">
		<img id="__lpform_MainContent_JointName_icon"
			src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABAAAAAQCAYAAAAf8/9hAAAAAXNSR0IArs4c6QAAARNJREFUOBGlU72ORWAQPYREq9CtRryBQqJSaGziATyB1/AaV3c7ryAegUZHfxM1hUTiZ82EXbvVcicx35yZOWe+nxDiOP4E8FjX9WNb/22CILy25kjc3GUyTdkHPsSrk4l8GHFpB2/ZbQFVVXnwbQHXdX8EJEkCJRzHwXa7XLAsC57nQVEUxoZhwPd9aJrG+HASBbZtswDFXdeh73sEQUAQsiwjz3OEYcixrutIkoRr5PgI0zR9Jyj+i7fbxjzP3HOuUYJ3UBQFlmXBOI5omoYb0zQFXVRZlkx+Pp8wTRNVVXH9cCxAZBI5W13XZ4i2bfn7ldzA7VfIsoy1bgsMw/CewHEUcf+rDnxpJS4dIbojsnOiL0hfafwTOClcAAAAAElFTkSuQmCC"
			style="opacity: 0.6; vertical-align: top;">
	</div>
	<div id="__lpform_MainContent_JointEmailAddress_numspan"
		style="display: none; z-index: 37 !important;"></div>
	<div id="__lpform_MainContent_JointEmailAddress"
		style="max-height: 16px; vertical-align: top; position: absolute; top: 429px; left: 422px; z-index: 36;">
		<img id="__lpform_MainContent_JointEmailAddress_icon"
			src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABAAAAAQCAYAAAAf8/9hAAAAAXNSR0IArs4c6QAAARNJREFUOBGlU72ORWAQPYREq9CtRryBQqJSaGziATyB1/AaV3c7ryAegUZHfxM1hUTiZ82EXbvVcicx35yZOWe+nxDiOP4E8FjX9WNb/22CILy25kjc3GUyTdkHPsSrk4l8GHFpB2/ZbQFVVXnwbQHXdX8EJEkCJRzHwXa7XLAsC57nQVEUxoZhwPd9aJrG+HASBbZtswDFXdeh73sEQUAQsiwjz3OEYcixrutIkoRr5PgI0zR9Jyj+i7fbxjzP3HOuUYJ3UBQFlmXBOI5omoYb0zQFXVRZlkx+Pp8wTRNVVXH9cCxAZBI5W13XZ4i2bfn7ldzA7VfIsoy1bgsMw/CewHEUcf+rDnxpJS4dIbojsnOiL0hfafwTOClcAAAAAElFTkSuQmCC"
			style="opacity: 0.6; vertical-align: top;">
	</div>
	<div id="__lpform_MainContent_Field5_numspan"
		style="display: none; z-index: 37 !important;"></div>
	<div id="__lpform_MainContent_Field5"
		style="max-height: 16px; vertical-align: top; position: absolute; top: 474px; left: 422px; z-index: 36;">
		<img id="__lpform_MainContent_Field5_icon"
			src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABAAAAAQCAYAAAAf8/9hAAAAAXNSR0IArs4c6QAAARNJREFUOBGlU72ORWAQPYREq9CtRryBQqJSaGziATyB1/AaV3c7ryAegUZHfxM1hUTiZ82EXbvVcicx35yZOWe+nxDiOP4E8FjX9WNb/22CILy25kjc3GUyTdkHPsSrk4l8GHFpB2/ZbQFVVXnwbQHXdX8EJEkCJRzHwXa7XLAsC57nQVEUxoZhwPd9aJrG+HASBbZtswDFXdeh73sEQUAQsiwjz3OEYcixrutIkoRr5PgI0zR9Jyj+i7fbxjzP3HOuUYJ3UBQFlmXBOI5omoYb0zQFXVRZlkx+Pp8wTRNVVXH9cCxAZBI5W13XZ4i2bfn7ldzA7VfIsoy1bgsMw/CewHEUcf+rDnxpJS4dIbojsnOiL0hfafwTOClcAAAAAElFTkSuQmCC"
			style="opacity: 0.6; vertical-align: top;">
	</div>
	<div id="__lpform_MainContent_JointAuthInfo1_numspan"
		style="display: none; z-index: 37 !important;"></div>
	<div id="__lpform_MainContent_JointAuthInfo1"
		style="max-height: 16px; vertical-align: top; position: absolute; top: 565px; left: 422px; z-index: 36;">
		<img id="__lpform_MainContent_JointAuthInfo1_icon"
			src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABAAAAAQCAYAAAAf8/9hAAAAAXNSR0IArs4c6QAAARNJREFUOBGlU72ORWAQPYREq9CtRryBQqJSaGziATyB1/AaV3c7ryAegUZHfxM1hUTiZ82EXbvVcicx35yZOWe+nxDiOP4E8FjX9WNb/22CILy25kjc3GUyTdkHPsSrk4l8GHFpB2/ZbQFVVXnwbQHXdX8EJEkCJRzHwXa7XLAsC57nQVEUxoZhwPd9aJrG+HASBbZtswDFXdeh73sEQUAQsiwjz3OEYcixrutIkoRr5PgI0zR9Jyj+i7fbxjzP3HOuUYJ3UBQFlmXBOI5omoYb0zQFXVRZlkx+Pp8wTRNVVXH9cCxAZBI5W13XZ4i2bfn7ldzA7VfIsoy1bgsMw/CewHEUcf+rDnxpJS4dIbojsnOiL0hfafwTOClcAAAAAElFTkSuQmCC"
			style="opacity: 0.6; vertical-align: top;">
	</div>
</body>
</html>