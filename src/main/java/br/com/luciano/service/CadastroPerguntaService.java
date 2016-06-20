package br.com.luciano.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.luciano.model.Pergunta;
import br.com.luciano.repository.Perguntas;
import br.com.luciano.util.Transactional;

public class CadastroPerguntaService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Perguntas perguntas;
	
	@Transactional
	public void salvar(Pergunta pergunta) {
		this.perguntas.guardar(pergunta);
	}

}
