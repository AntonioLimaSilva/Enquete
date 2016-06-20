package br.com.luciano.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.luciano.model.Funcionario;
import br.com.luciano.repository.Funcionarios;
import br.com.luciano.util.Transactional;

public class CadastroFuncionarioService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Funcionarios funcionarios;
	
	@Transactional
	public void salvar(Funcionario funcionario) {
		this.funcionarios.guardar(funcionario);
	}

}
