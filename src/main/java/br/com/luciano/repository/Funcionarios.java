package br.com.luciano.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.luciano.model.Funcionario;

public class Funcionarios implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public List<Funcionario> buscarTodos() {
		return this.manager.createQuery("from Funcionario", Funcionario.class).getResultList();
	}

	public Funcionario buscarPorCodigo(Long codigo) {
		return this.manager.find(Funcionario.class, codigo);
	}

	public Funcionario guardar(Funcionario funcionario) {		
		return this.manager.merge(funcionario);
	}

}
