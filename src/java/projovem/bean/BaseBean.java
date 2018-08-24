/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package projovem.bean;

import javax.annotation.Resource;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.transaction.UserTransaction;

/**
 *
 * @author admprojovem
 */
public class BaseBean {
    @Resource
    private UserTransaction utx ;
    @PersistenceUnit(unitName = "projovemPU")
    private EntityManagerFactory emf;

    /**
     * @return the emf
     */
    public EntityManagerFactory getEmf() {
        return emf;
    }

    /**
     * @param emf the emf to set
     */
    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }
}
