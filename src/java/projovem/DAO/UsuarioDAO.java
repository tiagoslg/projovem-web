
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projovem.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.http.HttpSession;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import projovem.entity.Usuario;

/**
 *
 * @author admprojovem
 */
public class UsuarioDAO implements Serializable {

    private static final long serialVersionUID = 1L;

    public Usuario getByLoginAndSenha(EntityManagerFactory emf, String login, String senha) {
        EntityManager em = emf.createEntityManager();
        int senhaMD5 = senha.hashCode();
        Usuario usuario = null;
        List<Usuario> listaUsuario = new ArrayList<Usuario>();
        try {
            listaUsuario = em.createQuery("select q from Usuario as q " +
                    " where q.cpf =  '" + login + "' " + " and q.senha='" + senhaMD5 + "' ").getResultList();

        } finally {
            em.close();
        }
        if (listaUsuario != null && listaUsuario.size() > 0) {
            usuario = listaUsuario.get(0);
        }
        return usuario;
    }

    public Usuario getByLogin(EntityManagerFactory emf, String login) {
        EntityManager em = emf.createEntityManager();
        Usuario usuario = null;
        List<Usuario> listaUsuario = new ArrayList<Usuario>();
        try {
            listaUsuario = em.createQuery("select q from Usuario as q " +
                    " where q.cpf =  '" + login + "'").getResultList();

        } finally {
            em.close();
        }
        if (listaUsuario != null && listaUsuario.size() > 0) {
            usuario = listaUsuario.get(0);
        }
        return usuario;
    }

    public Usuario getById(EntityManagerFactory emf, Integer id) {
        EntityManager em = emf.createEntityManager();
        Usuario usuario = null;
        List<Usuario> listaUsuario = new ArrayList<Usuario>();
        try {
            listaUsuario = em.createQuery("select q from Usuario as q " +
                    " where q.id =  " + id ).getResultList();

        } finally {
            em.close();
        }
        if (listaUsuario != null && listaUsuario.size() > 0) {
            usuario = listaUsuario.get(0);
        }
        return usuario;
    }

    public List<SelectItem>  getByIr(EntityManagerFactory emf, String ir) {
        EntityManager em = emf.createEntityManager();

        List<Usuario> listaUsuario = new ArrayList<Usuario>();
        List<SelectItem> listaUsuarioRetorno = new ArrayList<SelectItem>();
        try {
            listaUsuario = em.createQuery("select q from Usuario as q " +
                    " where q.ir =  '" + ir + "' order by q.nome").getResultList();

        } finally {
            em.close();
        }
        for (Usuario usuario : listaUsuario) {
            SelectItem item = new SelectItem(usuario.getNome(), usuario.getNome());
            listaUsuarioRetorno.add(item);
        }
        return listaUsuarioRetorno;
    }

    public List<SelectItem>  getByIrAndPerfil(EntityManagerFactory emf, String ir) {
        EntityManager em = emf.createEntityManager();

        List<Usuario> listaUsuario = new ArrayList<Usuario>();
        List<SelectItem> listaUsuarioRetorno = new ArrayList<SelectItem>();
        try {
            listaUsuario = em.createQuery("select q from Usuario as q " +
                    " where q.ir =  '" + ir + "' and q.perfil = 4 order by q.nome").getResultList();

        } finally {
            em.close();
        }
        for (Usuario usuario : listaUsuario) {
            SelectItem item = new SelectItem(usuario.getNome(), usuario.getNome());
            listaUsuarioRetorno.add(item);
        }
        return listaUsuarioRetorno;
    }

    public List<Usuario> getAll(EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();

        List<Usuario> listaUsuario = new ArrayList<Usuario>();
        try {
            listaUsuario = em.createQuery("select q from Usuario as q ").getResultList();

        } finally {
            em.close();
        }

        return listaUsuario;
    }

    public Usuario getUsuarioLogado() {

        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
        Usuario currentUser = (Usuario) session.getAttribute("currentUser");
        return currentUser;
    }

    public void salvar(Usuario usuario, EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();
        try {
            em.joinTransaction();
            em.merge(usuario);
            em.flush();

        } finally {
            em.close();
        }

    }

    public void salvar(Usuario usuario, EntityManagerFactory emf, UserTransaction utx) {
        EntityManager em = emf.createEntityManager();
        try {

            utx.begin();
            em.joinTransaction();
            em.merge(usuario);
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
}
