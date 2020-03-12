<%@ page language="java" contentType="text/html; charset=UTF8"
	pageEncoding="UTF8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
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
			<form id="formFuncionarios"
			action="/funcionario/salvar" method="post">
			<div class="form-group row">
				<label class="col-sm-3">#ID Funcionário:</label>
				<div class="col-sm-9" style="font-weight: bold;">${idFuncionario}</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-3">Nome:</label>
				<div class="col-sm-9">
					<input type="text" id="nomeFuncionario" name="nome" class="form-control">
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-3">CPF:</label>
				<div class="col-sm-3">
					<input type="text" id="cpfFuncionario" name="cpf" class="form-control">
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-3">Setor:</label>
				<div class="col-sm-3">
					<input type="text" id="setorFuncionario" name="setor" class="form-control">
				</div>
				<label class="col-sm-3">Cargo:</label>
				<div class="col-sm-3">
					<input type="text" id="cargoFuncionario" name="cargo" class="form-control">
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-3">Data de Admissão:</label>
				<div class="col-sm-3">
					<input type="date"  id="dataAdmissaoFuncionario" name="dataAdmissao" class="form-control">
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-3">Observação:</label>
				<div class="col-sm-9">
					<textarea id="nomeFuncionario" name="observacao" class="form-control"></textarea>
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