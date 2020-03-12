package br.com.emprestimosfuncionarios.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.emprestimosfuncionarios.model.Emprestimo;
import br.com.emprestimosfuncionarios.model.EmprestimoDto;
import br.com.emprestimosfuncionarios.model.PesquisaBaixaParcelaDto;
import br.com.emprestimosfuncionarios.service.EmprestimoService;
import br.com.emprestimosfuncionarios.service.FuncionarioService;

@Controller
@RequestMapping("/emprestimo")
public class EmprestimoController {

	@Autowired
	EmprestimoService emprestimoService;
	@Autowired
	IndexController indexController;
	@Autowired
	FuncionarioService funcionarioService;

	@RequestMapping(value = "/novoEmprestimo", method = RequestMethod.GET)
	public ModelAndView novoFuncionario(Model model) {
		model.addAttribute("idEmprestimo", emprestimoService.buscarMaiorIdEmprestimoCadastrado());
		model.addAttribute("listaFuncionarios", funcionarioService.getListaFuncionarios());
		return new ModelAndView("cadastroEmprestimo/novoEmprestimo");
	}

	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	public ModelAndView salvar(EmprestimoDto emprestimoDto, Model model) {
		if (emprestimoDto.getDataPrimeiraParcela() == null
				|| emprestimoDto.getDataPrimeiraParcela().isBefore(LocalDate.now())) {
			model.addAttribute("msgErro", "Primeira data da parcela deve ser maior ou igual a data atual");
			model.addAttribute("msgBotaoVoltar", "Voltar para a pagina de cadastro de empréstimo");
			model.addAttribute("href", "/emprestimo/novoEmprestimo");
			return new ModelAndView("/error/exibirError");
		}
		if(emprestimoDto.getValorEmprestimo() == null) {
			model.addAttribute("msgErro", "Valor do emprestimo não pode ser nulo");
			model.addAttribute("msgBotaoVoltar", "Voltar para a pagina de cadastro de empréstimo");
			model.addAttribute("href", "/emprestimo/novoEmprestimo");
			return new ModelAndView("/error/exibirError");
		}
		if (emprestimoService.getEmprestimoPorFuncionario(emprestimoDto.getFuncionario().getId()).size() > 0) {
			model.addAttribute("msgErro", "Ainda existe empréstimos vigentes para o funcionario: "
					+ emprestimoDto.getFuncionario().getNome());
			model.addAttribute("msgBotaoVoltar", "Voltar para a pagina de cadastro de empréstimo");
			model.addAttribute("href", "/emprestimo/novoEmprestimo");
			return new ModelAndView("/error/exibirError");
		}
		model.addAttribute("listaEmprestimo", emprestimoService.gerarParcelas(emprestimoDto));
		model.addAttribute("listaFuncionarios", funcionarioService.getListaFuncionarios());
		return new ModelAndView("cadastroEmprestimo/novoEmprestimo");
	}

	@RequestMapping(value = "/baixarParcelas")
	public ModelAndView baixarParcelas(Model model) {
		return new ModelAndView("/baixarParcelas/listaParcelas");
	}

	@RequestMapping(value = "/listarParcelas", method = RequestMethod.POST)
	public ModelAndView listarParcelas(PesquisaBaixaParcelaDto pesquisaBaixaParcelaDto, Model model) {
		model.addAttribute("listaParcelas", emprestimoService.getEmprestimoPorPeriodo(
				pesquisaBaixaParcelaDto.getDataVencimentoInicio(), pesquisaBaixaParcelaDto.getDataVencimentoFim()));
		model.addAttribute("pesquisaBaixaParcelaDto", pesquisaBaixaParcelaDto);
		model.addAttribute("dataVencimentoInicio", pesquisaBaixaParcelaDto.getDataVencimentoInicio());
		model.addAttribute("dataVencimentoFim", pesquisaBaixaParcelaDto.getDataVencimentoFim());
		return new ModelAndView("/baixarParcelas/listaParcelas");
	}

	@RequestMapping(value = "/voltar", method = RequestMethod.GET)
	public ModelAndView voltar(Model model) {
		return indexController.index(model);
	}
	
	@RequestMapping(value = "/baixarParcela/{id}", method = RequestMethod.GET)
	public ModelAndView baixarParcelas(@PathVariable("id") Long id, Model model) {
		Emprestimo emprestimo = emprestimoService.getEmprestimoPeloId(id).orElse(new Emprestimo());
		emprestimo.setValorPago(emprestimo.getValorParcela());
		emprestimoService.salvar(emprestimo);
		return new ModelAndView("/baixarParcelas/listaParcelas");
	}

}