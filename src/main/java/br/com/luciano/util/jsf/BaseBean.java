package br.com.luciano.util.jsf;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class BaseBean implements Serializable {
    private static final long serialVersionUID = -5895396595360064610L;
    protected static final String MENSAGEM_SUCESSO_GRAVACAO = "Dados gravados com sucesso";
  

    protected void infoMsg(String message) {
        FacesMessage msg = new FacesMessage(message);
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }


    protected void errorMsg(String message) {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                message, "Erro");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public String getParametro(String parametro) {
        return FacesContext.getCurrentInstance().getExternalContext()
                .getRequestParameterMap().get(parametro);
    }

}
