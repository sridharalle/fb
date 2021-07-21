<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	function deleteUser(email) {
		alert(email);
		alert("deleteUser function triggered");
		document.forms[0].action = "deleteUser?mailId=" + email;
		document.forms[0].method = "post";
		document.forms[0].submit();
	}

	function openInEditView(email) {
		alert(email);
		alert("Opening " + email + " in edit view");
		document.form1.action = "openInEditView?mailId=" + email;
		document.form1.method = "post";
		document.form1.submit();
	}
</script>
<body>
	Employee details bellow
	</br>

	<%-- Mail || Name || Mobile Number || Password </br>
<c:forEach var="emp" items="${emplist}">
    ${emp.email} || ${emp.name} || ${emp.mbl} || ${emp.pword} </br>
</c:forEach> --%>

	<a href="<c:url value="j_spring_security_logout" />" > Logout</a></br>

	<form name="form1" id="form1" action="">
		<table border="2">
			<tr>
				<th>Mail</th>
				<th>Name</th>
				<th>MobileNumber</th>
				<th>Password</th>
			</tr>

			<c:forEach var="emp" items="${emplist}">
				<tr>
					<td>${emp.email}</td>
					<td>${emp.name}</td>
					<td>${emp.mbl}</td>
					<td>${emp.pword}</td>
					<td><input type="button" onclick="deleteUser('${emp.email}')"
						value="Delete"></td>
					<td><input type="button"
						onclick="openInEditView('${emp.email}')" value="Edit"></td>
				</tr>
			</c:forEach>
		</table>
	</form>
</body>
</html>