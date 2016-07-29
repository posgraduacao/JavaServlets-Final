<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sistema de Produtos</title>
<link href="resources/css/bootstrap.css" rel="stylesheet">
<link href="resources/css/signin.css" rel="stylesheet">
</head>
<body>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="resources/js/bootstrap.js"></script>
	<div class="container">
		<div class="modal-dialog modal-lg" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<form action="ListarServlet" method="get">
						<button type="submit" class="close" data-dismiss="modal"
							aria-label="Close"> <span
							aria-hidden="true">&times;</span>
						</button>
					</form>
					<h4 class="modal-title" id="myModalLabel">Pesquisar Produto</h4>
				</div>
				<div class="modal-body">
					<div>
						<table class="table table-hover">
							<tbody>
								<tr>
									<th>ID</th>
									<th>Nome</th>
									<th>Descrição</th>
									<th>Preço</th>
									<th>Estoque</th>
									<th></th>
									<th></th>
								</tr>
								<c:forEach items="${requestScope.lista}" var="p">
									<tr>
										<td><c:out value="${p.id}"></c:out></td>
										<td><c:out value="${p.nome}"></c:out></td>
										<td><c:out value="${p.descricao}"></c:out></td>
										<td><c:out value="${p.preco}"></c:out></td>
										<td><c:out value="${p.estoque}"></c:out></td>
										<td><a href="EditarServlet?id=${p.id}">Editar</a></td>
										<td><a href="ExcluirServlet?id=${p.id}">Excluir</a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>