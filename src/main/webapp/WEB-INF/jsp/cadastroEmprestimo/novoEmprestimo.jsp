<%@ page language="java" contentType="text/html; charset=UTF8"
	pageEncoding="UTF8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<title>Cadastro empréstimo</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<div>
			<p style="font-weight: bold; font-size: 30px;">CADASTRO DE
				EMPRÉSTIMO</p>
		</div>
		<form id="formEmprestimos" class="form-horizontal"
			action="/emprestimo/salvar" method="post">
			<div class="form-group row">
				<div class="col-sm-3">#ID Empréstimo</div>
				<div class="col-sm-9" style="font-weight: bold;">${idEmprestimo}</div>
			</div>
			<div class="form-group row">
				<div class="col-sm-3">Data da Operação:</div>
				<div class="col-sm-3">
					<input type="date" id="dataOperação" name="dataOperacao" class="form-control">
				</div>
			</div>
			<div class="form-group row">
				<div class="col-sm-3">Funcionário:</div>
				<div class="col-sm-9">
				<select name="funcionario" class="form-control">
					<c:forEach var="listaFuncionarios" items="${listaFuncionarios}">
						<option value="${listaFuncionarios.id}">
							${listaFuncionarios.nome}</option>
					</c:forEach>
				</select>
				</div>
			</div>
			<div class="form-group row">
				<div class="col-sm-3">Valor Empréstimo:</div>
				<div class="col-sm-9">
					<input type="number" id="valorEmprestimo" name="valorEmprestimo" class="form-control">
				</div>
			</div>
			<div class="form-group row">
				<div class="col-sm-3">Quantidade Parcelas:</div>
				<div class="col-sm-9">
				<select name="quantidadeParcela" class="form-control">
					<option value="3">3x</option>
					<option value="6">6x</option>
					<option value="12">12x</option>
					<option value="24">24x</option>
				</select>
				</div>
			</div>
			<div class="form-group row">
				<div class="col-sm-3">Data Primeira Parcela:</div>
				<div class="col-sm-3">
					<input type="date" id="dataPrimeiraParcela"
						name="dataPrimeiraParcela" class="form-control">
				</div>
			</div>
			<button class="btn btn-success" type="submit">Gerar Parcelas</button>
			<a class="btn btn-default" href="/emprestimo/voltar">Voltar</a>
		</form>
		<div style="border-bottom: 3px" class="col-sm-12"></div>
		<table class="table" style="margin-top: 10px;">
			<thead>
				<tr>
					<th>Parcela</th>
					<th>Vencimento</th>
					<th>Valor Parcela</th>
				</tr>
			</thead>
			<c:forEach var="lista" items="${listaEmprestimo}">
				<tbody>
					<tr>
						<td>${lista.parcela}</td>
						<td><fmt:parseDate value="${lista.vencimento}"
								pattern="yyyy-MM-dd" var="parsedDateTime" type="both" /> <fmt:formatDate
								pattern="dd/MM/yyyy" value="${parsedDateTime}" /></td>
						<td><fmt:formatNumber type="number" groupingUsed="true" value="${lista.valorParcela}" /></td>
					</tr>
				</tbody>
			</c:forEach>
		</table>
	</div>
</body>
</html>