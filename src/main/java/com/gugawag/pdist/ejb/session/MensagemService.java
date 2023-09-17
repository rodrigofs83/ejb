package com.gugawag.pdist.ejb.session;

import com.gugawag.pdist.modelo.Mensagem;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

import java.util.List;

@Stateless(name = "mensagemService")
public class MensagemService {
    @EJB
    private MensagemDAO mensagemDAO;
    public void insere(Long id ,String text){
        Mensagem msg  = new Mensagem(id ,text);
        this.mensagemDAO.inserer(msg);
    }
    public List<Mensagem> list(){
        return this.mensagemDAO.listar();
    }
    public  Mensagem getByID(Long id){
        return this.mensagemDAO.msgByID(id);
    }

}
