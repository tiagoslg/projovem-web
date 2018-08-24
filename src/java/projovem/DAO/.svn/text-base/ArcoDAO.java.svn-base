/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package projovem.dao;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.SelectItem;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import projovem.entity.Arco;
import projovem.entity.UF;



/**
 *
 * @author admprojovem
 */

public class ArcoDAO implements Serializable {

    public List<Arco> getAll(EntityManagerFactory emf) {
            EntityManager em = emf.createEntityManager();
            List<Arco> listaArco = new ArrayList<Arco>();

            try {
            listaArco = em.createQuery("select a from Arco as a" ).getResultList();

        } finally {
            em.close();
        }


        return listaArco;
    }



    
}
