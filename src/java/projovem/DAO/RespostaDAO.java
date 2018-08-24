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
import projovem.entity.Instrumento;
import projovem.entity.Resposta;
import projovem.entity.RespostaMonovalorada;
import projovem.entity.RespostaTextual;

/**
 *
 * @author admprojovem
 */

public class RespostaDAO implements Serializable {




    public Resposta getById(Integer idResposta, EntityManagerFactory emf){

        EntityManager em = emf.createEntityManager();
        Resposta resposta = null ;
        Object respostaObtida = null;
        try {

            if(idResposta !=null){
                respostaObtida =  em.createQuery("select r from Resposta as r " +
                    "where id =  "+idResposta )
                    .getSingleResult();
            }

        } finally {
            em.close();
        }

        if(respostaObtida!=null){
            resposta = (Resposta) respostaObtida;
        }
       return resposta;
    }
    
    public List<Resposta> getByInstrumento(Instrumento instrumento, EntityManagerFactory emf){

        EntityManager em = emf.createEntityManager();
        List<Resposta> resposta = new ArrayList<Resposta>();
        try {
                resposta =  em.createQuery("select r from Resposta as r " +
                    "where r.questao.instrumento.id =  "+instrumento.getId() )
                    .getResultList();
        } finally {
            em.close();
        }


       return resposta;
    }

    public List<RespostaTextual> getRespostaTextualByQuestao(
            Integer idQuestao, EntityManagerFactory emf) {

        EntityManager em = emf.createEntityManager();
        List<RespostaTextual> resposta = null ;

        try {

            if(idQuestao !=null){
                resposta =  em.createQuery("select r from RespostaTextual as r " +
                    "where questao_id =  "+idQuestao )
                    .getResultList();
            }

        } finally {
            em.close();
        }

       return resposta;
    }

    public List<RespostaMonovalorada> getRespostaMonovaloradaByQuestao(Integer idQuestao, EntityManagerFactory emf) {

        EntityManager em = emf.createEntityManager();
        List<RespostaMonovalorada> resposta = null ;
        
        try {

            if(idQuestao !=null){
                resposta =  em.createQuery("select r from RespostaMonovalorada as r " +
                    "where questao_id =  "+idQuestao )
                    .getResultList();
            }

        } finally {
            em.close();
        }

       return resposta;
    }

    public RespostaMonovalorada getRespostasMonovaloradaComTextuais(Integer idQuestao, EntityManagerFactory emf) {

        EntityManager em = emf.createEntityManager();
        List<RespostaMonovalorada> listaResposta = null ;
        RespostaMonovalorada resposta = null ;

        try {

            if(idQuestao !=null){
                listaResposta =
                        em.createQuery("select r from RespostaMonovalorada as r " +
                    "where questao_id =  "+idQuestao
                    +" and r.respostaOpcional != null")
                    .getResultList();
            }

        } finally {
            em.close();
        }

        if(listaResposta!=null && listaResposta.size()>0){
            resposta=listaResposta.get(0);
        }
       return resposta;
    }

}
