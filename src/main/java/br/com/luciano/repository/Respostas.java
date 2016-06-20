package br.com.luciano.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.luciano.model.Resposta;

public class Respostas implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public Resposta buscarPorCodigo(Long codigo) {
		return this.manager.find(Resposta.class, codigo);
	}
	
	public List<Resposta> buscarTodas() {
		return this.manager.createQuery("from Resposta", Resposta.class).getResultList();
	}

}
