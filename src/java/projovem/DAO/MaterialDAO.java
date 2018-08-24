/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package projovem.dao;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import projovem.entity.Arco;
import projovem.entity.Material;



/**
 *
 * @author admprojovem
 */

public class MaterialDAO implements Serializable {

    public List<Material> getByArco(String arco, EntityManagerFactory emf) {
            EntityManager em = emf.createEntityManager();
            List<Material> listaMaterial = new ArrayList<Material>();

            try {
            listaMaterial = em.createQuery("select m from Material as m where m.arco.nome=:arcoNome" ).setParameter("arcoNome", arco).getResultList();

        } finally {
            em.close();
        }


        return listaMaterial;
    }



    
}
