<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, annuaire.Facade, annuaire.Personne, annuaire.Adresse" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Associer</title>
</head>
<body>
<h2>Associer des personnes avec des adresses</h2>
<form action='annuaire?op=assoc' method='post'>
	<h3>Liste des Personnes</h3>
	<%
	Collection<Personne> lp = (Collection<Personne>) request.getAttribute("lp");
	Collection<Adresse> la = (Collection<Adresse>) request.getAttribute("la");
	
	for (Personne personne : lp){
	%>
		<input type='radio' name='idp' value='<%=personne.id%>' > <label for='<%=personne.id%>'><%=personne.prenom + " " + personne.nom%></label><br>
	<%
	}
	%>
	<h3>Liste des adresses</h3>
	<%
	for (Adresse adresse : la){
	%>
		<input type='radio' name='ida' value='<%=adresse.id%>' > <label for='<%=adresse.id%>'><%=adresse.rue + " " + adresse.ville%></label><br>
	<%
	}
	%>
	<button>Associer</button>
</form>
</body>
</html>