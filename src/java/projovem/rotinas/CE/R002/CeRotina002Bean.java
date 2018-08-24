/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projovem.rotinas.CE.R002;

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
import projovem.dao.CeRotina002DAO;
import projovem.entity.Usuario;
import projovem.nucleo.Nucleo;

/**
 *
 * @author admprojovem
 */
public class CeRotina002Bean implements Serializable {

    @Resource
    private UserTransaction utx;
    @PersistenceUnit(unitName = "projovemPU")
    private EntityManagerFactory emf;
    private InstrumentoController controller = new InstrumentoController();
    private CeRotina002 rotina = new CeRotina002();
    private CeRotina002DAO rotinaDao = new CeRotina002DAO();
    private Nucleo nucleoEscolhido = new Nucleo();
    private String usuarioResponsavel;
    private String cpfResponsavel;

    /** Creates a new instance of Rotina002Bean */
    public CeRotina002Bean() {
        List<String> listComponenteCurricular = new ArrayList<String>();
        List<String> listQ7 = new ArrayList<String>();
        List<String> listQ5 = new ArrayList<String>();
        List<String> listQ8 = new ArrayList<String>();

        rotina.setListComponenteCurricular(listComponenteCurricular);
        rotina.setListQ7(listQ7);
        rotina.setListQ5(listQ5);
        rotina.setListQ8(listQ8);
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

        rotina.setQ5EducacaoInfantil("Nao");
        rotina.setQ5EnsinoFundamental("Nao");
        rotina.setQ5EnsinoMedio("Nao");
        rotina.setQ5EducacaoJovensAdultos("Nao");
        rotina.setQ5EnsinoTecnicoProfissionalizante("Nao");
        rotina.setQ5EnsinoSuperior("Nao");
        rotina.setQ5Outros("Nao");

        if (rotina.getListQ5() != null && rotina.getListQ5().size() > 0) {
            for (String q5 : rotina.getListQ5()) {
                if (q5.equals("Q5NuncaLecionei")) {
                    rotina.setQ5NuncaLecionei("Sim");
                }
                if (q5.equals("Q5EducacaoInfantil")) {
                    rotina.setQ5EducacaoInfantil("Sim");
                }
                if (q5.equals("Q5EnsinoFundamental")) {
                    rotina.setQ5EnsinoFundamental("Sim");
                }
                if (q5.equals("Q5EnsinoMedio")) {
                    rotina.setQ5EnsinoMedio("Sim");
                }
                if (q5.equals("Q5EducacaoJovensAdultos")) {
                    rotina.setQ5EducacaoJovensAdultos("Sim");
                }
                if (q5.equals("Q5EnsinoTecnicoProfissionalizante")) {
                    rotina.setQ5EnsinoTecnicoProfissionalizante("Sim");
                }
                if (q5.equals("Q5EnsinoSuperior")) {
                    rotina.setQ5EnsinoSuperior("Sim");
                }
                if (q5.equals("Q5Outros")) {
                    rotina.setQ5Outros("Sim");
                }
            }
        }

        rotina.setQ7Convite("Nao");
        rotina.setQ7AvaliacaoCurrículo("Nao");
        rotina.setQ7Entrevista("Nao");
        rotina.setQ7ProvaEscrita("Nao");
        rotina.setQ7Desempenho("Nao");

        if (rotina.getListQ7() != null && rotina.getListQ7().size() > 0) {
            for (String q7 : rotina.getListQ7()) {
                if (q7.equals("Q7Convite")) {
                    rotina.setQ7Convite("Sim");
                }
                if (q7.equals("Q7AvaliacaoCurrículo")) {
                    rotina.setQ7AvaliacaoCurrículo("Sim");
                }
                if (q7.equals("Q7Entrevista")) {
                    rotina.setQ7Entrevista("Sim");
                }
                if (q7.equals("Q7ProvaEscrita")) {
                    rotina.setQ7ProvaEscrita("Sim");
                }
                if (q7.equals("Q7Desempenho")) {
                    rotina.setQ7Desempenho("Sim");
                }
            }
        }

        rotina.setQ8a("Nao");
        rotina.setQ8b("Nao");
        rotina.setQ8c("Nao");
        rotina.setQ8d("Nao");
        rotina.setQ8e("Nao");
        rotina.setQ8f("Nao");
        rotina.setQ8g("Nao");
        rotina.setQ8h("Nao");
        rotina.setQ8i("Nao");

        if (rotina.getListQ8() != null && rotina.getListQ8().size() > 0) {
            for (String q8 : rotina.getListQ8()) {
                if (q8.equals("a")) {
                    rotina.setQ8a("Sim");
                }
                if (q8.equals("b")) {
                    rotina.setQ8b("Sim");
                }
                if (q8.equals("c")) {
                    rotina.setQ8c("Sim");
                }
                if (q8.equals("d")) {
                    rotina.setQ8d("Sim");
                }
                if (q8.equals("e")) {
                    rotina.setQ8e("Sim");
                }
                if (q8.equals("f")) {
                    rotina.setQ8f("Sim");
                }
                if (q8.equals("g")) {
                    rotina.setQ8g("Sim");
                }
                if (q8.equals("h")) {
                    rotina.setQ8h("Sim");
                }
                if (q8.equals("i")) {
                    rotina.setQ8i("Sim");
                }
            }
        }

        String retorno = "";
        if (ValidacaoCeR002.validaRotina(rotina)) {
            try {
                rotinaDao.saveCeRotina002Bean(rotina, emf, utx);
                setUsuarioResponsavel(rotina.getUsuario().getNome());
                setCpfResponsavel(rotina.getUsuario().getCpf());
                retorno = "CeRotina002Salva";
            } catch (Exception ex) {
                String message = "Houve um erro na gravação dos dados. Sua rotia não foi salva. Por favor, tente novamente.";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                ex.printStackTrace();
                Logger.getLogger(CeRotina002Bean.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(CeRotina002Bean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public CeRotina002 getRotina() {
        return rotina;
    }

    public void setRotina(CeRotina002 rotina) {
        this.rotina = rotina;
    }

    /**
     * @return the nucleoEscolhido
     */
    public Nucleo getNucleoEscolhido() {
        return nucleoEscolhido;
    }

    /**
     * @param nucleoEscolhido the nucleoEscolhido to set
     */
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
