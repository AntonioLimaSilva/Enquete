package br.com.luciano.controller;

import java.io.ByteArrayInputStream;
import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import br.com.luciano.model.Pessoa;

@Named
@SessionScoped
public class FotoPessoaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Pessoa pessoaSelecionada;
	
	public StreamedContent getFoto() {
		DefaultStreamedContent content = null;
		
		if (this.pessoaSelecionada != null && this.pessoaSelecionada.getFoto() != null
				&& this.pessoaSelecionada.getFoto().length > 0) {
			byte[] imagem = this.pessoaSelecionada.getFoto();
			content = new DefaultStreamedContent(new ByteArrayInputStream(imagem), "images/jpg", "pessoa.jpg");
		}
		
		return content;
	}

	public Pessoa getPessoaSelecionada() {
		return pessoaSelecionada;
	}

	public void setPessoaSelecionada(Pessoa pessoaSelecionada) {
		this.pessoaSelecionada = pessoaSelecionada;
	}

}
