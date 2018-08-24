/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projovem.rotinas.R001;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.transaction.UserTransaction;
import projovem.controller.InstrumentoController;
import projovem.dao.Rotina001DAO;
import projovem.entity.Usuario;
import projovem.rotinas.apoio.LocalReferenciaVO;

/**
 *
 * @author admprojovem
 */
public class Rotina001Bean implements Serializable {

    @Resource
    private UserTransaction utx;
    @PersistenceUnit(unitName = "projovemPU")
    private EntityManagerFactory emf;
    private InstrumentoController controller = new InstrumentoController();
    private Rotina001 rotina = new Rotina001();
    private Rotina001DAO rotinaDao = new Rotina001DAO();
    private LocalReferenciaVO local;
    private boolean renderedQuestionario = false;
    private String usuarioResponsavel;
    private String cpfResponsavel;

    /** Creates a new instance of Rotina001Bean */
    public Rotina001Bean() {
        List<String> listQ4 = new ArrayList<String>();
        local = new LocalReferenciaVO();

        rotina.setListQ4(listQ4);
    }

    public void classificacaoLocalSelecionado() {
        renderedQuestionario = true;
    }

    public void validarDados(String dadosValidos, Integer idRotinaEscolhida, EntityManagerFactory emf, UserTransaction utx) {

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
                Logger.getLogger(Rotina001Bean.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public String salvarRotina() {
        Usuario currentUser = controller.obterUsuarioLogado();
        rotina.setDadosValidos("0");
        rotina.setDadosEditados("0");
        rotina.setUsuario(currentUser);   
        
        rotina = ValidacaoR001.tratarListas(rotina);
        rotina = local.obterDadosLocal(rotina);

        String retorno = "";
        if (ValidacaoR001.validaRotina(rotina)) {
            try {
                rotinaDao.saveRotina001(rotina, emf, utx);
                setUsuarioResponsavel(rotina.getUsuario().getNome());
                setCpfResponsavel(rotina.getUsuario().getCpf());
                retorno = "Rotina001Salva";
            } catch (Exception ex) {
                String message = "Houve um erro na gravação dos dados. Sua rotia não foi salva. Por favor, tente novamente.";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                ex.printStackTrace();
                Logger.getLogger(Rotina001Bean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }



        return retorno;
    }

    public Rotina001 getRotina() {
        return rotina;
    }

    public void setRotina(Rotina001 rotina) {
        this.rotina = rotina;
    }

    /**
     * @return the local
     */
    public LocalReferenciaVO getLocal() {
        return local;
    }

    /**
     * @param local the local to set
     */
    public void setLocal(LocalReferenciaVO local) {
        this.local = local;
    }

    /**
     * @return the renderedQuestionario
     */
    public boolean isRenderedQuestionario() {
        return renderedQuestionario;
    }

    /**
     * @param renderedQuestionario the renderedQuestionario to set
     */
    public void setRenderedQuestionario(boolean renderedQuestionario) {
        this.renderedQuestionario = renderedQuestionario;
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
