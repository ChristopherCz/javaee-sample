<%@page import="deutscherv.entity.Merch"%>
<%@page import="java.util.Collection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Merchandise</title>
</head>
<body>
	<ul>
		<%
			Collection<Merch> merch = (Collection<Merch>) request.getAttribute("me");

		for (Merch m : merch) {
		%><li><%=m.getArtikelnr()%>,<%=m.getName()%>, Verfügbar? <%=m.isLieferbar()%></li>
		<%
			}
		%>


	</ul>
</body>
</html>