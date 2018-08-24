/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package projovem.DAO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.SelectItem;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import projovem.entity.LogAcessos;

/**
 *
 * @author tiagoslg
 */
public class LogAcessosDAO implements Serializable {

    public List<LogAcessos> getAll(EntityManagerFactory emf) {
            EntityManager em = emf.createEntityManager();
            List<LogAcessos> listaLogAcessos = new ArrayList<LogAcessos>();

            try {
            listaLogAcessos = em.createQuery("select l from ListaAcessos as l" ).getResultList();

        } finally {
            em.close();
        }


        return listaLogAcessos;
    }
    public List<LogAcessos> getAllByDatas(long dataInicial, long dataFinal, EntityManagerFactory emf) {
            EntityManager em = emf.createEntityManager();
            List<LogAcessos> listaLogAcessos = new ArrayList<LogAcessos>();

            try {
            listaLogAcessos = em.createQuery("select l from ListaAcessos as l" ).getResultList();

        } finally {
            em.close();
        }


        return listaLogAcessos;
    }

    public void saveLogAcesso(LogAcessos log, EntityManagerFactory emf, UserTransaction utx) {

        EntityManager em = emf.createEntityManager();

        try {
            utx.begin();
            em.joinTransaction();
            em.persist(log);
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
