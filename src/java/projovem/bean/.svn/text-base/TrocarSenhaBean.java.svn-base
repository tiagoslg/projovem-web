/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package projovem.bean;

import javax.annotation.Resource;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.servlet.http.HttpSession;
import javax.transaction.UserTransaction;
import projovem.dao.UsuarioDAO;
import projovem.entity.Usuario;

/**
 *
 * @author admprojovem
 */
public class TrocarSenhaBean {

    @Resource
    private UserTransaction utx ;
    @PersistenceUnit(unitName = "projovemPU")
    private EntityManagerFactory emf;

    private UsuarioDAO dao = new UsuarioDAO();
    private Usuario usuarioLogado = new Usuario();
    private String senhaAtual;
    private String novaSenha;
    private String confirmaNovaSenha;
    private String email;
    private String nome;
    private boolean renderedCampos = true;

    public void salvar(){
        boolean podeSalvar = true;


        if(nome!=null && (nome.isEmpty() || nome.length()==0)){
            podeSalvar = false;
            String message="Campo 'Nome' é obrigatório!";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        }
        if(email !=null && (email.isEmpty() || email.length()==0)){
            podeSalvar = false;
            String message="Campo 'Email' é obrigatório!";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        }
        if(senhaAtual!=null && (senhaAtual.isEmpty() || senhaAtual.length()==0)){
            podeSalvar = false;
            String message="Campo 'Senha Atual' é obrigatório!";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        }
        if(novaSenha!=null && (novaSenha.isEmpty() || novaSenha.length()==0)){
            podeSalvar = false;
            String message="Campo 'Nova senha' é obrigatório!";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        }
        if(confirmaNovaSenha!=null && (confirmaNovaSenha.isEmpty() || confirmaNovaSenha.length()==0)){
            podeSalvar = false;
            String message="Campo 'Confirmar nova senha' é obrigatório!";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        }
        if(confirmaNovaSenha!=null && novaSenha!=null && !novaSenha.equals(confirmaNovaSenha)){
            podeSalvar = false;
            String message="A senha não corresponde com a verificação!";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        }
        if(usuarioLogado!=null && senhaAtual!=null && !usuarioLogado.getSenha().equals(String.valueOf(senhaAtual.hashCode()))){
            podeSalvar = false;
            String message="Senha Atual inválida!";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        }


        if(podeSalvar){
            Usuario usuario = usuarioLogado;
            usuario.setNome(nome);
            usuario.setEmail(email);
            usuario.setSenha(String.valueOf(novaSenha.hashCode()));
            dao.salvar(usuario,emf,utx);
            renderedCampos=false;
            String message="Usuário alterado com sucesso!";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        }
    }
    public TrocarSenhaBean(){
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
        Object currentUser = session.getAttribute("currentUser");
        if(currentUser !=null){
            usuarioLogado = (Usuario) currentUser;
            email = usuarioLogado.getEmail();
            nome = usuarioLogado.getNome();
        }
    }


    /**
     * @return the senhaAtual
     */
    public String getSenhaAtual() {
        return senhaAtual;
    }

    /**
     * @param senhaAtual the senhaAtual to set
     */
    public void setSenhaAtual(String senhaAtual) {
        this.senhaAtual = senhaAtual;
    }

    /**
     * @return the novaSenha
     */
    public String getNovaSenha() {
        return novaSenha;
    }

    /**
     * @param novaSenha the novaSenha to set
     */
    public void setNovaSenha(String novaSenha) {
        this.novaSenha = novaSenha;
    }

    /**
     * @return the confirmaNovaSenha
     */
    public String getConfirmaNovaSenha() {
        return confirmaNovaSenha;
    }

    /**
     * @param confirmaNovaSenha the confirmaNovaSenha to set
     */
    public void setConfirmaNovaSenha(String confirmaNovaSenha) {
        this.confirmaNovaSenha = confirmaNovaSenha;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the renderedCampos
     */
    public boolean isRenderedCampos() {
        return renderedCampos;
    }

    /**
     * @param renderedCampos the renderedCampos to set
     */
    public void setRenderedCampos(boolean renderedCampos) {
        this.renderedCampos = renderedCampos;
    }
}
