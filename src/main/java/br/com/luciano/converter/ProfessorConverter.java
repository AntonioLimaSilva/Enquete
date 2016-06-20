package br.com.luciano.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import br.com.luciano.model.Professor;
import br.com.luciano.repository.Professores;

@FacesConverter(forClass = Professor.class)
public class ProfessorConverter implements Converter {

	@Inject
	private Professores professores;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		Professor retorno = null;

		if (value != null) {
			retorno = this.professores.buscarPorCodigo(new Long(value));
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		if (value != null) {
			Long codigo = ((Professor) value).getCodigo();
			String retorno = (codigo == null ? null : codigo.toString());

			return retorno;
		}

		return "";
	}

}