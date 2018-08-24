/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projovem.bean;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.Serializable;
import javax.annotation.Resource;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.servlet.http.HttpSession;
import javax.transaction.UserTransaction;
import projovem.dao.UsuarioDAO;
import projovem.entity.Usuario;
import projovem.filter.TesteEmail;

/**
 *
 * @author admprojovem
 */
public class LoginBean implements Serializable {

    @Resource
    private UserTransaction utx;
    @PersistenceUnit(unitName = "projovemPU")
    private EntityManagerFactory emf;
    private String cpf;
    private String senha;
    private boolean isLogin;
    private boolean renderedLogin = true;
    private boolean renderedEnviarSenha;
    UsuarioDAO usuarioDAO = new UsuarioDAO();
    private Integer hash;

    public void esqueciSenha() {
        renderedLogin = false;
        renderedEnviarSenha = true;
    }

    public String sair() {

        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);


        session.setAttribute("currentUser", null);
        return "index";
    }

    public void gerarHash(){
        hash = cpf.hashCode();
    }
    public void solicitarNovaSenha() {
        TesteEmail t = new TesteEmail();

        if (cpf != null && !cpf.isEmpty()) {
            Usuario usuario = usuarioDAO.getByLogin(emf, cpf);
            usuario.setSenha(String.valueOf(usuario.getCpf().hashCode()));


            System.out.println("nome" + usuario.getNome());
            t.setEmailSubjectTxt("[Sistema de Monitoramento do ProJovem Urbano] Senha de acesso temprorário.");
            String mensagem = "Prezado(a) Supervisor(a)  " + usuario.getNome() + "\n\n\n";
            mensagem += "Sua nova senha para acessar o Sistema de Monitoramento do ProJovem Urbano é: \n\n";
            mensagem += usuario.getCpf();
            mensagem += "\n\n Atenciosamente";
            mensagem += "\n\n Marisa R T Duarte";
            usuarioDAO.salvar(usuario, emf, utx);
            t.setEmailMsgTxt(mensagem);
            String[] destinatario = {usuario.getEmail()};
            t.setEmailList(destinatario);
            try {
                t.enviar();
            } catch (Exception ex) {
                Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
            }
            /* EnviaEmail mail = new EnviaEmail();
            setEmailSubjectTxt("[Sistema de Monitoramento do ProJovem Urbano] Senha de acesso temprorário.");
            String mensagem = "Prezado(a) Supervisor(a)  "+usuario.getNome()+"\n\n\n";
            mensagem+= "Sua nova senha para acessar o Sistema de Monitoramento do ProJovem Urbano é: \n\n";
            mensagem+= usuario.getCpf();
            mensagem+= "\n\n Atenciosamente";
            mensagem+= "\n\n Marisa R T Duarte";

            setEmailMsgTxt(mensagem);
            String[] destinatario = {usuario.getEmail()};
            setEmailList(destinatario);
            enviar();*/

            String message = "Sua senha foi enviada por email.";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
            renderedLogin = false;
            renderedEnviarSenha = true;
        } else {
            String message = "Informe o CPF.";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        }
    }

    public String validarUsuario() {

        String retorno = null;

        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);


        if (senha != null && !senha.isEmpty() &&
                cpf != null && !cpf.isEmpty()) {
            Usuario usuario = usuarioDAO.getByLoginAndSenha(emf, cpf, senha);
            if (usuario != null && usuario.getId() != null) {
                Usuario currentUser = usuario;
                session.setAttribute("currentUser", currentUser);
                retorno = "index";
            }

        }
        if (retorno == null) {
            String message = "Usuário ou senha inválidos!";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        }
        return retorno;
    }

    /**
    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * @return the isLogin
     */
    public boolean isIsLogin() {
        return isLogin;
    }

    /**
     * @param isLogin the isLogin to set
     */
    public void setIsLogin(boolean isLogin) {
        this.isLogin = isLogin;
    }

    /**
     * @return the renderedLogin
     */
    public boolean isRenderedLogin() {
        return renderedLogin;
    }

    /**
     * @param renderedLogin the renderedLogin to set
     */
    public void setRenderedLogin(boolean renderedLogin) {
        this.renderedLogin = renderedLogin;
    }

    /**
     * @return the renderedEnviarSenha
     */
    public boolean isRenderedEnviarSenha() {
        return renderedEnviarSenha;
    }

    /**
     * @param renderedEnviarSenha the renderedEnviarSenha to set
     */
    public void setRenderedEnviarSenha(boolean renderedEnviarSenha) {
        this.renderedEnviarSenha = renderedEnviarSenha;
    }
    private static final String SMTP_HOST_NAME = "gmail-smtp.l.google.com";
    private static final String SMTP_AUTH_USER = "desenvolvimento.projovem@gmail.com";
    private static final String SMTP_AUTH_PWD = "projovem";
    private static final String emailFromAddress = "desenvolvimento.projovem@gmail.com";
    private String[] emailList;
    private String emailSubjectTxt;
    private String emailMsgTxt;

    public void enviar() {
        try {
            postMail(getEmailList(), getEmailSubjectTxt(), getEmailMsgTxt(), emailFromAddress);
        } catch (MessagingException ex) {
            ex.printStackTrace();
        }
    }

    public void postMail(String recipients[], String subject, String message,
            String from) throws MessagingException {
        boolean debug = false;
        java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());

        //Set the host smtp address
        Properties props = new Properties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "gmail-smtp.l.google.com");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.user", SMTP_AUTH_USER);
        props.put("mail.debug", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.fallback", "false");

        Authenticator auth = new SMTPAuthenticator();
        Session session = Session.getDefaultInstance(props, auth);

        session.setDebug(debug);

        // create a message
        Message msg = new MimeMessage(session);

        // set the from and to address
        InternetAddress addressFrom = new InternetAddress(from);
        msg.setFrom(addressFrom);

        InternetAddress[] addressTo = new InternetAddress[recipients.length];
        for (int i = 0; i < recipients.length; i++) {
            addressTo[i] = new InternetAddress(recipients[i]);
        }
        msg.setRecipients(Message.RecipientType.TO, addressTo);

        // Setting the Subject and Content Type
        msg.setSubject(subject);
        msg.setContent(message, "text/plain");
        Transport transport = session.getTransport("smtp");

        transport.connect();
        transport.sendMessage(msg, msg.getAllRecipients());
        transport.close();
    }

    /**
     * @return the emailList
     */
    public String[] getEmailList() {
        return emailList;
    }

    /**
     * @param emailList the emailList to set
     */
    public void setEmailList(String[] emailList) {
        this.emailList = emailList;
    }

    /**
     * @return the emailSubjectTxt
     */
    public String getEmailSubjectTxt() {
        return emailSubjectTxt;
    }

    /**
     * @param emailSubjectTxt the emailSubjectTxt to set
     */
    public void setEmailSubjectTxt(String emailSubjectTxt) {
        this.emailSubjectTxt = emailSubjectTxt;
    }

    /**
     * @return the emailMsgTxt
     */
    public String getEmailMsgTxt() {
        return emailMsgTxt;
    }

    /**
     * @param emailMsgTxt the emailMsgTxt to set
     */
    public void setEmailMsgTxt(String emailMsgTxt) {
        this.emailMsgTxt = emailMsgTxt;
    }

    public Integer getHash() {
        return hash;
    }

    public void setHash(Integer hash) {
        this.hash = hash;
    }

    /**
     * SimpleAuthenticator is used to do simple authentication when the SMTP
     * server requires it.
     */
    private class SMTPAuthenticator extends javax.mail.Authenticator {

        public PasswordAuthentication getPasswordAuthentication() {
            String username = SMTP_AUTH_USER;
            String password = SMTP_AUTH_PWD;
            return new PasswordAuthentication(username, password);
        }
    }
}
