package br.com.luciano.controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.luciano.model.Enquete;
import br.com.luciano.service.CadastroEnqueteService;

@Named
@ViewScoped
public class CadastroEnqueteBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private CadastroEnqueteService cadastro;

	private Enquete enquete;

	public CadastroEnqueteBean() {
		enquete = new Enquete();
	}

	public void salvar() {
		this.cadastro.salvar(enquete);
	}

	public Enquete getEnquete() {
		return enquete;
	}

	public void setEnquete(Enquete enquete) {
		this.enquete = enquete;
	}

}
