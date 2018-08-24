/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package projovem.dao;

import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import projovem.entity.Instrumento;


/**
 *
 * @author admprojovem
 */

public class InstrumentoDAO implements Serializable {
    private static final long serialVersionUID = 1L;


    

    public Instrumento getByCodigo(String codigoInstrumento, EntityManagerFactory emf){

        EntityManager em = emf.createEntityManager();
        Instrumento instrumento = null ;

        try {


            instrumento = (Instrumento) em.createQuery("select i from Instrumento as i " +
                    "where id =  "+codigoInstrumento )
                    .getSingleResult();

        } finally {
            em.close();
        }

        return instrumento;
    }

}
