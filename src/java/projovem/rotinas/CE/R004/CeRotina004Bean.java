
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projovem.rotinas.CE.R004;

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
import projovem.entity.Usuario;
import projovem.rotinas.apoio.LocalReferenciaVO;

/**
 *
 * @author admprojovem
 */
public class CeRotina004Bean implements Serializable {

    @Resource
    private UserTransaction utx;
    @PersistenceUnit(unitName = "projovemPU")
    private EntityManagerFactory emf;
    private InstrumentoController controller = new InstrumentoController();
    private CeRotina004 rotina = new CeRotina004();
    private CeRotina004Ficha ficha = new CeRotina004Ficha();
    private CeRotina004DAO rotinaDao = new CeRotina004DAO();
    private LocalReferenciaVO local = new LocalReferenciaVO();
    private String usuarioResponsavel;
    private String cpfResponsavel;

    /** Creates a new instance of Rotina006Bean */
    public CeRotina004Bean() {
        List<CeRotina004Ficha> listaFichas = new ArrayList<CeRotina004Ficha>();
        rotina.setListaFichas(listaFichas);
    }

    public void adicionarLinha() {
        ficha.setTemCarteiraIdentidade("Não");
        ficha.setTemComprovanteResidencia("Não");
        ficha.setTemRegistroEscolar("Não");
        ficha.setTemTeste("Não");

        if (ficha.getAtributos() != null && ficha.getAtributos().size() > 0) {
            for (String string : ficha.getAtributos()) {
                if (string.equals("temCarteiraIdentidade")) {
                    ficha.setTemCarteiraIdentidade("Sim");
                }
                if (string.equals("temComprovanteResidencia")) {
                    ficha.setTemComprovanteResidencia("Sim");
                }
                if (string.equals("temRegistroEscolar")) {
                    ficha.setTemRegistroEscolar("Sim");
                }
                if (string.equals("temTeste")) {
                    ficha.setTemTeste("Sim");
                }
            }
        }
        if (!rotina.getListaFichas().contains(ficha)) {
            rotina.getListaFichas().add(ficha);
        }
        ficha = new CeRotina004Ficha();
    }

    public void editarFicha() {
    }

    public void excluirFicha() {
        rotina.getListaFichas().remove(ficha);
        ficha = new CeRotina004Ficha();
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
                Logger.getLogger(CeRotina004Bean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String salvarRotina() {
        Usuario currentUser = controller.obterUsuarioLogado();
        rotina.setUsuario(currentUser);
        rotina.setDadosValidos("0");
        rotina.setDadosEditados("0");

        rotina = local.obterDadosLocal(rotina);

        String retorno = "";
        if (ValidacaoCeR004.validaRotina(rotina)) {
            try {
                rotinaDao.saveCeRotina004(rotina, emf, utx);
                setUsuarioResponsavel(rotina.getUsuario().getNome());
                setCpfResponsavel(rotina.getUsuario().getCpf());
                retorno = "CeRotina004Salva";
            } catch (Exception ex) {
                String message = "Houve um erro na gravação dos dados. Sua rotia não foi salva. Por favor, tente novamente.";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                ex.printStackTrace();
                Logger.getLogger(CeRotina004Bean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return retorno;
    }

    public CeRotina004Ficha getFicha() {
        return ficha;
    }

    public void setFicha(CeRotina004Ficha ficha) {
        this.ficha = ficha;
    }

    public CeRotina004 getRotina() {
        return rotina;
    }

    public void setRotina(CeRotina004 rotina) {
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
