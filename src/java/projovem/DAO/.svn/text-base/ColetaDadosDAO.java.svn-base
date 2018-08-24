/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package projovem.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import projovem.entity.ColetaDados;
import projovem.entity.Local;
import projovem.entity.Resposta;
import projovem.entity.RespostaDada;
import projovem.entity.Usuario;


/**
 *
 * @author admprojovem
 */

public class ColetaDadosDAO implements Serializable {

    public ColetaDados getById(ColetaDados coletaSelecionada, EntityManagerFactory emf) {
            EntityManager em = emf.createEntityManager();
            ColetaDados coletaDados = new ColetaDados();

            try {
            coletaDados = (ColetaDados) em.createQuery("select q from ColetaDados as q " +
                    " where q.id =:coletaSelecionada")
                    .setParameter("coletaSelecionada", coletaSelecionada.getId())
                    .getSingleResult();
        } finally {
            em.close();
        }


        return coletaDados;
    }

    public List<ColetaDados> getByInstrumento(Integer codigoInstrumento, EntityManagerFactory emf) {
            EntityManager em = emf.createEntityManager();
            List<ColetaDados> listCoeltaDados = new ArrayList<ColetaDados>();

            try {


            listCoeltaDados = em.createQuery("select q from ColetaDados as q " +
                    " where q.instrumento.id =:codigoInstrumento")
                    .setParameter("codigoInstrumento", codigoInstrumento)
                    .getResultList();

        } finally {
            em.close();
        }


        return listCoeltaDados;
    }

    public List<ColetaDados> getByInstrumentoAndDataMenorQue(int i, String string, EntityManagerFactory emf) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
    public List<ColetaDados> getByMunicipio(String municipio, EntityManagerFactory emf) {
            EntityManager em = emf.createEntityManager();
            List<ColetaDados> listCoeltaDados = new ArrayList<ColetaDados>();

            try {


            listCoeltaDados = em.createQuery("select q from ColetaDados as q " +
                    " where q.enderecoLocal.cep.cidade =:municipio")
                    .setParameter("municipio", municipio)
                    .getResultList();

        } finally {
            em.close();
        }


        return listCoeltaDados;
    }

    public List<ColetaDados> getByUsuario(Usuario usuarioLogado, EntityManagerFactory emf) {
          EntityManager em = emf.createEntityManager();
            List<ColetaDados> listCoeltaDados = new ArrayList<ColetaDados>();

        try {
            listCoeltaDados = em.createQuery("select q from ColetaDados as q " +
                    " where q.usuario =:usuarioLogado")
                    .setParameter("usuarioLogado", usuarioLogado)
                    .getResultList();

        } finally {
            em.close();
        }
        LocalDAO localDAO = new LocalDAO();
        for (ColetaDados coletaDados : listCoeltaDados) {
            Integer enderecoId = coletaDados.getEnderecoLocal().getId();
            Local local = localDAO.getByEnderecoId(emf, enderecoId);
            coletaDados.setLocal(local);
        }


        return listCoeltaDados;
    }

    public RespostaDada getByIdAndReposta(ColetaDados coleta,Resposta resposta, EntityManagerFactory emf) {
          EntityManager em = emf.createEntityManager();
            List<ColetaDados> listCoeltaDados = new ArrayList<ColetaDados>();
            RespostaDada retorno = new RespostaDada();

        try {
            listCoeltaDados = em.createQuery("select q from ColetaDados as q " +
                    " where q.id =:coleta ")
                    .setParameter("coleta", coleta.getId())
                    .getResultList();

        } finally {
            em.close();
        }
        
        for (ColetaDados coletaDados : listCoeltaDados) {
            List<RespostaDada> listaResposta = coletaDados.getRespostasDadas();
            for (RespostaDada respostaDada : listaResposta) {
                if(respostaDada !=null && respostaDada.getResposta() !=null &&
                        respostaDada.getResposta().getId().equals(resposta.getId())){
                    retorno = respostaDada;
                }
            }
        }

        return retorno;
    }


    public void saveColetaDados(ColetaDados coletaDados, EntityManagerFactory emf, UserTransaction utx){
            
        EntityManager em = emf.createEntityManager();
       
        try {
            utx.begin();
            em.joinTransaction();
            for(RespostaDada respostaDada:coletaDados.getRespostasDadas()){
                if(respostaDada !=null){
                    em.persist(respostaDada);
                }
            }
            
            em.persist(coletaDados);


            utx.commit();

        } catch (Exception e) {
            e.printStackTrace();
            try {
                utx.rollback();
            } catch (IllegalStateException ex) {
                ex.printStackTrace();
            } catch (SecurityException ex) {
                ex.printStackTrace();
            } catch (SystemException ex) {
                ex.printStackTrace();
            }
        } finally {
            em.close();
        }

        
    }

}
