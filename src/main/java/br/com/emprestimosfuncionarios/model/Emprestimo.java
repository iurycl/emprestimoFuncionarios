package br.com.emprestimosfuncionarios.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="emprestimo")
public class Emprestimo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private Funcionario funcionario;
	
	private Integer parcela;
	
	private Float valorParcela;
	
	private Float valorPago;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate vencimento;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Funcionario getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	public Integer getParcela() {
		return parcela;
	}
	public void setParcela(Integer parcela) {
		this.parcela = parcela;
	}
	public Float getValorParcela() {
		return valorParcela;
	}
	public void setValorParcela(Float valorParcela) {
		this.valorParcela = valorParcela;
	}
	public Float getValorPago() {
		return valorPago;
	}
	public void setValorPago(Float valorPago) {
		this.valorPago = valorPago;
	}

	public LocalDate getVencimento() {
		return vencimento;
	}
	public void setVencimento(LocalDate vencimento) {
		this.vencimento = vencimento;
	}
}
