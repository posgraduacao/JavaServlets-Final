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
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">Adicionar Produto</h4>
				</div>
				<form action="ProdutoServlet" method="post" class="form-group">
					<div class="modal-body">

						Nome: <input type="text" name="nome" class="form-control" />
						Descrição: <input type="text" name="descricao"
							class="form-control" /> Preço: <input type="text" name="preco"
							class="form-control" />Estoque: <input type="text"
							name="estoque" class="form-control" />
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