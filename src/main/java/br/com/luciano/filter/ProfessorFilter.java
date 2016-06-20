package br.com.luciano.filter;

import br.com.luciano.model.TipoSerie;
import br.com.luciano.model.TipoTurma;
import br.com.luciano.model.TipoTurno;

public class ProfessorFilter {

	private Long codigo;
	private TipoSerie[] tipoSeries;
	private TipoTurma[] tipoTurmas;
	private TipoTurno[] tipoTurnos;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public TipoSerie[] getTipoSeries() {
		return tipoSeries;
	}

	public void setTipoSeries(TipoSerie[] tipoSeries) {
		this.tipoSeries = tipoSeries;
	}

	public TipoTurma[] getTipoTurmas() {
		return tipoTurmas;
	}

	public void setTipoTurmas(TipoTurma[] tipoTurmas) {
		this.tipoTurmas = tipoTurmas;
	}

	public TipoTurno[] getTipoTurnos() {
		return tipoTurnos;
	}

	public void setTipoTurnos(TipoTurno[] tipoTurnos) {
		this.tipoTurnos = tipoTurnos;
	}


}
