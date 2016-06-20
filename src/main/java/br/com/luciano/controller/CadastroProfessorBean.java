package br.com.luciano.controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.UploadedFile;

import br.com.luciano.model.Professor;
import br.com.luciano.model.TipoSerie;
import br.com.luciano.model.TipoTurma;
import br.com.luciano.model.TipoTurno;
import br.com.luciano.service.CadastroProfessorService;
import br.com.luciano.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroProfessorBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private CadastroProfessorService cadastro;

	private Professor professor;

	private UploadedFile fotoPessoa;

	public void inicializar() {
		if (this.professor == null) {
			this.limpar();
		}
	}

	public CadastroProfessorBean() {
		limpar();
	}

	public void limpar() {
		professor = new Professor();
	}

	public void salvar() {
		if (this.fotoPessoa != null && this.fotoPessoa.getContents() != null
			&& this.fotoPessoa.getContents().length > 0) {
			this.professor.setFoto(this.fotoPessoa.getContents());
		}
		this.cadastro.salvar(professor);
		FacesUtil.addInfoMessage("Cadastro salvo com sucesso.");
	}

	public TipoSerie[] getTipoSeries() {
		return TipoSerie.values();
	}
	
	public TipoTurma[] getTipoTurmas() {
		return TipoTurma.values();
	}
	
	public TipoTurno[] getTipoTurnos() {
		return TipoTurno.values();
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public UploadedFile getFotoPessoa() {
		return fotoPessoa;
	}

	public void setFotoPessoa(UploadedFile fotoPessoa) {
		this.fotoPessoa = fotoPessoa;
	}

}
