<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="resources/js/bootstrap.min.js"></script>
	<div class="container">
		<div class="row">
			<div class="col-md-1">
				<a href="../JavaServlets-Final/produto.jsp" class="btn btn-success">Adicionar</a>
			</div>
			<div class="col-md-11">
				<form action="Pesquisar" method="get" class="form-inline">
					<div class="form-group">
						Id: <input type="text" name="id" class="form-control" /><input
							type="submit" name="action" value="Pesquisar"
							class="btn btn-default" />
					</div>
				</form>
			</div>
		</div>
		<br/>

		<div>
			<table>
				<tbody>
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>Role</th>
					</tr>
					<c:forEach items="${requestScope.lista}" var="emp">
						<tr>
							<td><c:out value="${emp.nome}"></c:out></td>
							<td><c:out value="${emp.descricao}"></c:out></td>
							<td><c:out value="${emp.preco}"></c:out></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>