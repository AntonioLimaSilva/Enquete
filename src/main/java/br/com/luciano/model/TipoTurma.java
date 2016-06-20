package br.com.luciano.model;

public enum TipoTurma {
	
	UMA("Uma"),
	DOIS("Dois"),
	TRES("Três");
	
	private String descricao;
	
	TipoTurma(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
