package br.com.luciano.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import br.com.luciano.model.Funcionario;
import br.com.luciano.repository.Funcionarios;

@FacesConverter(forClass = Funcionario.class)
public class FuncionarioConverter implements Converter {

	@Inject
	private Funcionarios funcionarios;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		Funcionario retorno = null;

		if (value != null) {
			retorno = this.funcionarios.buscarPorCodigo(new Long(value));
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		if (value != null) {
			Long codigo = ((Funcionario) value).getCodigo();
			String retorno = (codigo == null ? null : codigo.toString());

			return retorno;
		}

		return "";
	}

}