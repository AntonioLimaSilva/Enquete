package br.com.luciano.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.luciano.model.Pergunta;
import br.com.luciano.model.Resposta;
import br.com.luciano.repository.Respostas;
import br.com.luciano.service.CadastroPerguntaService;
import br.com.luciano.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroPerguntaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private CadastroPerguntaService cadastro;
	
	@Inject
	private Respostas respostasRepository;

	private Pergunta pergunta;
	private List<Resposta> respostas;

	public CadastroPerguntaBean() {
		pergunta = new Pergunta();
		respostas = new ArrayList<Resposta>();
	}

	public void salvar() {
		this.cadastro.salvar(pergunta);
		
		FacesUtil.addInfoMessage("Pergunta salva com sucesso!");
	}
	
	@PostConstruct
	public void consultar() {
		this.respostas = this.respostasRepository.buscarTodas();
	}

	public Pergunta getPergunta() {
		return pergunta;
	}

	public void setPergunta(Pergunta pergunta) {
		this.pergunta = pergunta;
	}

	public List<Resposta> getRespostas() {
		return respostas;
	}

}
