package br.com.luciano.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import br.com.luciano.model.Pergunta;
import br.com.luciano.repository.Perguntas;

@FacesConverter(forClass = Pergunta.class)
public class PerguntaConverter implements Converter {

	@Inject
	private Perguntas perguntas;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		Pergunta retorno = null;

		if (value != null) {
			retorno = this.perguntas.buscarPorCodigo(new Long(value));
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		if (value != null) {
			Long codigo = ((Pergunta) value).getCodigo();
			String retorno = (codigo == null ? null : codigo.toString());

			return retorno;
		}

		return "";
	}

}