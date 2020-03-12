package br.com.emprestimosfuncionarios.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import br.com.emprestimosfuncionarios.model.Funcionario;
import br.com.emprestimosfuncionarios.repository.FuncionarioRepository;

@Service
public class FuncionarioService {
	
	@Autowired
	FuncionarioRepository funcionarioRepository;
	
	
	public Long buscarMaiorIdFuncionarioCadastrado() {
		// Busca o maior id cadastrado de funcionarios, caso não existir adiciona o 0
		// como primario.
		return getIdsFuncionarios().isEmpty() ? 1L
				: Collections.max(getIdsFuncionarios()) + 1;
	}
	
	public void salvar(Funcionario funcionario) {
		funcionarioRepository.save(funcionario);
	}
	
	public List<Funcionario> getListaFuncionarios() {
		return funcionarioRepository.findAll();
	}
	
	public List<Long> getIdsFuncionarios() {
		return funcionarioRepository.findAllIds();
	}
	
	public Optional<Funcionario> getFuncionarioPeloId(Long id) {
		return funcionarioRepository.findById(id);
	}
	
	public void excluirFuncionario(Long id) {
		funcionarioRepository.deleteById(id);
	}

}
