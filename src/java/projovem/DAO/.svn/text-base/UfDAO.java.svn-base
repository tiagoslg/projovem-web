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
import projovem.entity.InstituicaoRegional;
import projovem.entity.UF;



/**
 *
 * @author admprojovem
 */

public class UfDAO implements Serializable {

    public List<SelectItem> getByIr(EntityManagerFactory emf, InstituicaoRegional ir) {
            EntityManager em = emf.createEntityManager();
            List<UF> listUf = null;
            List<SelectItem> listaUFVO = new ArrayList<SelectItem>();

            try {
            listUf = em.createQuery("select uf from UF as uf, InstituicaoRegional ir," +
                    " in(ir.uf) e " +
                    " where uf = e " +
                    " and ir.id =" +ir.getId()+
                    " order by uf.uf")
                    .getResultList();

        } finally {
            em.close();
        }
        for(UF ufvo : listUf){
            SelectItem item = new SelectItem(ufvo.getUf(),ufvo.getUf());
            listaUFVO.add(item);
        }

        return listaUFVO;
    }



    
}
