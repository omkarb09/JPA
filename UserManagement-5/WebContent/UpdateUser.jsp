<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update User</title>
</head>
<body>
	<form action="update.do" id="frm" method="post">
		<table>
			<tr>
				<td>Username</td>
				<td><input type="text" name="username" id="username" value=''></td>
			</tr>
			<tr>
				<td>First Name</td>
				<td><input type="text" name="firstname" id="firstname"></td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td><input type="text" name="lastname" id="lastname"></td>
			</tr>
			<tr>
				<td>Mobile Number</td>
				<td><input type="text" name="mobilenumber" id="mobilenumber"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Update User" ></td>
			</tr>
		</table>
	</form>
</body>
</html>