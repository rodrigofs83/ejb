package com.gugawag.pdist.ejb.session;

import com.gugawag.pdist.modelo.Mensagem;
import com.gugawag.pdist.modelo.Usuario;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import java.util.List;

@Stateless
public class MensagemDAO {
    @PersistenceContext(unitName = "bd2")
    private EntityManager em;

    public void inserer (Mensagem msg){
        em.persist(msg);


    }
    public List<Mensagem> listar() {
        return em.createQuery("SELECT m FROM tb_memsagem  m").getResultList();
    }

    public Mensagem  msgByID(Long id) {
        Query query =  em.createNativeQuery("SELECT m FROM tb_memsagem  WHERE ID =?", Mensagem.class);
        query.setParameter(1, id);
        return (Mensagem) query.getSingleResult();

    }
}
