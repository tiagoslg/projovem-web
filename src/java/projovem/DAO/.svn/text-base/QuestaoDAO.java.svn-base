/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package projovem.dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import projovem.entity.Instrumento;
import projovem.entity.Questao;

/**
 *
 * @author admprojovem
 */

public class QuestaoDAO implements Serializable {
    


    

    public List<Questao> getByInstrumento(Instrumento instrumento, EntityManagerFactory emf){

        EntityManager em = emf.createEntityManager();
        List<Questao> questoes = null ;
        List<Questao> listQuestoes;
        try {


            listQuestoes = em.createQuery("select q from Questao as q " +
                    "where instrumento_id =  "+instrumento.getId() +" order by numero")
                    .getResultList();

        } finally {
            em.close();
        }
        if(listQuestoes !=null && listQuestoes.size()>0){
            questoes = listQuestoes;
        }
        return questoes;
    }

    public Questao getByInstrumentoAndNumeroQuestao(String acao, Questao proximaQuestao,
            EntityManagerFactory emf){

        EntityManager em = emf.createEntityManager();
        Questao questao = null ;
        int idInstrumento = proximaQuestao.getInstrumento().getId();
        int numeroQuestao = proximaQuestao.getNumero();
        String ordenacao    = "";
        String sinal        = "";
        if(acao.equals("PROXIMO")){
            ordenacao   = " ASC ";
            sinal       = ">";
        }
        if(acao.equals("ANTERIOR")){
            ordenacao   = " DESC ";
            sinal       = "<";
        }
        if(acao.equals("NAVEGACAO")){
            ordenacao   = " ";
            sinal       = "=";
        }

        try {


            questao = (Questao) em.createQuery("select q from Questao as q " +
                    "where instrumento_id =  "+idInstrumento +
                    " and numero  "+sinal+numeroQuestao+" order by numero "+ ordenacao).setMaxResults(1)
                    .getSingleResult();

        } finally {
            em.close();
        }

       return questao;
    }

}
