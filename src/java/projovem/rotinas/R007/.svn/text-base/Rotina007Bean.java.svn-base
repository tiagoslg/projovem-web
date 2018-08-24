/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projovem.rotinas.R007;

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
import projovem.dao.Rotina007DAO;
import projovem.entity.Usuario;

/**
 *
 * @author admprojovem
 */
public class Rotina007Bean implements Serializable {

    @Resource
    private UserTransaction utx;
    @PersistenceUnit(unitName = "projovemPU")
    private EntityManagerFactory emf;
    private InstrumentoController controller = new InstrumentoController();
    private Rotina007 rotina = new Rotina007();
    private Rotina007DAO rotinaDao = new Rotina007DAO();
    private String usuarioResponsavel;
    private String cpfResponsavel;


    /** Creates a new instance of Rotina007Bean */
    public Rotina007Bean() {
        List<String> listComponenteCurricular = new ArrayList<String>();
        List<String> listQ6 = new ArrayList<String>();


        rotina.setListComponenteCurricular(listComponenteCurricular);
        rotina.setListQ6(listQ6);

    }

    public String salvarRotina() {
        Usuario currentUser = controller.obterUsuarioLogado();
        rotina.setUsuario(currentUser);
        rotina.setDadosValidos("0");
        rotina.setDadosEditados("0");

        rotina.setComponenteCurricularLinguaPortuguesa("Nao");
        rotina.setComponenteCurricularMatematica("Nao");
        rotina.setComponenteCurricularCienciasNatureza("Nao");
        rotina.setComponenteCurricularQualificacaoProfissional("Nao");
        rotina.setComponenteCurricularLinguaEstrangeira("Nao");
        rotina.setComponenteCurricularCienciasHumanas("Nao");
        rotina.setComponenteCurricularParticipacaoCidada("Nao");

        if (rotina.getListComponenteCurricular() != null && rotina.getListComponenteCurricular().size() > 0) {
            for (String componenteCurricular : rotina.getListComponenteCurricular()) {
                if (componenteCurricular.equals("componenteCurricularLinguaPortuguesa")) {
                    rotina.setComponenteCurricularLinguaPortuguesa("Sim");
                }
                if (componenteCurricular.equals("componenteCurricularMatematica")) {
                    rotina.setComponenteCurricularMatematica("Sim");
                }
                if (componenteCurricular.equals("componenteCurricularCienciasNatureza")) {
                    rotina.setComponenteCurricularCienciasNatureza("Sim");
                }
                if (componenteCurricular.equals("componenteCurricularQualificacaoProfissional")) {
                    rotina.setComponenteCurricularQualificacaoProfissional("Sim");
                }
                if (componenteCurricular.equals("componenteCurricularLinguaEstrangeira")) {
                    rotina.setComponenteCurricularLinguaEstrangeira("Sim");
                }
                if (componenteCurricular.equals("componenteCurricularCienciasHumanas")) {
                    rotina.setComponenteCurricularCienciasHumanas("Sim");
                }
                if (componenteCurricular.equals("componenteCurricularParticipacaoCidada")) {
                    rotina.setComponenteCurricularParticipacaoCidada("Sim");
                }
            }
        }



        rotina.setQ6a("Nao");
        rotina.setQ6b("Nao");
        rotina.setQ6c("Nao");
        rotina.setQ6d("Nao");
        rotina.setQ6e("Nao");
        rotina.setQ6f("Nao");
        rotina.setQ6g("Nao");


        if (rotina.getListQ6() != null && rotina.getListQ6().size() > 0) {
            for (String q6 : rotina.getListQ6()) {
                if (q6.equals("a")) {
                    rotina.setQ6a("Sim");
                }
                if (q6.equals("b")) {
                    rotina.setQ6b("Sim");
                }
                if (q6.equals("c")) {
                    rotina.setQ6c("Sim");
                }
                if (q6.equals("d")) {
                    rotina.setQ6d("Sim");
                }
                if (q6.equals("e")) {
                    rotina.setQ6e("Sim");
                }
                if (q6.equals("f")) {
                    rotina.setQ6f("Sim");
                }
                if (q6.equals("g")) {
                    rotina.setQ6g("Sim");
                }

            }
        }


        String retorno = "";
        if (ValidacaoR007.validaRotina(rotina)) {
            try {
                rotinaDao.saveRotina007(rotina, emf, utx);
                setUsuarioResponsavel(rotina.getUsuario().getNome());
                setCpfResponsavel(rotina.getUsuario().getCpf());
                retorno = "Rotina007Salva";
            } catch (Exception ex) {
                String message = "Houve um erro na gravação dos dados. Sua rotina não foi salva. Por favor, tente novamente.";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                ex.printStackTrace();
                Logger.getLogger(Rotina007Bean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return retorno;

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
                Logger.getLogger(Rotina007Bean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Rotina007 getRotina() {
        return rotina;
    }

    public void setRotina(Rotina007 rotina) {
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
