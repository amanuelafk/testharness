<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Test Case</title>
<script>
function resetfields() {	
	document.getElementById("testcaseId").value="";
	document.getElementById("testcaseName").value="";
	document.getElementById("testcaseDesc").value="";
	return false;
}
</script>
</head>
<body>
	<form:form id="testcaseForm" modelAttribute="testcase" action="processTestCase"
		method="post">
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
				<td style="color: blue; font-weight:bold;">Test Harness - Create Test Case</td>
			</tr>
		</table>		
		<table align="center" cellspacing="5px" cellpadding="5%">
			<tr>
			<td><form:label path = "testsuiteId">Test Suite:</form:label></td>               
                  <td><form:select path = "testsuiteId" name="testsuiteId" id="testsuiteId">                     
                     <form:options items = "${testsuiteList}" />
                  </form:select></td>     	
               
             </tr>
             <tr>
				<td><form:label path="testcaseId">Test Case Id:</form:label></td>
				<td><form:input path="testcaseId" name="testcaseId" id="testcaseId" /></td>
			</tr>			  
			<tr>
				<td><form:label path="testcaseName">Test Case Name:</form:label></td>
				<td><form:input path="testcaseName" name="testcaseName" id="testcaseName" /></td>
			</tr>
			<tr>
				<td><form:label path="testcaseDesc">Test Case Description:</form:label></td>
				<td><form:input path="testcaseDesc" name="testcaseDesc"
						id="testcaseDesc" /></td>
			</tr>
		</table>
		<table align="center" cellspacing="3px" cellpadding="3%"> 			
			<tr>				
				<td><form:button id="testcase" name="testcase" value="Home">Home</form:button></td>
				<td><form:button id="testcase" name="testcase" value="Save">Save</form:button></td>
				<td><form:button id="testcase" name="testcase" value="Search">Search</form:button></td>
				<td><form:button id="testcase" name="testcase" value="Cancel" onclick="return resetfields()">Cancel</form:button></td>
				<td><form:button id="testcase" name="testcase" value="CreateTestStep">Create Test Step</form:button></td>				
			</tr>			
		</table>		
	</form:form>
</body>
</html>