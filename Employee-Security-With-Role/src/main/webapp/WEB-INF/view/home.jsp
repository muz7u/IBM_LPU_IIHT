<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<html>

<head>
	<title>Employee Home Page</title>
</head>

<body>
	<h2>Clink on the service you want to use :</h2>
	<hr>

	
	<hr>
	
	<!-- display user name and role -->
	
	<p>
		User: <security:authentication property="principal.username" />
		<br><br>
		Role(s): <security:authentication property="principal.authorities" />
	</p>
	
	<security:authorize access="hasRole('ADMIN')">
	
		<!-- Add a link to point to /employee ... this is for the managers -->
		
		<p>
			<a href="${pageContext.request.contextPath}/employee">Create Employee</a>
			(Only for Admin)
		</p>
		<p>
			<a href="${pageContext.request.contextPath}/employee/new">Create Employee</a>
			(Only for Admin)
		</p>

	</security:authorize>	
	
	
	<security:authorize access="hasRole('USER')">  

		<!-- Add a link to point to /systems ... this is for the admins -->
		
		<p>
			<a href="${pageContext.request.contextPath}/employees/getById">Find Employee By Id</a>
			(Only for User)
		</p>
		<p>
			<a href="${pageContext.request.contextPath}/employees/{employeeId}">Find Employee By Id</a>
			(Only for User)
		</p>
		
		<p>
			<a href="${pageContext.request.contextPath}/employees">List of Employee</a>
			(Only for User)
		</p>
	
	</security:authorize>
	
	<hr>
	
	
	<!-- Add a logout button -->
	<form:form action="${pageContext.request.contextPath}/logout" 
			   method="POST">
	
		<input type="submit" value="Logout" />
	
	</form:form>
	
</body>

</html>









