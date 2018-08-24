

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projovem.rotinas.CE.R001;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.transaction.UserTransaction;
import projovem.controller.InstrumentoController;
import projovem.dao.CeRotina001DAO;
import projovem.entity.Usuario;
import projovem.nucleo.Nucleo;

/**
 *
 * @author admprojovem
 */
public class CeRotina001Bean implements Serializable {

    @Resource
    private UserTransaction utx;
    @PersistenceUnit(unitName = "projovemPU")
    private EntityManagerFactory emf;
    private InstrumentoController controller = new InstrumentoController();
    private CeRotina001 rotina = new CeRotina001();
    private CeRotina001DAO rotinaDao = new CeRotina001DAO();
    private Nucleo nucleoEscolhido = new Nucleo();
    private String usuarioResponsavel;
    private String cpfResponsavel;

    /** Creates a new instance of Rotina006Bean */
    public CeRotina001Bean() {
        
    }

    public String salvarRotina() {
        Usuario currentUser = controller.obterUsuarioLogado();
        rotina.setUsuario(currentUser);
        rotina.setDadosValidos("0");
        rotina.setDadosEditados("0");

        String retorno = "";
        if (ValidacaoCeR001.validaRotina(rotina)) {
            try {
                rotinaDao.saveCeRotina001(rotina, emf, utx);
                setUsuarioResponsavel(rotina.getUsuario().getNome());
                setCpfResponsavel(rotina.getUsuario().getCpf());
                retorno = "CeRotina001Salva";
            } catch (Exception ex) {
                String message = "Houve um erro na gravação dos dados. Sua rotia não foi salva. Por favor, tente novamente.";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                ex.printStackTrace();
                Logger.getLogger(CeRotina001Bean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return retorno;

    }

    public void validarDados(String dadosValidos, Integer idRotinaEscolhida, EntityManagerFactory emf, UserTransaction utx){

        rotina = rotinaDao.getById(idRotinaEscolhida, emf);

        rotina.setUsrResponsavelValidacao(controller.obterUsuarioLogado().getId());
        rotina.setDadosValidos(dadosValidos);
        Usuario u = new Usuario();
        rotina.setDataValidacao(u.getDataAtual());
        rotina.setHoraValidacao(u.getHoraAtual());

        try {
            rotinaDao.validarDados(rotina, emf, utx);
        }catch (Exception ex) {
                String message = "Houve um erro na gravação dos dados. Sua rotina não foi validada. Por favor, tente novamente.";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                ex.printStackTrace();
                Logger.getLogger(CeRotina001Bean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    public CeRotina001 getRotina() {
        return rotina;
    }

    public void setRotina(CeRotina001 rotina) {
        this.rotina = rotina;
    }

    public Nucleo getNucleoEscolhido() {
        return nucleoEscolhido;
    }

    public void setNucleoEscolhido(Nucleo nucleoEscolhido) {
        this.nucleoEscolhido = nucleoEscolhido;
    }

    /**
     * @return the usuarioResponsavel
     */
    public String getUsuarioResponsavel() {
        return usuarioResponsavel;
    }

    /**
     * @param usuarioResponsavel the usuarioResponsavel to set
     */
    public void setUsuarioResponsavel(String usuarioResponsavel) {
        this.usuarioResponsavel = usuarioResponsavel;
    }

    /**
     * @return the cpfResponsavel
     */
    public String getCpfResponsavel() {
        return cpfResponsavel;
    }

    /**
     * @param cpfResponsavel the cpfResponsavel to set
     */
    public void setCpfResponsavel(String cpfResponsavel) {
        this.cpfResponsavel = cpfResponsavel;
    }

}
