<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, annuaire.Facade, annuaire.Personne, annuaire.Adresse" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lister</title>
</head>
<body>
	<h3>Liste des personnes de l'annuaire</h3>
	<%
	Collection<Personne> lp = (Collection<Personne>) request.getAttribute("lp");
	for (Personne personne : lp){
		%>
		<strong> <%=personne.nom%> <%=personne.prenom%> </strong><br>
		<ul>
		<%
		for (Adresse adresse : personne.adresses){ %>
			<li><%=adresse.rue%> <%=adresse.ville%></li>
		
		<%
		}
		%>
		</ul>
		<%
	 }
	%>
</body>
</html>