<%@page import="java.util.ArrayList"%>
<%@page import="com.tyss.Student"%>

<%@ page language="java" contentType="application/xml; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
<!DOCTYPE html>
<html>

<head>
	<meta charset="ISO-8859-1"> </meta>
	
	<title>Insert title here</title>
</head>
<body>
	<h2>Index.jsp is triggred</h2>
	<h3>User data</h3>
	<h4>UserName : ${pname}</h4>
	<h4>UserAge : ${page}</h4>
	<h4>Student data : </h4>
	<h3>${student }</h3>
	
	<hr>
	

</body>
</html>