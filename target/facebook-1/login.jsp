<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<font color= "red"><i><b>${message}</b></i></font>
<!-- <form action="loginUser" method="post"> -->
<form action="${pageContext.request.contextPath}/<c:url value='j_spring_security_check'/>" method="post">
Email: <input type="text" name="email"/></br>
Password : <input type="password" name="pword"/></br>
<input type="submit" value="login"/>

</form>
</body>
</html>