<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Test Step</title>
<script>
function resetfields() {	
	document.getElementById("teststepId").value="";
	document.getElementById("stepName").value="";
	document.getElementById("elementType").selectedIndex=-1;
	document.getElementById("elementLocType").selectedIndex=-1;
	document.getElementById("elementLoc").value="";
	document.getElementById("action").selectedIndex=-1;
	document.getElementById("waitType").selectedIndex=-1;
	document.getElementById("waitTime").value="";
	document.getElementById("isActive").value="";
	return false;
}
</script>
</head>
<body>
	<form:form id="teststepForm" modelAttribute="teststep" action="processTestStep"
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
				<td style="color: blue; font-weight:bold;">Test Harness - Create Test Step</td>
			</tr>
		</table>		
		<table align="center" cellspacing="5px" cellpadding="5%">
			<tr>
			<td><form:label path = "testcaseId">Test Case:</form:label></td>               
                  <td><form:select path = "testcaseId" name="testcaseId" id="testcaseId">                     
                     <form:options items = "${testcaseList}" />
                  </form:select></td>     	
               
             </tr>
			<tr>
				<td><form:label path="teststepId">Test Step Id:</form:label></td>
				<td><form:input path="teststepId" name="teststepId" id="teststepId" /></td>
			</tr>
			<tr>
				<td><form:label path="stepName">Test Step Name:</form:label></td>
				<td><form:input path="stepName" name="stepName" id="stepName" /></td>
			</tr>			
			<tr>
				<td><form:label path="elementType">Element Type:</form:label></td>
				<td><form:select path = "elementType" name="elementType" id="elementType">
					 <form:option value="" label=""/>                     
                     <form:options items = "${elementtypeList}" />
                  </form:select></td>
			</tr>
			<tr>
				<td><form:label path="elementLocType">Element Locator Type:</form:label></td>
				<td><form:select path = "elementLocType" name="elementLocType" id="elementLocType">
					 <form:option value="" label="" />                     
                     <form:options items = "${elementLocTypeList}" />
                  </form:select></td>
			</tr>
			<tr>
				<td><form:label path="elementLoc">Element Locator:</form:label></td>
				<td><form:input path="elementLoc" name="elementLoc" id="elementLoc" /></td>
			</tr>
			<tr>
				<td><form:label path="action">Action:</form:label></td>
				<td><form:select path = "action" name="action" id="action">
					 <form:option value="" label="" />                     
                     <form:options items = "${actionList}" />
                  </form:select></td>
			</tr>
			<tr>
				<td><form:label path="waitType">Wait Type:</form:label></td>
				<td><form:select path = "waitType" name="waitType" id="waitType"> 
					 <form:option value="" label="" />                    
                     <form:options items = "${waittypeList}" />
                  </form:select></td>
			</tr>
			<tr>
				<td><form:label path="waitTime">Wait Time:</form:label></td>
				<td><form:input path="waitTime" name="waitTime" id="waitTime" /></td>
			</tr>
			<tr>
				<td><form:label path="isActive">Is Active:</form:label></td>
				<td><form:checkbox path = "isActive" name="isActive" id="isActive"/></td>
			</tr>
			</table>						
			<table align="center" cellspacing="3px" cellpadding="3%"> 			
			<tr>
				<td><form:button id="teststep" name="teststep" value="Home">Home</form:button></td>				
				<td><form:button id="teststep" name="teststep" value="Save">Save</form:button></td>
				<td><form:button id="teststep" name="teststep" value="Search">Search</form:button></td>
				<td><form:button id="teststep" name="teststep" value="Cancel" onclick="return resetfields()">Cancel</form:button></td>				
			</tr>			
		</table>
	</form:form>
</body>
</html>