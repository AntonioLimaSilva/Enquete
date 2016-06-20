package br.com.luciano.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.luciano.model.Enquete;
import br.com.luciano.repository.Enquetes;

@Named
@ViewScoped
public class PesquisaEnqueteProfessorBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Enquetes enquetesRepository;
	
	private List<Enquete> enquetes;
	
	public PesquisaEnqueteProfessorBean() {
		enquetes = new ArrayList<Enquete>();
	}

	@PostConstruct
	public void consultar() {
		this.enquetes = this.enquetesRepository.buscarTodas();
	}
	
	public List<Enquete> getEnquetes() {
		return enquetes;
	}
	
}
