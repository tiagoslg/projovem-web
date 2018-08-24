/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projovem.dao;

import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import projovem.entity.MaterialUtilizado;
import projovem.entity.Usuario;
import projovem.rotinas.R006.Rotina006ArcosOcupacionais;
import projovem.rotinas.R006.Rotina006ArcosOcupacionaisMateriais;
import projovem.rotinas.R006.Rotina006ArcosQuest;
import projovem.rotinas.R006.Rotina006ArcosOcupacionaisV3;
import projovem.rotinas.R006.Rotina006CoordenacaoLocalLocais;
import projovem.rotinas.R006.Rotina006CoordenacaoLocal;

/**
 *
 * @author admprojovem
 */
public class Rotina006DAO implements Serializable {

    public void saveRotinaQPCoordenacaoLocal(Rotina006CoordenacaoLocal rotina, EntityManagerFactory emf, UserTransaction utx) {

        EntityManager em = emf.createEntityManager();

        Usuario u = new Usuario();
        
        try {
            utx.begin();
            em.joinTransaction();
            for (Rotina006CoordenacaoLocalLocais licalRotina : rotina.getListaLocais()) {
                if (licalRotina != null) {
                    em.persist(licalRotina);
                }
            }

            em.joinTransaction();
            if (rotina.getId() == null) {
                rotina.setDataInsercao(u.getDataAtual());
                rotina.setHoraInsercao(u.getHoraAtual());
                em.persist(rotina);
            } else {
                rotina.setDadosEditados("1");
                rotina.setDataEdicao(u.getDataAtual());
                rotina.setHoraEdicao(u.getHoraAtual());
                em.merge(rotina);
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

    public void validarDadosCoordenacaoLocal(Rotina006CoordenacaoLocal rotina, EntityManagerFactory emf, UserTransaction utx) {
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

    public void saveRotinaQPArcosOcupacionais(Rotina006ArcosOcupacionais rotina, EntityManagerFactory emf, UserTransaction utx) {



        EntityManager em = emf.createEntityManager();

        Usuario u = new Usuario();

        try {
            utx.begin();
            em.joinTransaction();
            for (Rotina006ArcosOcupacionaisMateriais arcoOcupacional : rotina.getQ55()) {
                if (arcoOcupacional != null) {
                    if(arcoOcupacional.getId() == null){
                    em.persist(arcoOcupacional);
                    }else{
                        em.merge(arcoOcupacional);
                    }
                }
            }

            em.joinTransaction();
            if(rotina.getId()==null){
                rotina.setDataInsercao(u.getDataAtual());
                rotina.setHoraInsercao(u.getHoraAtual());
                em.persist(rotina);
            }else{
                rotina.setDadosEditados("1");
                rotina.setDataEdicao(u.getDataAtual());
                rotina.setHoraEdicao(u.getHoraAtual());
                em.merge(rotina);
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

    public void validarDadosArcosOcupacionais(Rotina006ArcosOcupacionais rotina, EntityManagerFactory emf, UserTransaction utx) {
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

    public void saveRotinaQPArcosOcupacionaisV3(Rotina006ArcosOcupacionaisV3 rotina, EntityManagerFactory emf, UserTransaction utx) {



        EntityManager em = emf.createEntityManager();

        Usuario u = new Usuario();

        try {
            utx.begin();
            em.joinTransaction();
            if(rotina.getQuestionarioEducador() != null){
                for (Rotina006ArcosQuest questionario : rotina.getQuestionarioEducador()) {
                    if (questionario != null) {
                        if(questionario.getId() == null){
                            em.persist(questionario);
                        }else{
                            em.merge(questionario);
                        }
                    }
                }
            }

            em.joinTransaction();
            if(rotina.getId()==null){
                rotina.setDataInsercao(u.getDataAtual());
                rotina.setHoraInsercao(u.getHoraAtual());
                em.persist(rotina);
            }else{
                rotina.setDadosEditados("1");
                rotina.setDataEdicao(u.getDataAtual());
                rotina.setHoraEdicao(u.getHoraAtual());
                em.merge(rotina);
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

    public void validarDadosArcosOcupacionaisV3(Rotina006ArcosOcupacionaisV3 rotina, EntityManagerFactory emf, UserTransaction utx) {
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

    public Rotina006ArcosOcupacionais getArcosOcupacionaisById(Integer idRotinaEscolhida, EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();
        Rotina006ArcosOcupacionais rotina = null;

        try {
            rotina = (Rotina006ArcosOcupacionais) em.createQuery("select r from Rotina006ArcosOcupacionais as r " +
                    " where r.id = :id" ).setParameter("id", idRotinaEscolhida).getSingleResult();
            rotina.getQ55().size();
            rotina.getNucleoAtendido().size();
        } finally {
            em.close();
        }

        return rotina;
    }

    public Rotina006ArcosOcupacionaisV3 getArcosOcupacionaisV3ById(Integer idRotinaEscolhida, EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();
        Rotina006ArcosOcupacionaisV3 rotina = null;

        try {
            rotina = (Rotina006ArcosOcupacionaisV3) em.createQuery("select r from Rotina006ArcosOcupacionaisV3 as r " +
                    " where r.id = :id" ).setParameter("id", idRotinaEscolhida).getSingleResult();
            rotina.getQuestionarioEducador().size();
        } finally {
            em.close();
        }

        return rotina;
    }

    public Rotina006CoordenacaoLocal getCoordenacaoLocalById(Integer idRotinaEscolhida, EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();
        Rotina006CoordenacaoLocal rotina = null;

        try {
            rotina = (Rotina006CoordenacaoLocal) em.createQuery("select r from Rotina006CoordenacaoLocal as r " +
                    " where r.id = :id" ).setParameter("id", idRotinaEscolhida).getSingleResult();
rotina.getListaLocais().size();
        } finally {
            em.close();
        }

        return rotina;
    }
}
