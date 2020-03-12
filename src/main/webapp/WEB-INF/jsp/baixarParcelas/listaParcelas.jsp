<%@ page language="java" contentType="text/html; charset=UTF8"
	pageEncoding="UTF8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<title>Cadastro funcionário</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>
</head>
<body>
	<div class="container">
		<div>
			<p style="font-weight: bold; font-size: 30px;">BAIXA DE PARCELAS
				DE EMPRÉSTIMO</p>
		</div>
		<form id="formEmprestimos" class="form-horizontal"
			action="/emprestimo/listarParcelas" method="post">
			<div class="form-group row">
				<div class="col-sm-3">Data de Vencimento:</div>
				<div class="col-sm-3">
					<input type="date" id="dataVencimentoInicio"
						name="dataVencimentoInicio" class="form-control"
						value="${dataVencimentoInicio}">
				</div>
				<div class="col-sm-3">até:</div>
				<div class="col-sm-3">
					<input type="date" id="dataVencimentoFim" name="dataVencimentoFim"
						value="${dataVencimentoFim}" class="form-control">
				</div>
			</div>
			<button class="btn btn-default" type="submit">Pesquisar</button>
			<a class="btn btn-default" href="/emprestimo/voltar">Voltar</a>
		</form>
		<table class="table" style="margin-top: 10px;">
			<thead>
				<tr>
					<th>IdEmprestimo</th>
					<th>Funcionário</th>
					<th>Parcela</th>
					<th>Vencimento</th>
					<th>Valor Parcela</th>
					<th>Valor Pago</th>
					<th>Opções</th>
				</tr>
			</thead>
			<c:forEach var="lista" items="${listaParcelas}">
				<tbody>
					<tr>
						<td><c:out value="${lista.id}" /></td>
						<td>${lista.funcionario.nome}</td>
						<td>${lista.parcela}</td>
						<td><fmt:parseDate value="${lista.vencimento}"
								pattern="yyyy-MM-dd" var="parsedDateTime" type="both" /> <fmt:formatDate
								pattern="dd/MM/yyyy" value="${parsedDateTime}" /></td>
						<td><fmt:formatNumber type="number" groupingUsed="true"
								value="${lista.valorParcela}" /></td>
						<td><fmt:formatNumber type="number" groupingUsed="true"
								value="${lista.valorPago}" /></td>
						<td style="text-align: center;">
							<button type="button" class="btn btn-warning"
								data-toggle="modal" data-target="#myModal${lista.id}" <c:if test="${lista.valorPago > 0}">disabled="disabled"</c:if>>Baixar</button>
								<!-- Modal -->
							<div class="modal fade" id="myModal${lista.id}" role="dialog">
								<div class="modal-dialog">

									<!-- Modal content-->
									<div class="modal-content">
										<div class="modal-header">
											<h4 class="modal-title">Confirmação</h4>
											<button type="button" class="close" data-dismiss="modal">&times;</button>
										</div>
										<div class="modal-body" style="text-align: left;">
											<p>Confirmar a baixa da parcela?</p>
										</div>
										<div class="modal-footer">
											<a class="btn btn-info"
												href="/emprestimo/baixarParcela/${lista.id}">Baixar</a>
											<button type="button" class="btn btn-danger"
												data-dismiss="modal">Cancelar</button>
										</div>
									</div>

								</div>
							</div>
						</td>
					</tr>
				</tbody>
			</c:forEach>
		</table>
	</div>
</body>
</html>