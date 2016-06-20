package br.com.luciano.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.luciano.model.Pergunta;

public class Perguntas implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public Pergunta buscarPorCodigo(Long codigo) {
		return this.manager.find(Pergunta.class, codigo);
	}
	
	public Pergunta guardar(Pergunta pergunta) {
		return this.manager.merge(pergunta);
	}
	
	public List<Pergunta> buscarTodasPerguntasProfessor() {
		return this.manager.createQuery("from Pergunta where codigo <= 3", Pergunta.class).getResultList();
	}
	
	public List<Pergunta> buscarTodasPerguntasFuncionario() {
		return this.manager.createQuery("from Pergunta where codigo > 3 ", Pergunta.class).getResultList();
	}

}
