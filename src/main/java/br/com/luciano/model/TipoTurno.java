package br.com.luciano.model;

public enum TipoTurno {
	
	MANHA("Manhã"),
	TARDE("Tarde"),
	NOITE("Noite");
	
    private String descricao;
	
    TipoTurno(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
