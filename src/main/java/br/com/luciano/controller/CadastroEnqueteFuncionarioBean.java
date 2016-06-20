package br.com.luciano.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.luciano.model.Enquete;
import br.com.luciano.model.Funcionario;
import br.com.luciano.model.Pergunta;
import br.com.luciano.model.Resposta;
import br.com.luciano.repository.Funcionarios;
import br.com.luciano.repository.Perguntas;
import br.com.luciano.repository.Respostas;
import br.com.luciano.service.CadastroEnqueteService;
import br.com.luciano.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroEnqueteFuncionarioBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private CadastroEnqueteService cadastro;
	
	@Inject
	private Funcionarios funcionariosRepository;
	
	@Inject
	private Perguntas perguntasRepository;

	@Inject
	private Respostas respostasRepository;	
	
	private List<Funcionario> funcionarios;
	private List<Pergunta> perguntas;
	private List<Resposta> respostas;
	private Enquete enquete;

	public CadastroEnqueteFuncionarioBean() {
		limpar();
	}
	
	public void limpar() {
		enquete = new Enquete();
		funcionarios = new ArrayList<Funcionario>();
		perguntas = new ArrayList<Pergunta>();
		respostas = new ArrayList<Resposta>();
	}
	
	public void salvar() {
		this.cadastro.salvar(enquete);
		
		FacesUtil.addInfoMessage("Enquete de funcionário salva com sucesso!");
	}
	
	@PostConstruct
	public void consultar() {
		this.perguntas = this.perguntasRepository.buscarTodasPerguntasFuncionario();
		this.respostas = this.respostasRepository.buscarTodas();
		this.funcionarios = this.funcionariosRepository.buscarTodos();
	}
	
	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}
	
	public List<Pergunta> getPerguntas() {
		return perguntas;
	}

	public List<Resposta> getRespostas() {
		return respostas;
	}

	public Enquete getEnquete() {
		return enquete;
	}

	public void setEnquete(Enquete enquete) {
		this.enquete = enquete;
	}

}
