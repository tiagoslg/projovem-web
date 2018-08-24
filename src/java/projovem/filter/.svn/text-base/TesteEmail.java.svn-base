/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package projovem.filter;

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
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.transaction.UserTransaction;
import projovem.dao.UsuarioDAO;
import projovem.entity.Usuario;
/**
 *
 * @author admprojovem
 */
public class TesteEmail {
    
    @Resource
    private UserTransaction utx ;
    @PersistenceUnit(unitName = "projovemPU")
    private EntityManagerFactory emf;

    private  String SMTP_HOST_NAME = "gmail-smtp.l.google.com";

        private String SMTP_AUTH_USER = "desenvolvimento.projovem@gmail.com";

    private String SMTP_AUTH_PWD = "projovem";

    //private static final String emailMsgTxt = "Please visit my project at ";



    private String emailFromAddress = "desenvolvimento.projovem@gmail.com";
    private  String[] emailList ;
    private String emailSubjectTxt ;
    private String emailMsgTxt = "";


    public static void main (String[] args){
        TesteEmail t = new TesteEmail();
        t.enviar();
    }
    public void enviar()  {
        TesteEmail smtpMailSender = new TesteEmail();

        try {
            smtpMailSender.postMail(getEmailList(), getEmailSubjectTxt(), getEmailMsgTxt(),emailFromAddress);
        } catch (MessagingException ex) {
            Logger.getLogger(TesteEmail.class.getName()).log(Level.SEVERE, null, ex);
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
        props.put("mail.smtp.starttls.enable","true");
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
        Transport.send(msg);
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
