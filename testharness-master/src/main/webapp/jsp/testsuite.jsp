<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Test Suite</title>
<script>
function resetfields() {	
	document.getElementById("testsuiteName").value="";
	document.getElementById("testsuiteDesc").value="";
	return false;
}
</script>
</head>
<body>
	<form:form id="testsuiteForm" modelAttribute="testsuite" action="processTestSuite" method="post">
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
				<td style="color: blue; font-weight:bold;">Test Harness - Create Test Suite</td>
			</tr>
		</table>				
		<table align="center" cellspacing="5px" cellpadding="5%">			
			<tr>
				<td><form:label path="testsuiteName">Test Suite Name:</form:label></td>
				<td><form:input path="testsuiteName" name="testsuiteName" id="testsuiteName"/></td>
			</tr>
			<tr>
				<td><form:label path="testsuiteDesc">Test Suite Description:</form:label></td>
				<td><form:input path="testsuiteDesc" name="testsuiteDesc"
						id="testsuiteDesc"/></td>
			</tr>	
		</table>
		<table align="center" cellspacing="3px" cellpadding="3%"> 			
			<tr>
				<td><form:button id="testsuite" name="testsuite" value="Home">Home</form:button></td>				
				<td><form:button id="testsuite" name="testsuite" value="Save">Save</form:button></td>
				<td><form:button id="testsuite" name="testsuite" value="Search">Search</form:button></td>
				<td><form:button id="testsuite" name="testsuite" value="Cancel" onclick="return resetfields()">Cancel</form:button></td>
				<td><form:button id="testsuite" name="testsuite" value="CreateTestCase">Create Test Case</form:button></td>
			</tr>			
		</table>
	</form:form>

</body>
</html>