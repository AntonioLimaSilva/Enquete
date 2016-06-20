package br.com.luciano.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.luciano.model.Enquete;

public class Enquetes implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public Enquete guardar(Enquete enquete) {
		return this.manager.merge(enquete);
	}
	
	public List<Enquete> buscarTodas() {
		return this.manager.createQuery("from Enquete where professor = professor", Enquete.class).getResultList();
	}
	
	/*
	public List<Professor> buscarTodosProfessores() {
		return this.manager.createQuery("from Professor", Professor.class).getResultList();
	}
	*/
	
}
