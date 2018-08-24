/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projovem.dao;

import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import projovem.entity.Usuario;
import projovem.rotinas.CE.R004.CeRotina004;
import projovem.rotinas.R003.Rotina003Ficha;
import projovem.rotinas.R003.Rotina003;

/**
 *
 * @author admprojovem
 */
public class Rotina003DAO implements Serializable {

    public void saveRotina003(Rotina003 rotina, EntityManagerFactory emf, UserTransaction utx) {

        EntityManager em = emf.createEntityManager();

        Usuario u = new Usuario();

        try {
            utx.begin();
            em.joinTransaction();
            for (Rotina003Ficha listalRotina : rotina.getListaFichas()) {
                if (listalRotina != null) {
                    if (listalRotina.getId() == null) {
                        em.persist(listalRotina);
                    } else {
                        em.merge(listalRotina);
                    }
                }
            }

            em.joinTransaction();

            if (rotina.getId() == null) {
                rotina.setDataInsercao(u.getDataAtual());
                rotina.setHoraInsercao(u.getHoraAtual());
                em.persist(rotina);
            } else {
                rotina.setDadosEditados("1");
                rotina.setDataEdicao(u.getDataAtual());
                rotina.setHoraEdicao(u.getHoraAtual());
                em.merge(rotina);
            }

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

    public void validarDados(Rotina003 rotina, EntityManagerFactory emf, UserTransaction utx) {
        EntityManager em = emf.createEntityManager();
        try {

            utx.begin();
            em.joinTransaction();
            em.merge(rotina);
            utx.commit();

        } catch (NotSupportedException ex) {
            ex.printStackTrace();
        } catch (RollbackException ex) {
            ex.printStackTrace();
        } catch (HeuristicMixedException ex) {
            ex.printStackTrace();
        } catch (HeuristicRollbackException ex) {
            ex.printStackTrace();
        } catch (SecurityException ex) {
            ex.printStackTrace();
        } catch (IllegalStateException ex) {
            ex.printStackTrace();
        } catch (SystemException ex) {
            ex.printStackTrace();
        } finally {
            em.close();
        }
    }

    public Rotina003 getById(Integer idRotinaEscolhida, EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();
        Rotina003 rotina = null;

        try {
            rotina = (Rotina003) em.createQuery("select r from Rotina003 as r " +
                    " where r.id = :id").setParameter("id", idRotinaEscolhida).getSingleResult();
            rotina.getListaFichas().size();

        } finally {
            em.close();
        }

        return rotina;
    }
}
