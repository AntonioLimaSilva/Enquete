package br.com.luciano.model;

public enum TipoSerie {

	PRIMEIRA_SERIE("Primeira serie"), 
	SEGUNDA_SERIE("Segunda serie"), 
	TERCEIRA_SERIE("Terceira serie"), 
	QUARTA_SERIE("Quarta serie"), 
	QUINTA_SERIE("Quinta serie");

	private String descricao;

	TipoSerie(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
