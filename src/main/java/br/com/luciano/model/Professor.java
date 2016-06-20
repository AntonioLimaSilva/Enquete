package br.com.luciano.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@DiscriminatorValue("PROFESSOR")
public class Professor extends Pessoa {

	private String nomeMateria;
	private TipoSerie tipoSerie;
	private TipoTurma tipoTurma;
	private TipoTurno tipoTurno;

	@NotBlank
	@Column(name = "nome_materia")
	public String getNomeMateria() {
		return nomeMateria;
	}

	public void setNomeMateria(String nomeMateria) {
		this.nomeMateria = nomeMateria;
	}

	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_serie", length = 30)
	public TipoSerie getTipoSerie() {
		return tipoSerie;
	}

	public void setTipoSerie(TipoSerie tipoSerie) {
		this.tipoSerie = tipoSerie;
	}

	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_turma", length = 10)
	public TipoTurma getTipoTurma() {
		return tipoTurma;
	}

	public void setTipoTurma(TipoTurma tipoTurma) {
		this.tipoTurma = tipoTurma;
	}

	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_turno", length = 20)
	public TipoTurno getTipoTurno() {
		return tipoTurno;
	}

	public void setTipoTurno(TipoTurno tipoTurno) {
		this.tipoTurno = tipoTurno;
	}

}
