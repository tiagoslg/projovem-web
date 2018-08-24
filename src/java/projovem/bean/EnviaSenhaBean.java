/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package projovem.bean;
import java.io.Serializable;
import java.util.List;
import java.util.Properties;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.transaction.UserTransaction;
import projovem.dao.UsuarioDAO;
import projovem.entity.Usuario;
/**
 *
 * @author admprojovem
 */
public class EnviaSenhaBean {
 @Resource
    private UserTransaction utx ;
    @PersistenceUnit(unitName = "projovemPU")
    private EntityManagerFactory emf;

    private static final String SMTP_HOST_NAME = "smtp.bhz.terra.com.br";

    private static final String SMTP_AUTH_USER = "gtsupervisao";

    private static final String SMTP_AUTH_PWD = "ufbaufmg";

    //private static final String emailMsgTxt = "Please visit my project at ";

    private static final String emailSubjectTxt = "Senha de acesso ao ProJovem Urbano";

    private static final String emailFromAddress = "gtsupervisao@terra.com.br";

    // Add List of Email address to who email needs to be sent to
    private static final String[] emailList = { "danielpinheiro.ti@gmail.com" };

    private List<Usuario> obterUsuaros(){
        UsuarioDAO dao = new UsuarioDAO();
        

        List<Usuario> all = dao.getAll(emf);
        return all;
    }
    public void enviar(){


        List<Usuario> all = obterUsuaros();
        String emailMsgTxt ="";
        for(Usuario usuario:all){
            emailMsgTxt="Sr(a) supervisor "+usuario.getNome()+",\n\n " +
                    "Segue neste email seu login e senha de acesso ao endereço " +
                    "www.projovem.fae.ufmg.br/projovem para lançamento dos dados da Rotina I e da Rotina IV" +
                    " de supervisão. \n\n\n\n" +
                    " LOGIN: "+usuario.getCpf()+"\n" +
                    " SENHA: "+usuario.getCpf()+"\n\n\n" +
                    " Em breve estaremos encaminhando o endereço de acesso definitivo. \n\n" +
                    " Marisa R T Duarte";
            try {
                postMail(emailList, emailSubjectTxt, emailMsgTxt, emailFromAddress);
            } catch (MessagingException ex) {
                Logger.getLogger(EnviaSenhaBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

       /* smtpMailSender.postMail(emailList, emailSubjectTxt, emailMsgTxt,
                emailFromAddress);*/
        System.out.println("Sucessfully Sent mail to All Users");
    }

    public void postMail(String recipients[], String subject, String message,
            String from) throws MessagingException {
        boolean debug = false;
        java.security.Security
                .addProvider(new com.sun.net.ssl.internal.ssl.Provider());

        //Set the host smtp address
        Properties props = new Properties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.host", SMTP_HOST_NAME);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "587");

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
