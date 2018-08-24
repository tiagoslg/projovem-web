/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projovem.rotinas.R002;

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
import projovem.dao.Rotina002DAO;
import projovem.entity.Usuario;

/**
 *
 * @author admprojovem
 */
public class Rotina002PerfilEducadoresBean implements Serializable {

    @Resource
    private UserTransaction utx;
    @PersistenceUnit(unitName = "projovemPU")
    private EntityManagerFactory emf;
    private InstrumentoController controller = new InstrumentoController();
    private Rotina002PerfilEducadores rotina = new Rotina002PerfilEducadores();
    private Rotina002DAO rotinaDao = new Rotina002DAO();
    private String usuarioResponsavel;
    private String cpfResponsavel;


    /** Creates a new instance of Rotina002PerfilEducadoresBean */
    public Rotina002PerfilEducadoresBean() {
        List<String> listComponenteCurricular = new ArrayList<String>();
        List<String> listQ11 = new ArrayList<String>();
        List<String> listQ13 = new ArrayList<String>();
        List<String> listQ14 = new ArrayList<String>();
        List<String> listQ8 = new ArrayList<String>();

        rotina.setListComponenteCurricular(listComponenteCurricular);
        rotina.setListQ11(listQ11);
        rotina.setListQ13(listQ13);
        rotina.setListQ14(listQ14);
        rotina.setListQ8(listQ8);
    }

    public void validarDados(String dadosValidos, Integer idRotinaEscolhida, EntityManagerFactory emf, UserTransaction utx) {

        rotina = rotinaDao.getPerfilEducadoresById(idRotinaEscolhida, emf);

        rotina.setUsrResponsavelValidacao(controller.obterUsuarioLogado().getId());
        rotina.setDadosValidos(dadosValidos);
        Usuario u = new Usuario();
        rotina.setDataValidacao(u.getDataAtual());
        rotina.setHoraValidacao(u.getHoraAtual());

        try {
            rotinaDao.validarDadosPerfilEducadores(rotina, emf, utx);
        }catch (Exception ex) {
                String message = "Houve um erro na gravação dos dados. Sua rotina não foi validada. Por favor, tente novamente.";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                ex.printStackTrace();
                Logger.getLogger(Rotina002PerfilEducadoresBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String salvarRotina() {
        Usuario currentUser = controller.obterUsuarioLogado();
        rotina.setUsuario(currentUser);
        rotina.setDadosValidos("0");
        rotina.setDadosEditados("0");


        rotina = ValidacaoPerfilEducadores.tratarListas(rotina);

        String retorno = "";
        if (ValidacaoPerfilEducadores.validaRotina(rotina)) {
            try {
                rotinaDao.saveRotina002PerfilEducadoresBean(rotina, emf, utx);
                setUsuarioResponsavel(rotina.getUsuario().getNome());
                setCpfResponsavel(rotina.getUsuario().getCpf());
                retorno = "Rotina002PerfilEducadoresSalva";
            } catch (Exception ex) {
                String message = "Houve um erro na gravação dos dados. Sua rotia não foi salva. Por favor, tente novamente.";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                ex.printStackTrace();
                Logger.getLogger(Rotina002PerfilEducadoresBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return retorno;
    }

    public Rotina002PerfilEducadores getRotina() {
        return rotina;
    }

    public void setRotina(Rotina002PerfilEducadores rotina) {
        this.rotina = rotina;
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
