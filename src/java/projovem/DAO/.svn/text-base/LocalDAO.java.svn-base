/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package projovem.dao;


import javax.transaction.UserTransaction;
import projovem.vo.LocalVO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.SelectItem;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import projovem.entity.Endereco;
import projovem.entity.Local;


/**
 *
 * @author admprojovem
 */

public class LocalDAO implements Serializable {

    public List<SelectItem> getByUfAndTipoLocal(EntityManagerFactory emf, String ufFiltrada, String aplicadoEmLocaisDoTipo) {
            EntityManager em = emf.createEntityManager();
            List<String> listCidades;
            List<SelectItem> listCidade = new ArrayList<SelectItem>();
            try {


            listCidades = em.createQuery("select distinct e.cep.cidade from Local as q, " +
                    " in(q.enderecos) e "
                    +" where e.cep.uf='"+ufFiltrada+"' " +
                    " and q.tipoLocal =  '"+aplicadoEmLocaisDoTipo+"' " +
                    " order by e.cep.cidade")
                    .getResultList();

        } finally {
            em.close();
        }
        for(String local : listCidades){
            SelectItem item = new SelectItem(local,local);
            listCidade.add(item);
        }
        return listCidade;
    }

    public Local getByEnderecoId(EntityManagerFactory emf, Integer EnderecoId) {
            EntityManager em = emf.createEntityManager();
            Local local = new Local();

            try {
            local = (Local) em.createQuery("select q from Local as q, " +
                    " in(q.enderecos) e " +
                    " where e.id=:EnderecoId")
                    .setParameter("EnderecoId", EnderecoId)
                    .getSingleResult();

        } finally {
            em.close();
        }


        return local;
    }

    public List<LocalVO> getByCidadeAndTipoLocal(EntityManagerFactory emf, String aplicadoEmLocaisDoTipo, String cidadeFiltrada) {
            EntityManager em = emf.createEntityManager();
            List<Local> listLocais;
            List<LocalVO> listLocalVO = new ArrayList<LocalVO>();
            try {


            listLocais = em.createQuery("select q from Local as q, " +
                    " in(q.enderecos) e " +
                    " where q.tipoLocal =  '"+aplicadoEmLocaisDoTipo+"' "
                    +" and e.cep.cidade='"+cidadeFiltrada+"' ")
                    .getResultList();

        } finally {
            em.close();
        }
        for(Local local : listLocais){
            List<Endereco> enderecos = new ArrayList<Endereco>();
            
            enderecos = local.getEnderecos();
            for(Endereco endereco : enderecos){
                LocalVO  localVO = new LocalVO();
                localVO.setCodigo(local.getCodigo());
                localVO.setId(local.getId());
                localVO.setNome(local.getNome());
                localVO.setTipoLocal(local.getTipoLocal());
                localVO.setEndereco(endereco);
                listLocalVO.add(localVO);
            }
        }
        return listLocalVO;
    }

    public void salvar(EntityManagerFactory emf, UserTransaction utx, Local local) {
        EntityManager em = emf.createEntityManager();

        try {
            utx.begin();
            em.joinTransaction();

            for(Endereco endereco:local.getEnderecos()){
                if(endereco !=null){
                    endereco.setLocal(local);
                    if(endereco.getId() !=null){
                        em.merge(endereco.getCep());
                        em.merge(endereco);
                    }else{
                        em.persist(endereco.getCep());
                        em.persist(endereco);
                    }
                }
            }
            if(local !=null){
                if(local.getId()!=null){
                    em.merge(local);
                }else{
                    em.persist(local);
                }
                
            }

            utx.commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
    }



    
}
