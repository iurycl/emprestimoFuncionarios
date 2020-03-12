package br.com.emprestimosfuncionarios.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.emprestimosfuncionarios.model.Emprestimo;
import br.com.emprestimosfuncionarios.model.EmprestimoDto;
import br.com.emprestimosfuncionarios.repository.EmprestimoRepository;

@Service
public class EmprestimoService {

	@Autowired
	EmprestimoRepository emprestimoRepository;

	public Object gerarParcelas(EmprestimoDto emprestimoDto) {
		return emprestimoRepository.saveAll(gerador(emprestimoDto));
	}
	
	public List<Emprestimo> gerador(EmprestimoDto emprestimoDto) {
		// Faz o calculo da do valor total com juros e divide na quantidade de parcelas correta
		Float valorParcelaComJuros = (((emprestimoDto.getValorEmprestimo() / 100) * 5) + emprestimoDto.getValorEmprestimo())
				/ emprestimoDto.getQuantidadeParcela();
		Integer parcela = 1;
		List<Emprestimo> listaMostrarTela = new ArrayList<Emprestimo>();

		while (parcela <= emprestimoDto.getQuantidadeParcela()) {
			Emprestimo emprestimo = new Emprestimo();
			emprestimo.setParcela(parcela);
			emprestimo.setVencimento(manipulaDataParcela(parcela, emprestimoDto.getDataPrimeiraParcela()));
			emprestimo.setValorParcela(valorParcelaComJuros);
			emprestimo.setValorPago(new Float(0));
			emprestimo.setFuncionario(emprestimoDto.getFuncionario());
			emprestimoDto.setDataPrimeiraParcela(manipulaDataParcela(parcela, emprestimoDto.getDataPrimeiraParcela()));
			parcela += 1;
			listaMostrarTela.add(emprestimo);
		}
		return listaMostrarTela;
	}

	private LocalDate manipulaDataParcela(Integer parcela, LocalDate dataParcela) {
		if (!parcela.equals(1)) {
			dataParcela = dataParcela.plusMonths(1);
		}
		return dataParcela;
	}

	public Long buscarMaiorIdEmprestimoCadastrado() {
		// Busca o maior id cadastrado de emprestimos, caso não existir adiciona o 0
		// como primario.
		return getIdsEmprestimo().isEmpty() ? 1L : Collections.max(getIdsEmprestimo()) + 1;
	}

	public void salvar(Emprestimo emprestimo) {
		emprestimoRepository.save(emprestimo);
	}

	public List<Long> getIdsEmprestimo() {
		return emprestimoRepository.findAllIds();
	}
	
	public List<Emprestimo> getEmprestimoPorFuncionario(Long id) {
		return emprestimoRepository.findAllByIdFuncionario(id);
	}
	
	public List<Emprestimo> getEmprestimoPorPeriodo(LocalDate dataVencimentoInicio, LocalDate dataVencimentoFim) {
		return emprestimoRepository.findAllByInicioFim(dataVencimentoInicio, dataVencimentoFim);
	}
	
	public Optional<Emprestimo> getEmprestimoPeloId(Long id) {
		return emprestimoRepository.findById(id);
	}


}
