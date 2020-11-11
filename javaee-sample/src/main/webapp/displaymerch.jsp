<%@page import="deutscherv.entity.Merch"%>
<%@page import="java.util.Collection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Merchandise</title>
</head>
<body>
<form action="warenkorbplus" method="post">
	<ul>
		<c:forEach items="${me}" var="m">
			<li><c:out value="${m.artikelnr}, ${m.name}, Ist verfügbar?,${m.lieferbar}"/>
			<button name="artikelnr" value="${m.artikelnr}">Hinzufügen zum Warenkorb</button></li>
		</c:forEach>


	</ul>
	
</body>
</html>