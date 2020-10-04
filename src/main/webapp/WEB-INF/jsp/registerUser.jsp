<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>

<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>User Registration</title>
	</head>
	<body>
  	<!-- Values entered here are bound to the properties of 
      user object assigned here to modelAttribute -->
  		<form:form action="/demo/showUser" modelAttribute="user" method="post">
    		<table>
      			<tr>
        			<td>
          				<form:label path="firstName">First Name</form:label>
        			</td>
        			<td>
          				<form:input path="firstName" id="firstname" />
        			</td>
      			</tr>
      			<tr>
			        <td>
          				<form:label path="lastName">Last Name</form:label>
        			</td>
        			<td>
          				<form:input path="lastName" id="lastname" />
        			</td>
      			</tr>
      			<tr>
        			<td><input type="submit" value="Submit"></td>
      			</tr>
    		</table>
  		</form:form>
	</body>
</html>
