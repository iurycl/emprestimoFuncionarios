package br.com.emprestimosfuncionarios.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.emprestimosfuncionarios.model.Funcionario;
import br.com.emprestimosfuncionarios.service.FuncionarioService;

@Controller
@RequestMapping("/funcionario")
public class FuncionarioController {
	
	@Autowired
	FuncionarioService funcionarioService;
	@Autowired
	IndexController indexController;
	
	@RequestMapping(value="/novoFuncionario", method=RequestMethod.GET)
	public ModelAndView novoFuncionario(Model model) {
		model.addAttribute("idFuncionario", funcionarioService.buscarMaiorIdFuncionarioCadastrado());
		return new ModelAndView("cadastroFuncionario/novoFuncionario");
	}
	
	@RequestMapping(value="/editarFuncionario/{id}", method=RequestMethod.GET)
	private ModelAndView editarFuncionario(@PathVariable("id") Long id, Model model) {
		model.addAttribute("funcionario", funcionarioService.getFuncionarioPeloId(id).orElse(new Funcionario()));
		return new ModelAndView("cadastroFuncionario/editarFuncionario");
	}
	
	@RequestMapping(value="/salvar", method=RequestMethod.POST)
	public ModelAndView salvar(Funcionario funcionario, Model model) {
		try {	
			funcionarioService.salvar(funcionario);
		} catch (Exception e) {
			model.addAttribute("msgErro", "Já existe um funcionário com este cpf: " + funcionario.getCpf());
			model.addAttribute("msgBotaoVoltar", "Voltar para a pagina inicial");
			model.addAttribute("href", "/");
			return new ModelAndView("/error/exibirError");
		}
		return indexController.index(model);
	}
	
	@RequestMapping(value="/excluir/{id}", method=RequestMethod.GET)
	public ModelAndView excluir(@PathVariable("id") Long id, Model model) {
		funcionarioService.excluirFuncionario(id);
		return indexController.index(model);
	}
	
	
	

}