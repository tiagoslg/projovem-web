
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projovem.dao;

import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.SystemException;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.UserTransaction;
import projovem.entity.Usuario;
import projovem.rotinas.CE.R001.CeRotina001;

/**
 *
 * @author admprojovem
 */
public class CeRotina001DAO implements Serializable {

    public void saveCeRotina001(CeRotina001 rotina, EntityManagerFactory emf, UserTransaction utx) {

        EntityManager em = emf.createEntityManager();

        Usuario u = new Usuario();

        try {
            utx.begin();
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

    public void validarDados(CeRotina001 rotina, EntityManagerFactory emf, UserTransaction utx) {
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

    public CeRotina001 getById(Integer idRotinaEscolhida, EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();
        CeRotina001 rotina = null;

        try {
            rotina = (CeRotina001) em.createQuery("select r from CeRotina001 as r " +
                    " where r.id = :id").setParameter("id", idRotinaEscolhida).getSingleResult();

        } finally {
            em.close();
        }

        return rotina;
    }
}
