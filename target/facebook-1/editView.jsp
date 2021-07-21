<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%-- <font color= "red">${ErrorMsg}</font> --%>
<form action= "updateUser" method= "post">
Name :<input type="text" name="name" value="${empl.name}"/></br>
Email :<input type="text" name="email" value="${empl.email}"/></br>
Mobile :<input type="text" name="mbl" value="${empl.mbl}"/></br>
Password :<input type="password" name="pword" value="${empl.pword}"/></br>
<input type="submit" value="Update" />
</form>
</body>
</html>