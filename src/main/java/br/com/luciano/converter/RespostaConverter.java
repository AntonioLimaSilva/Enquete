package br.com.luciano.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import br.com.luciano.model.Resposta;
import br.com.luciano.repository.Respostas;

@FacesConverter(forClass = Resposta.class)
public class RespostaConverter implements Converter {

	@Inject
	private Respostas respostas;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		Resposta retorno = null;

		if (value != null) {
			retorno = this.respostas.buscarPorCodigo(new Long(value));
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		if (value != null) {
			Long codigo = ((Resposta) value).getCodigo();
			String retorno = (codigo == null ? null : codigo.toString());

			return retorno;
		}

		return "";
	}

}