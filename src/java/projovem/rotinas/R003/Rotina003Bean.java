/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projovem.rotinas.R003;

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
import projovem.dao.Rotina003DAO;
import projovem.entity.Usuario;
import projovem.rotinas.apoio.LocalReferenciaVO;

/**
 *
 * @author admprojovem
 */
public class Rotina003Bean implements Serializable {

    @Resource
    private UserTransaction utx;
    @PersistenceUnit(unitName = "projovemPU")
    private EntityManagerFactory emf;
    private InstrumentoController controller = new InstrumentoController();
    private Rotina003 rotina = new Rotina003();
    private Rotina003Ficha ficha = new Rotina003Ficha();
    private Rotina003DAO rotinaDao = new Rotina003DAO();
    private LocalReferenciaVO local = new LocalReferenciaVO();
    private String usuarioResponsavel;
    private String cpfResponsavel;


    /** Creates a new instance of Rotina003Bean */
    public Rotina003Bean() {
        List<Rotina003Ficha> listaFichas = new ArrayList<Rotina003Ficha>();
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
        ficha = new Rotina003Ficha();
    }

    public void editarFicha() {
    }

    public void excluirFicha() {
        rotina.getListaFichas().remove(ficha);
        ficha = new Rotina003Ficha();
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
                Logger.getLogger(Rotina003Bean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String salvarRotina() {
        Usuario currentUser = controller.obterUsuarioLogado();
        rotina.setUsuario(currentUser);
        rotina.setDadosValidos("0");
        rotina.setDadosEditados("0");

        rotina = local.obterDadosLocal(rotina);

        String retorno = "";
        if (ValidacaoR003.validaRotina(rotina)) {
            try {
                rotinaDao.saveRotina003(rotina, emf, utx);
                setUsuarioResponsavel(rotina.getUsuario().getNome());
                setCpfResponsavel(rotina.getUsuario().getCpf());
                retorno = "Rotina003Salva";
            } catch (Exception ex) {
                String message = "Houve um erro na gravação dos dados. Sua rotia não foi salva. Por favor, tente novamente.";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                ex.printStackTrace();
                Logger.getLogger(Rotina003Bean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return retorno;
    }

    public Rotina003Ficha getFicha() {
        return ficha;
    }

    public void setFicha(Rotina003Ficha ficha) {
        this.ficha = ficha;
    }

    public Rotina003 getRotina() {
        return rotina;
    }

    public void setRotina(Rotina003 rotina) {
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
