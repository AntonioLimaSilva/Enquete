package br.com.luciano.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.luciano.model.Professor;
import br.com.luciano.repository.Professores;
import br.com.luciano.util.Transactional;

public class CadastroProfessorService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Professores professores;
	
	@Transactional
	public void salvar(Professor professor) {
		this.professores.guardar(professor);
	}

}
