package br.com.emprestimosfuncionarios;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.emprestimosfuncionarios.model.Emprestimo;
import br.com.emprestimosfuncionarios.model.EmprestimoDto;
import br.com.emprestimosfuncionarios.model.Funcionario;
import br.com.emprestimosfuncionarios.repository.EmprestimoRepository;
import br.com.emprestimosfuncionarios.service.EmprestimoService;

@SpringBootTest
class EmprestimoServiceTest {

	@Autowired
	EmprestimoService emprestimoService;
	
	EmprestimoRepository emprestimoRepository;

	@Test
	void salvar() {
		EmprestimoDto emprestimoDto = new EmprestimoDto(); 
		Funcionario funcionario = new Funcionario();
		funcionario.setNome("teste");
		emprestimoDto.setDataOperacao(LocalDate.of(2020, 04, 15));
		emprestimoDto.setDataPrimeiraParcela(LocalDate.of(2020, 04, 15));
		emprestimoDto.setQuantidadeParcela(3);
		emprestimoDto.setValorEmprestimo(Float.valueOf(1000));
		emprestimoDto.setFuncionario(funcionario);
		List<Emprestimo> listaEmprestimo = emprestimoService.gerador(emprestimoDto);
		
		//Parcela 1
		assertEquals(listaEmprestimo.get(0).getParcela(), 1);
		assertEquals(listaEmprestimo.get(0).getValorPago(), Float.valueOf(0));
		assertEquals(listaEmprestimo.get(0).getValorParcela(), Float.valueOf(350));
		assertEquals(listaEmprestimo.get(0).getVencimento(), LocalDate.of(2020, 04, 15));
		assertEquals(listaEmprestimo.get(0).getFuncionario().getNome(), "teste");
		
		//Parcela 2
		assertEquals(listaEmprestimo.get(1).getParcela(), 2);
		assertEquals(listaEmprestimo.get(1).getValorPago(), Float.valueOf(0));
		assertEquals(listaEmprestimo.get(1).getValorParcela(), Float.valueOf(350));
		assertEquals(listaEmprestimo.get(1).getVencimento(), LocalDate.of(2020, 05, 15));
		assertEquals(listaEmprestimo.get(1).getFuncionario().getNome(), "teste");
		
		//Parcela 3
		assertEquals(listaEmprestimo.get(2).getParcela(), 3);
		assertEquals(listaEmprestimo.get(2).getValorPago(), Float.valueOf(0));
		assertEquals(listaEmprestimo.get(2).getValorParcela(), Float.valueOf(350));
		assertEquals(listaEmprestimo.get(2).getVencimento(), LocalDate.of(2020, 06, 15));
		assertEquals(listaEmprestimo.get(2).getFuncionario().getNome(), "teste");
	}

}
