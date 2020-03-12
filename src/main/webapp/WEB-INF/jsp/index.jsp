<%@ page language="java" contentType="text/html; charset=UTF8"
	pageEncoding="UTF8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF8">
<title>Cadastro funcionario</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<div>
			<p style="font-weight: bold; font-size: 30px;">CADASTRO DE
				FUNCIONÁRIOS</p>
		</div>
		<div>
			<a class="btn btn-success" href="/funcionario/novoFuncionario">Novo</a>
			<a class="btn btn-success" href="/emprestimo/novoEmprestimo">Empréstimo</a>
			<a class="btn btn-success" href="/emprestimo/baixarParcelas">Baixar
				Parcelas</a>
		</div>
		<table class="table" style="margin-top: 10px;">
			<thead>
				<tr>
					<th scope="col">Id</th>
					<th scope="col">Nome</th>
					<th scope="col">CPF</th>
					<th scope="col">Setor</th>
					<th scope="col">Cargo</th>
					<th scope="col">Data Admissão</th>
					<th scope="col">Opções</th>
				</tr>
			</thead>
			<c:forEach var="lista" items="${listaFuncionarios}">
				<tbody>
					<tr>
						<td><c:out value="${lista.id}" /></td>
						<td>${lista.nome}</td>
						<td>${lista.cpf}</td>
						<td>${lista.setor}</td>
						<td>${lista.cargo}</td>
						<td><fmt:parseDate value="${lista.dataAdmissao}" pattern="yyyy-MM-dd"	var="parsedDateTime" type="both" />
								<fmt:formatDate	pattern="dd/MM/yyyy" value="${parsedDateTime}" />
						</td>
						<td style="text-align: center;"><a
							class="btn btn-warning"
							href="/funcionario/editarFuncionario/${lista.id}">Editar</a> <a
							class="btn btn-danger" href="/funcionario/excluir/${lista.id}">Excluir</a></td>
					</tr>
				</tbody>
			</c:forEach>
		</table>
	</div>
</body>
</html>