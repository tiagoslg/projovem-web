
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
import projovem.entity.Cep;



/**
 *
 * @author admprojovem
 */

public class CepDAO implements Serializable {

    public List<SelectItem> getAllUF(EntityManagerFactory emf) {
            EntityManager em = emf.createEntityManager();
            List<String> listUf = null;
            List<SelectItem> listaUFVO = new ArrayList<SelectItem>();

            try {


            listUf = em.createQuery("select distinct q.uf from Cep as q " +
                    " order by q.uf")
                    .getResultList();

        } finally {
            em.close();
        }
        for(String ufvo : listUf){
            SelectItem item = new SelectItem(ufvo,ufvo);
            listaUFVO.add(item);
        }
       
        return listaUFVO;
    }

    public Cep getByCep(EntityManagerFactory emf, String cepInformado) {

        EntityManager em = emf.createEntityManager();
        List<Cep> listCep = null;
        Cep cep = new Cep();

        try {
            listCep = em.createQuery("select q from Cep as q " +
                    " where q.numero=:cepInformado").setParameter("cepInformado", cepInformado)
                .getResultList();
        } finally {
            em.close();
        }

        if(listCep !=null && listCep.size()>0){
            cep = (Cep) listCep.get(0);
        }

        return cep;
    }



    
}
