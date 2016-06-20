package br.com.luciano.service;

import java.io.Serializable;
import java.util.Date;

import javax.inject.Inject;

import br.com.luciano.model.Enquete;
import br.com.luciano.repository.Enquetes;
import br.com.luciano.util.Transactional;

public class CadastroEnqueteService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Enquetes enquetes;

	@Transactional
	public void salvar(Enquete enquete) {
		//enquete.setTipoSerie(filtro.getTipoSeries());
		enquete.setDataAtual(new Date());
		this.enquetes.guardar(enquete);

	}

}
