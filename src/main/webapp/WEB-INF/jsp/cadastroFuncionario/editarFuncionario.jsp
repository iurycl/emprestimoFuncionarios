<%@ page language="java" contentType="text/html; charset=UTF8"
	pageEncoding="UTF8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
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
			<form id="formFuncionarios" class="form-horizontal"
			action="/funcionario/salvar" method="post">
			<div class="form-group row">
				<label class="col-sm-3">#ID Funcionário:</label>
				<div class="col-sm-9" style="font-weight: bold;">${funcionario.id}</div>
				<input type="hidden" id="idFuncionario" name="id" value="${funcionario.id}">
			</div>
			<div class="form-group row">
				<div class="col-sm-3">Nome:</div>
				<div class="col-sm-9">
					<input type="text" id="nomeFuncionario" name="nome" value="${funcionario.nome}" class="form-control">
				</div>
			</div>
			<div class="form-group row">
				<div class="col-sm-3">CPF:</div>
				<div class="col-sm-3">
					<input type="text" id="cpfFuncionario" name="cpf" value="${funcionario.cpf}" class="form-control">
				</div>
			</div>
			<div class="form-group row">
				<div class="col-sm-3">Setor:</div>
				<div class="col-sm-3">
					<input type="text" id="setorFuncionario" name="setor" value="${funcionario.setor}" class="form-control">
				</div>
				<div class="col-sm-3">Cargo:</div>
				<div class="col-sm-3">
					<input type="text" id="cargoFuncionario" name="cargo" value="${funcionario.cargo}" class="form-control">
				</div>
			</div>
			<div class="form-group row">
				<div class="col-sm-3">Data de Admissão:</div>
				<div class="col-sm-3">
					<input type="date" id="dataAdmissaoFuncionario" name="dataAdmissao" value="${funcionario.dataAdmissao}" class="form-control">
				</div>
			</div>
			<div class="form-group row">
				<div class="col-sm-3">Observação:</div>
				<div class="col-sm-9">
					<textarea id="nomeFuncionario" name="observacao" class="form-control">${funcionario.observacao}</textarea>
				</div>
			</div>
				<button class="btn btn-success" type="submit">Salvar</button>
				<a type="button" class="btn btn-default" href="/">Voltar</a>
			</form>
			<div>
			</div>
		</div>
</body>
</html>