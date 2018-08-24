/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package projovem.dao;

import java.io.Serializable;
import java.util.List;
import projovem.entity.RespostaMaterial;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

/**
 *
 * @author admprojovem
 */

public class RespostaMaterialDAO implements Serializable {


    public void save(List<RespostaMaterial> materiais, EntityManagerFactory emf, UserTransaction utx){
            
        EntityManager em = emf.createEntityManager();
       
        try {
            utx.begin();
            em.joinTransaction();
            for (RespostaMaterial respostaMaterial : materiais) {
                if(respostaMaterial !=null){
                    em.persist(respostaMaterial);
                }
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

}
