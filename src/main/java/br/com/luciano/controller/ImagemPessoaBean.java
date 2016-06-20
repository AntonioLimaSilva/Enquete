package br.com.luciano.controller;


import java.io.ByteArrayInputStream;
import java.io.InputStream;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import br.com.luciano.model.Professor;
import br.com.luciano.repository.Professores;
import br.com.luciano.util.jsf.BaseBean;

@ManagedBean
@RequestScoped
public class ImagemPessoaBean extends BaseBean {
    private static final long serialVersionUID = -7524476303834771432L;
    private Professor professor;

    @PostConstruct
    public void init() {
    	professor = new Professor();
    }

    public StreamedContent getConteudoImagem() {
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
                return new DefaultStreamedContent();
            }
            String idS = getParametro("codigo");
            Long codigo = Long.parseLong(idS);
            professor = (Professor) new Professores().findById(Professor.class, codigo);
            InputStream is = new ByteArrayInputStream(professor.getFoto());
            DefaultStreamedContent dsc = new DefaultStreamedContent(is);
            return dsc;
        } catch (Exception e) {
            return new DefaultStreamedContent();
        }
    }

}
