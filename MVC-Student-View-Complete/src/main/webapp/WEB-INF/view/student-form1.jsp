<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<form:form action="processForm" modelAttribute="student">
First Name: <form:input path="firstName"/>
<br>
Last Name: <form:input path="lastName"/>
<br>

Country : 
<form:select path="country">
<form:options items="${student.countryOptions}"/>
</form:select>

<br>
<br>

Favorite Languages :
JAVA <form:radiobutton path="favoriteLanguage" value="JAVA"/>
C# <form:radiobutton path="favoriteLanguage" value="C#"/>
PHP<form:radiobutton path="favoriteLanguage" value="PHP"/>
RUBY<form:radiobutton path="favoriteLanguage" value="RUBY"/>
<br>
<br>
<input type="submit">
</form:form>


</body>
</html>