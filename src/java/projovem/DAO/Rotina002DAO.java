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
import projovem.rotinas.R002.Rotina002;
import projovem.rotinas.R002.Rotina002PerfilEducadores;
import projovem.rotinas.R002.Rotina002PerfilFormadores;

/**
 *
 * @author admprojovem
 */
public class Rotina002DAO implements Serializable {

    public void saveRotina002(Rotina002 rotina, EntityManagerFactory emf, UserTransaction utx) {

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

    public void validarDados(Rotina002 rotina, EntityManagerFactory emf, UserTransaction utx) {
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

    public void saveRotina002PerfilEducadoresBean(Rotina002PerfilEducadores rotina, EntityManagerFactory emf, UserTransaction utx) {

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

    public void validarDadosPerfilEducadores(Rotina002PerfilEducadores rotina, EntityManagerFactory emf, UserTransaction utx) {
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

    public void saveRotina002PerfilFormadoresBean(Rotina002PerfilFormadores rotina, EntityManagerFactory emf, UserTransaction utx) {

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

    public void validarDadosPerfilFormadores(Rotina002PerfilFormadores rotina, EntityManagerFactory emf, UserTransaction utx) {
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

    public Rotina002 getById(Integer idRotinaEscolhida, EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();
        Rotina002 rotina = null;

        try {
            rotina = (Rotina002) em.createQuery("select r from Rotina002 as r " +
                    " where r.id = :id").setParameter("id", idRotinaEscolhida).getSingleResult();

        } finally {
            em.close();
        }

        return rotina;
    }

    public Rotina002PerfilEducadores getPerfilEducadoresById(Integer idRotinaEscolhida, EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();
        Rotina002PerfilEducadores rotina = null;

        try {
            rotina = (Rotina002PerfilEducadores) em.createQuery("select r from Rotina002PerfilEducadores as r " +
                    " where r.id = :id").setParameter("id", idRotinaEscolhida).getSingleResult();

        } finally {
            em.close();
        }

        return rotina;
    }

    public Rotina002PerfilFormadores getPerfilFormadoresById(Integer idRotinaEscolhida, EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();
        Rotina002PerfilFormadores rotina = null;

        try {
            rotina = (Rotina002PerfilFormadores) em.createQuery("select r from Rotina002PerfilFormadores as r " +
                    " where r.id = :id").setParameter("id", idRotinaEscolhida).getSingleResult();

        } finally {
            em.close();
        }

        return rotina;
    }
}
