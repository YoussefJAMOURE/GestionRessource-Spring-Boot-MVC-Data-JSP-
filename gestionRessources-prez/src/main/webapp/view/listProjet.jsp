<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.ibm.common.Projet"%>
<%@ page import="com.ibm.common.Ressource"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Projets</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
</head>
<body>
	<%@include file="navBar.jsp"%>
	<div style="margin: 2% 5%;">
		<h3>Welcome, Ajouter un Projet</h3>
		<div class="row offset-lg-1">
			<form class="form-inline" method="POST"
				action="http://localhost:8181/gestionRessources-prez/addProjet">
				<input type="hidden" name="id" value="${projet.id}" />

				<div class="input-group mb-2 mr-sm-4">
					<div class="input-group-prepend">
						<div class="input-group-text">Nom Projet</div>
					</div>
					<input type="text" class="form-control" id="name" name="nom"
						value="${projet.nom}" placeholder="Entrer nom projet ..." />
				</div>

				<div class="input-group mb-2 mr-sm-4">
					<div class="input-group-prepend">
						<div class="input-group-text">Respensable</div>
					</div>
					<select name="responsable" class="form-control" id="Respensable">
						<c:forEach items="${ressources}" var="item">
							<option value="${item.id}">${item.nom}</option>
						</c:forEach>
					</select>
				</div>

				<div class="input-group mb-2 mr-sm-4">
					<div class="input-group-prepend">
						<div class="input-group-text">Date Debut</div>
					</div>
					<input type="date" class="form-control" id="debut" name="dateDebut"
						value="${projet.dateDebut}" />
				</div>

				<div class="input-group mb-2 mr-sm-4">
					<div class="input-group-prepend">
						<div class="input-group-text">Date Debut</div>
					</div>
					<input type="date" class="form-control" id="fin" name="dateFin"
						value="${projet.dateFin}" />
				</div>

				<div class="input-group mb-2 mr-sm-4">
					<div class="input-group-prepend"></div>
					<button type="submit" class="btn btn-primary">Submit</button>
				</div>

			</form>
		</div>
		<br /> <br />
		<div class="row">
			<table class="table">
				<h3>List des Projets</h3>
				<thead>
					<th>Projet</th>
					<th>Responsable</th>
					<th>Debut</th>
					<th>Fin</th>
					<th>Action</th>
				</thead>
				<tbody>
					<c:forEach items="${projets}" var="item">
						<tr>
							<td><c:out value="${item.nom}" /></td>
							<td><c:out value="${item.responsable.refog}" /></td>
							<td><c:out value="${item.dateDebut}" /></td>
							<td><c:out value="${item.dateFin }" /></td>
							<td><a
								href="http://localhost:8181/gestionRessources-prez/removeProjet/<c:out value="${item.id}" />">remove</a>
								<a
								href="http://localhost:8181/gestionRessources-prez/getProjet/<c:out value="${item.id}" />">update</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
		integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
		integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
		crossorigin="anonymous"></script>
	<style>
body {
	background-color: #5da9aa;
	background-image: url("data:image/svg+xml,%3Csvg xmlns='http://www.w3.org/2000/svg' width='100%25' height='100%25' viewBox='0 0 2 1'%3E%3Cdefs%3E%3ClinearGradient id='a' gradientUnits='userSpaceOnUse' x1='0' x2='0' y1='0' y2='1' gradientTransform='rotate(78,0.5,0.5)'%3E%3Cstop offset='0' stop-color='%235da9aa'/%3E%3Cstop offset='1' stop-color='%23ffdbe8'/%3E%3C/linearGradient%3E%3ClinearGradient id='b' gradientUnits='userSpaceOnUse' x1='0' y1='0' x2='0' y2='1' gradientTransform='rotate(80,0.5,0.5)'%3E%3Cstop offset='0' stop-color='%23c1c3c7' stop-opacity='0'/%3E%3Cstop offset='1' stop-color='%23c1c3c7' stop-opacity='1'/%3E%3C/linearGradient%3E%3ClinearGradient id='c' gradientUnits='userSpaceOnUse' x1='0' y1='0' x2='2' y2='2' gradientTransform='rotate(230,0.5,0.5)'%3E%3Cstop offset='0' stop-color='%23c1c3c7' stop-opacity='0'/%3E%3Cstop offset='1' stop-color='%23c1c3c7' stop-opacity='1'/%3E%3C/linearGradient%3E%3C/defs%3E%3Crect x='0' y='0' fill='url(%23a)' width='2' height='1'/%3E%3Cg fill-opacity='0.63'%3E%3Cpolygon fill='url(%23b)' points='0 1 0 0 2 0'/%3E%3Cpolygon fill='url(%23c)' points='2 1 2 0 0 0'/%3E%3C/g%3E%3C/svg%3E");
	background-attachment: fixed;
	background-size: cover;
}
</style>
</body>
</html>