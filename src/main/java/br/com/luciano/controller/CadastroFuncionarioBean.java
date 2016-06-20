package br.com.luciano.controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.UploadedFile;

import br.com.luciano.model.Funcionario;
import br.com.luciano.service.CadastroFuncionarioService;
import br.com.luciano.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroFuncionarioBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private CadastroFuncionarioService cadastro;

	private Funcionario funcionario;

	private UploadedFile fotoPessoa;

	public CadastroFuncionarioBean() {
		limpar();
	}
	
	public void inicializar() {
		if (this.funcionario == null) {
			this.limpar();
		}
		
	}
	
	public void limpar() {
		funcionario = new Funcionario();
	}

	public void salvar() {
		if (this.fotoPessoa != null && this.fotoPessoa.getContents() != null
				&& this.fotoPessoa.getContents().length > 0) {
			this.funcionario.setFoto(this.fotoPessoa.getContents());
		}
		this.cadastro.salvar(funcionario);
		
		FacesUtil.addInfoMessage("Funcionario salvo com sucesso!");
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public UploadedFile getFotoPessoa() {
		return fotoPessoa;
	}

	public void setFotoPessoa(UploadedFile fotoPessoa) {
		this.fotoPessoa = fotoPessoa;
	}

}
