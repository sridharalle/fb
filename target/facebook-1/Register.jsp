<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<script type="text/javascript">
function registerUser(){
	alert("Triggered registerUser");
	document.forms[0].action= "registerUser";
	document.forms[0].method="post";
	document.forms[0].submit();
	alert("Exit from registerUser");
}

/* function registerEmployee(){
	alert("Triggered registerUser");
	
	alert("Exit from registerUser");
} */
</script>
<body>
<font color="yellow">${message}</font>
<form action= "${pageContext.request.contextPath}/registerUser">
Name :<input type="text" name="name" value="${employee.name}"/></br>
Email :<input type="text" name="email" value="${employee.email}"/></br>
Mobile :<input type="tel" name="mbl" pattern="[789][0-9]{9} value="${employee.mbl}"/></br>
Password :<input type="password" name="pword" value="${employee.pword}"/></br>
<input type="button" value="register" onclick="registerUser()"/>
<!-- <input type="button" value="registeremp" onclick="registerEmployee()"/> -->
<a href="${pageContext.request.contextPath}/goToLoginPage">Click Here</a> to login
</form>

<form action="testCon">
<input type="submit" value="Click Me"/>
</form>
</body>
</html>