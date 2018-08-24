package projovem.rotinas.CE.R004;


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author admprojovem
 */
public class CeRotina004DAO implements Serializable {

    public void saveCeRotina004(CeRotina004 rotina, EntityManagerFactory emf, UserTransaction utx) throws Exception {

        EntityManager em = emf.createEntityManager();

        Usuario u = new Usuario();
        rotina.setDataInsercao(u.getDataAtual());
        rotina.setHoraInsercao(u.getHoraAtual());

        try {
            utx.begin();
            em.joinTransaction();
            for (CeRotina004Ficha listalRotina : rotina.getListaFichas()) {
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
                em.persist(rotina);
            } else {
                em.merge(rotina);
            }


            utx.commit();

        } finally {
            em.close();
        }


    }

    public void validarDados(CeRotina004 rotina, EntityManagerFactory emf, UserTransaction utx) {
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

    public CeRotina004 getById(Integer idRotinaEscolhida, EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();
        CeRotina004 rotina = null;

        try {
            rotina = (CeRotina004) em.createQuery("select r from CeRotina004 as r " +
                    " where r.id = :id").setParameter("id", idRotinaEscolhida).getSingleResult();
            rotina.getListaFichas().size();

        } finally {
            em.close();
        }



        return rotina;
    }
}
