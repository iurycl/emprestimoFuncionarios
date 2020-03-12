package br.com.emprestimosfuncionarios.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

public class PesquisaBaixaParcelaDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataVencimentoInicio;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataVencimentoFim;

	public LocalDate getDataVencimentoInicio() {
		return dataVencimentoInicio;
	}

	public void setDataVencimentoInicio(LocalDate dataVencimentoInicio) {
		this.dataVencimentoInicio = dataVencimentoInicio;
	}

	public LocalDate getDataVencimentoFim() {
		return dataVencimentoFim;
	}

	public void setDataVencimentoFim(LocalDate dataVencimentoFim) {
		this.dataVencimentoFim = dataVencimentoFim;
	}
	
	
}
