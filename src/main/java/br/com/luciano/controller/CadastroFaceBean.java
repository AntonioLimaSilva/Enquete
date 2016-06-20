package br.com.luciano.controller;

import java.io.FileOutputStream;
import java.io.IOException;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

public class CadastroFaceBean {
    private byte[] foto;
    private StreamedContent imagem;  
    public CadastroFaceBean() {
    }    
    public StreamedContent getImagem() {        
        return imagem;
    }
    public void setImagem(StreamedContent imagem) {
        this.imagem = imagem;
    }
    public void handleFileUpload(FileUploadEvent event)throws IOException {
        //salva a imagen no StreamedContent para ser visualizada antes de salvar no disco
        imagem = new DefaultStreamedContent(event.getFile().getInputstream(), "image/jpeg", event.getFile().getFileName());          
        foto = event.getFile().getContents(); 
    }    
    public void salvar() throws Exception { 
             // salva a imagen no disco
            //passo o parametro 'foto' com o bytes gerados no momento do upload da foto
            criaArquivo(foto, "c:/foto/nomeImagen.jpg");
    }
    public void criaArquivo(byte[] bytes, String arquivo) throws IOException {
        FileOutputStream fos;        
        fos = new FileOutputStream(arquivo);
        fos.write(bytes);
        fos.close();
    }
}