package br.com.emprestimosfuncionarios.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.emprestimosfuncionarios.service.FuncionarioService;

@Controller
public class IndexController {
	
	@Autowired
	FuncionarioService funcionarioService;
	
	@RequestMapping("/")
	public ModelAndView index(Model model) {
		model.addAttribute("listaFuncionarios", funcionarioService.getListaFuncionarios());
		return new ModelAndView("index");
	}
	

}
