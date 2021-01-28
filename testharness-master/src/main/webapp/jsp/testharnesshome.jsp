<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Harness Login</title>
</head>
<body>
	<table align="center">
			<tr>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
			</tr>
	</table>
	<table align="center">
		<tr>
			<td style="font-style: italic; color: red;">${message}</td>
		</tr>
	</table>	
	<table align="center">
			<tr>
				<td style="color: blue; font-weight:bold;">Test Harness - Manage Test Automation</td>
			</tr>
	</table>	
	<table align="center" cellspacing="5px" cellpadding="5%">
		<tr>
			<td><a href="showTestSuite">Create Test Suite</a></td>
			<td><a href="showTestCase">Create Test Case</a></td>
			<td><a href="showTestStep">Create Test Step</a></td>			
		</tr>
	</table>
	<table align="center" cellspacing="5px" cellpadding="5%">
		<tr>
			<td><a href="login">Logout</a></td>						
		</tr>
	</table>
</body>
</html>