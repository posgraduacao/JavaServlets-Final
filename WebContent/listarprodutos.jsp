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
					<h4 class="modal-title" id="myModalLabel">Tela Principal</h4>
				</div>
				<div class="modal-body">
					<div class="row">
						<div class="col-md-2">
							<a href="../JavaServlets-Final/produto.jsp"
								class="btn btn-success">Adicionar</a>
						</div>
						<div class="col-md-6">
							<form action="PesquisarServlet" method="post" class="form-inline">
								<div class="form-group">
									<input type="text" name="nome" class="form-control"
										placeholder="Pesquisar" />
									<button type="submit" name="action" value="Pesquisar"
										class="btn btn-default">
										<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
									</button>
								</div>
							</form>
						</div>
					</div>
					<br/>
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
										<td><a href="EditarServlet?id=${p.id}" class="text-warning"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></a></td>
										<td><a href="ExcluirServlet?id=${p.id}" class="text-danger"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></a></td>
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