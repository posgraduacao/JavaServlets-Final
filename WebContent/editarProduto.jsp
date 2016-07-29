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
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</form>
					<h4 class="modal-title" id="myModalLabel">Adicionar Produto</h4>
				</div>
				<form action="AtualizarServlet" method="post" class="form-group">
					<div class="modal-body">
						<input type="hidden" value="${p.id}" name="id"> Nome: <input
							type="text" name="nome" class="form-control" value="${p.nome}" />
						Descrição: <input type="text" name="descricao"
							class="form-control" value="${p.descricao}" /> Preço: <input
							type="text" name="preco" class="form-control" value="${p.preco}" />Estoque:
						<input type="text" name="estoque" class="form-control"
							value="${p.estoque}" />
					</div>
					<div class="modal-footer">
						<input type="submit" name="action" value="Gravar"
							class="btn btn-primary" />
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>