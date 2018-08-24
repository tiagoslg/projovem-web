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
import projovem.entity.MaterialUtilizado;
import projovem.entity.Usuario;
import projovem.nucleo.Nucleo;
import projovem.rotinas.CE.R003.CeRotina003;
import projovem.entity.MaterialUtilizado;

/**
 *
 * @author admprojovem
 */
public class CeRotina003DAO implements Serializable {

    public void saveCeRotina003(CeRotina003 rotina, EntityManagerFactory emf, UserTransaction utx) {

        EntityManager em = emf.createEntityManager();

        Usuario u = new Usuario();

        try {
            utx.begin();
            em.joinTransaction();

            if (!rotina.getMaterialUtilizado().equals(null)){
                for (MaterialUtilizado material : rotina.getMaterialUtilizado()) {
                    if (material != null) {
                        if (material.getId() == null) {
                            em.persist(material);
                        } else {
                            em.merge(material);
                        }
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

    public void validarDados(CeRotina003 rotina, EntityManagerFactory emf, UserTransaction utx) {
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

    public CeRotina003 getById(Integer idRotinaEscolhida, EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();
        CeRotina003 rotina = null;

        try {
            rotina = (CeRotina003) em.createQuery("select r from CeRotina003 as r " +
                    " where r.id = :id").setParameter("id", idRotinaEscolhida).getSingleResult();
            rotina.getMaterialUtilizado().size();
            rotina.getNucleoAtendido().size();

        } finally {
            em.close();
        }

        return rotina;
    }

    public MaterialUtilizado getMaterialByIdCeRotina003(Integer idRotinaEscolhida, EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();
        CeRotina003 rotina = null;
        MaterialUtilizado material = null;

        try {
            rotina = (CeRotina003) em.createQuery("select r from CeRotina003 as r " +
                    " where r.id = :id").setParameter("id", idRotinaEscolhida).getSingleResult();

        } finally {
            em.close();
        }

        material = (MaterialUtilizado) rotina.getMaterialUtilizado();
        return material;
    }
}
