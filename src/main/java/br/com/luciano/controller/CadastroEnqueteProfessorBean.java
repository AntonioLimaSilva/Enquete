package br.com.luciano.controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import br.com.luciano.filter.ProfessorFilter;
import br.com.luciano.model.Enquete;
import br.com.luciano.model.Pergunta;
import br.com.luciano.model.Professor;
import br.com.luciano.model.Resposta;
import br.com.luciano.model.TipoSerie;
import br.com.luciano.model.TipoTurma;
import br.com.luciano.model.TipoTurno;
import br.com.luciano.repository.Perguntas;
import br.com.luciano.repository.Professores;
import br.com.luciano.repository.Respostas;
import br.com.luciano.service.CadastroEnqueteService;
import br.com.luciano.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroEnqueteProfessorBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private CadastroEnqueteService cadastro;

	@Inject
	private Professores professoresRepository;

	@Inject
	private Perguntas perguntasRepository;

	@Inject
	private Respostas respostasRepository;

	private Professor professorSelecionado;

	private ProfessorFilter filtro;
	private Professor professor;
	private Enquete enquete;
	private List<Professor> professores;
	private List<Pergunta> perguntas;
	private List<Resposta> respostas;
	private String nome;

	private List<Professor> fotoProfessor;

	public CadastroEnqueteProfessorBean() {
		limpar();
	}

	public void limpar() {
		enquete = new Enquete();
		professores = new ArrayList<Professor>();
		perguntas = new ArrayList<Pergunta>();
		respostas = new ArrayList<Resposta>();
		filtro = new ProfessorFilter();
		nome = new String();
		fotoProfessor = new ArrayList<Professor>();
	}

	public void salvar() {
		this.cadastro.salvar(enquete);

		FacesUtil.addInfoMessage("Enquete salva com sucesso!");
	}

	@PostConstruct
	public void consultar() {
		this.perguntas = this.perguntasRepository.buscarTodasPerguntasProfessor();
		this.respostas = this.respostasRepository.buscarTodas();
		this.professores = this.professoresRepository.filtrarProfessor(filtro);

	}

	public void buscarFoto() {
		fotoProfessor = this.professoresRepository.buscarFotoProfessor("Marcelo");
		for(Professor fotos: fotoProfessor) {
			System.out.println(fotos.getFoto());
		}
		System.out.println("Foto............: " + fotoProfessor);
	}

	public Enquete getEnquete() {
		return enquete;
	}

	public void setEnquete(Enquete enquete) {
		this.enquete = enquete;
	}

	public List<Professor> getProfessores() {
		return professores;
	}

	public List<Pergunta> getPerguntas() {
		return perguntas;
	}

	public List<Resposta> getRespostas() {
		return respostas;
	}

	public ProfessorFilter getFiltro() {
		return filtro;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
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

	public Professor getProfessorSelecionado() {
		return professorSelecionado;
	}

	public void setProfessorSelecionado(Professor professorSelecionado) {
		this.professorSelecionado = professorSelecionado;
	}

	public List<Professor> getFotoProfessor() {
		return fotoProfessor;
	}
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
