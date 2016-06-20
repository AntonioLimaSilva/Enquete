package br.com.luciano.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.luciano.model.Professor;
import br.com.luciano.repository.Professores;

@Named
@ViewScoped
public class PesquisaProfessorBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Professores professoresRepository;

	private List<Professor> professores;
	private Professor professor;

	public PesquisaProfessorBean() {
		professores = new ArrayList<Professor>();
	}

	@PostConstruct
	public void inicializar() {
		this.professores = professoresRepository.buscarTodosProfessores();
	}

	public List<Professor> getProfessores() {
		return professores;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

}
