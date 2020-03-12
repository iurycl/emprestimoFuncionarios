package br.com.emprestimosfuncionarios.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

public class EmprestimoDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataOperacao;
	
	private Float valorEmprestimo;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataPrimeiraParcela;
	
	private Integer quantidadeParcela;
	
	private Funcionario funcionario;

	public LocalDate getDataOperacao() {
		return dataOperacao;
	}

	public void setDataOperacao(LocalDate dataOperacao) {
		this.dataOperacao = dataOperacao;
	}

	public Float getValorEmprestimo() {
		return valorEmprestimo;
	}

	public void setValorEmprestimo(Float valorEmprestimo) {
		this.valorEmprestimo = valorEmprestimo;
	}

	public LocalDate getDataPrimeiraParcela() {
		return dataPrimeiraParcela;
	}

	public void setDataPrimeiraParcela(LocalDate dataPrimeiraParcela) {
		this.dataPrimeiraParcela = dataPrimeiraParcela;
	}

	public Integer getQuantidadeParcela() {
		return quantidadeParcela;
	}

	public void setQuantidadeParcela(Integer quantidadeParcela) {
		this.quantidadeParcela = quantidadeParcela;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
	
	
	
}
