/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projovem.rotinas.R006;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.transaction.UserTransaction;
import projovem.controller.InstrumentoController;
import projovem.dao.ArcoDAO;
import projovem.dao.Rotina006DAO;
import projovem.entity.Arco;
import projovem.entity.Usuario;
import projovem.rotinas.apoio.LocalReferenciaVO;

/**
 *
 * @author admprojovem
 */
public class Rotina006CoordenacaoLocalBean implements Serializable {

    @Resource
    private UserTransaction utx;
    @PersistenceUnit(unitName = "projovemPU")
    private EntityManagerFactory emf;
    private InstrumentoController controller = new InstrumentoController();
    private Rotina006CoordenacaoLocal rotina = new Rotina006CoordenacaoLocal();
    private List<SelectItem> listaArcos = new ArrayList<SelectItem>();
    private Rotina006CoordenacaoLocalLocais local = new Rotina006CoordenacaoLocalLocais();
    private ArcoDAO arcoDAO = new ArcoDAO();
    private Rotina006DAO rotinaDao = new Rotina006DAO();
    private LocalReferenciaVO localReferencia = new LocalReferenciaVO();
    private String usuarioResponsavel;
    private String cpfResponsavel;


    /** Creates a new instance of Rotina006CoordenacaoLocalBean */
    public Rotina006CoordenacaoLocalBean() {
        List<Rotina006CoordenacaoLocalLocais> listaLocal = new ArrayList<Rotina006CoordenacaoLocalLocais>();
        rotina.setListaLocais(listaLocal);
    }

    public void adicionarLocal() {
        if (!rotina.getListaLocais().contains(local)) {
            rotina.getListaLocais().add(local);
        }
        local = new Rotina006CoordenacaoLocalLocais();
    }

    public void editarLocal() {
    }

    public void excluirLocal() {
        rotina.getListaLocais().remove(local);
    }

    public String salvarRotina() {
        Usuario currentUser = controller.obterUsuarioLogado();
        rotina.setUsuario(currentUser);
        rotina.setDadosValidos("0");
        rotina.setDadosEditados("0");

        rotina = localReferencia.obterDadosLocal(rotina);

        List<Rotina006CoordenacaoLocalLocais> listaLocais = rotina.getListaLocais();
        for (Rotina006CoordenacaoLocalLocais localQ6 : listaLocais) {
            if (localQ6.isArcosAOferecido != null && localQ6.isArcosAOferecido.size() > 0 &&  localQ6.isArcosAOferecido.get(0).equals("true")) {
                localQ6.setArcosAOferecido("true");
            }
            if (localQ6.isArcosBOferecido != null && localQ6.isArcosBOferecido.size() > 0 && localQ6.isArcosBOferecido.get(0).equals("true")) {
                localQ6.setArcosBOferecido("true");
            }
            if (localQ6.isArcosCOferecido != null && localQ6.isArcosCOferecido.size() > 0 && localQ6.isArcosCOferecido.get(0).equals("true")) {
                localQ6.setArcosCOferecido("true");
            }
            if (localQ6.isArcosDOferecido != null && localQ6.isArcosDOferecido.size() > 0 && localQ6.isArcosDOferecido.get(0).equals("true")) {
                localQ6.setArcosDOferecido("true");
            }
            if (localQ6.isArcosEOferecido != null && localQ6.isArcosEOferecido.size() > 0 && localQ6.isArcosEOferecido.get(0).equals("true")) {
                localQ6.setArcosEOferecido("true");
            }

            if (localQ6.isFuncionamentoArcoADomingo != null && localQ6.isFuncionamentoArcoADomingo.size() > 0 && localQ6.isFuncionamentoArcoADomingo.get(0).equals("true")) {
                localQ6.setDiaFuncionamentoArcoADomingo("true");
            }
            if (localQ6.isFuncionamentoArcoASegunda != null && localQ6.isFuncionamentoArcoASegunda.size() > 0 && localQ6.isFuncionamentoArcoASegunda.get(0).equals("true")) {
                localQ6.setDiaFuncionamentoArcoASegunda("true");
            }
            if (localQ6.isFuncionamentoArcoATerca != null && localQ6.isFuncionamentoArcoATerca.size() > 0 && localQ6.isFuncionamentoArcoATerca.get(0).equals("true")) {
                localQ6.setDiaFuncionamentoArcoATerca("true");
            }
            if (localQ6.isFuncionamentoArcoAQuarta != null && localQ6.isFuncionamentoArcoAQuarta.size() > 0 && localQ6.isFuncionamentoArcoAQuarta.get(0).equals("true")) {
                localQ6.setDiaFuncionamentoArcoAQuarta("true");
            }
            if (localQ6.isFuncionamentoArcoAQuinta != null && localQ6.isFuncionamentoArcoAQuinta.size() > 0 && localQ6.isFuncionamentoArcoAQuinta.get(0).equals("true")) {
                localQ6.setDiaFuncionamentoArcoAQuinta("true");
            }
            if (localQ6.isFuncionamentoArcoASexta != null && localQ6.isFuncionamentoArcoASexta.size() > 0 && localQ6.isFuncionamentoArcoASexta.get(0).equals("true")) {
                localQ6.setDiaFuncionamentoArcoASexta("true");
            }
            if (localQ6.isFuncionamentoArcoASabado != null && localQ6.isFuncionamentoArcoASabado.size() > 0 && localQ6.isFuncionamentoArcoASabado.get(0).equals("true")) {
                localQ6.setDiaFuncionamentoArcoASabado("true");
            }


            if (localQ6.isFuncionamentoArcoBDomingo != null && localQ6.isFuncionamentoArcoBDomingo.size() > 0 && localQ6.isFuncionamentoArcoBDomingo.get(0).equals("true")) {
                localQ6.setDiaFuncionamentoArcoBDomingo("true");
            }
            if (localQ6.isFuncionamentoArcoBSegunda != null && localQ6.isFuncionamentoArcoBSegunda.size() > 0 && localQ6.isFuncionamentoArcoBSegunda.get(0).equals("true")) {
                localQ6.setDiaFuncionamentoArcoBSegunda("true");
            }
            if (localQ6.isFuncionamentoArcoBTerca != null && localQ6.isFuncionamentoArcoBTerca.size() > 0 && localQ6.isFuncionamentoArcoBTerca.get(0).equals("true")) {
                localQ6.setDiaFuncionamentoArcoBTerca("true");
            }
            if (localQ6.isFuncionamentoArcoBQuarta != null && localQ6.isFuncionamentoArcoBQuarta.size() > 0 && localQ6.isFuncionamentoArcoBQuarta.get(0).equals("true")) {
                localQ6.setDiaFuncionamentoArcoBQuarta("true");
            }
            if (localQ6.isFuncionamentoArcoBQuinta != null  && localQ6.isFuncionamentoArcoBQuinta.size() > 0 && localQ6.isFuncionamentoArcoBQuinta.get(0).equals("true")) {
                localQ6.setDiaFuncionamentoArcoBQuinta("true");
            }
            if (localQ6.isFuncionamentoArcoBSexta != null && localQ6.isFuncionamentoArcoBSexta.size() > 0 && localQ6.isFuncionamentoArcoBSexta.get(0).equals("true")) {
                localQ6.setDiaFuncionamentoArcoBSexta("true");
            }
            if (localQ6.isFuncionamentoArcoBSabado != null && localQ6.isFuncionamentoArcoBSabado.size() > 0 && localQ6.isFuncionamentoArcoBSabado.get(0).equals("true")) {
                localQ6.setDiaFuncionamentoArcoBSabado("true");
            }


            if (localQ6.isFuncionamentoArcoCDomingo != null && localQ6.isFuncionamentoArcoCDomingo.size() > 0 && localQ6.isFuncionamentoArcoCDomingo.get(0).equals("true")) {
                localQ6.setDiaFuncionamentoArcoCDomingo("true");
            }
            if (localQ6.isFuncionamentoArcoCSegunda != null && localQ6.isFuncionamentoArcoCSegunda.size() > 0 && localQ6.isFuncionamentoArcoCSegunda.get(0).equals("true")) {
                localQ6.setDiaFuncionamentoArcoCSegunda("true");
            }
            if (localQ6.isFuncionamentoArcoCTerca != null && localQ6.isFuncionamentoArcoCTerca.size() > 0 && localQ6.isFuncionamentoArcoCTerca.get(0).equals("true")) {
                localQ6.setDiaFuncionamentoArcoCTerca("true");
            }
            if (localQ6.isFuncionamentoArcoCQuarta != null && localQ6.isFuncionamentoArcoCQuarta.size() > 0 && localQ6.isFuncionamentoArcoCQuarta.get(0).equals("true")) {
                localQ6.setDiaFuncionamentoArcoCQuarta("true");
            }
            if (localQ6.isFuncionamentoArcoCQuinta != null && localQ6.isFuncionamentoArcoCQuinta.size() > 0 && localQ6.isFuncionamentoArcoCQuinta.get(0).equals("true")) {
                localQ6.setDiaFuncionamentoArcoCQuinta("true");
            }
            if (localQ6.isFuncionamentoArcoCSexta != null && localQ6.isFuncionamentoArcoCSexta.size() > 0 && localQ6.isFuncionamentoArcoCSexta.get(0).equals("true")) {
                localQ6.setDiaFuncionamentoArcoCSexta("true");
            }
            if (localQ6.isFuncionamentoArcoCSabado != null && localQ6.isFuncionamentoArcoCSabado.size() > 0 && localQ6.isFuncionamentoArcoCSabado.get(0).equals("true")) {
                localQ6.setDiaFuncionamentoArcoCSabado("true");
            }


            if (localQ6.isFuncionamentoArcoDDomingo != null && localQ6.isFuncionamentoArcoDDomingo.size() > 0 && localQ6.isFuncionamentoArcoDDomingo.get(0).equals("true")) {
                localQ6.setDiaFuncionamentoArcoDDomingo("true");
            }
            if (localQ6.isFuncionamentoArcoDSegunda != null && localQ6.isFuncionamentoArcoDSegunda.size() > 0 && localQ6.isFuncionamentoArcoDSegunda.get(0).equals("true")) {
                localQ6.setDiaFuncionamentoArcoDSegunda("true");
            }
            if (localQ6.isFuncionamentoArcoDTerca != null && localQ6.isFuncionamentoArcoDTerca.size() > 0 && localQ6.isFuncionamentoArcoDTerca.get(0).equals("true")) {
                localQ6.setDiaFuncionamentoArcoDTerca("true");
            }
            if (localQ6.isFuncionamentoArcoDQuarta != null && localQ6.isFuncionamentoArcoDQuarta.size() > 0 && localQ6.isFuncionamentoArcoDQuarta.get(0).equals("true")) {
                localQ6.setDiaFuncionamentoArcoDQuarta("true");
            }
            if (localQ6.isFuncionamentoArcoDQuinta != null && localQ6.isFuncionamentoArcoDQuinta.size() > 0 && localQ6.isFuncionamentoArcoDQuinta.get(0).equals("true")) {
                localQ6.setDiaFuncionamentoArcoDQuinta("true");
            }
            if (localQ6.isFuncionamentoArcoDSexta != null && localQ6.isFuncionamentoArcoDSexta.size() > 0 && localQ6.isFuncionamentoArcoDSexta.get(0).equals("true")) {
                localQ6.setDiaFuncionamentoArcoDSexta("true");
            }
            if (localQ6.isFuncionamentoArcoDSabado != null && localQ6.isFuncionamentoArcoDSabado.size() > 0 && localQ6.isFuncionamentoArcoDSabado.get(0).equals("true")) {
                localQ6.setDiaFuncionamentoArcoDSabado("true");
            }


            if (localQ6.isFuncionamentoArcoEDomingo != null && localQ6.isFuncionamentoArcoEDomingo.size() > 0 && localQ6.isFuncionamentoArcoEDomingo.get(0).equals("true")) {
                localQ6.setDiaFuncionamentoArcoEDomingo("true");
            }
            if (localQ6.isFuncionamentoArcoESegunda != null && localQ6.isFuncionamentoArcoESegunda.size() > 0 && localQ6.isFuncionamentoArcoESegunda.get(0).equals("true")) {
                localQ6.setDiaFuncionamentoArcoESegunda("true");
            }
            if (localQ6.isFuncionamentoArcoETerca != null && localQ6.isFuncionamentoArcoETerca.size() > 0 && localQ6.isFuncionamentoArcoETerca.get(0).equals("true")) {
                localQ6.setDiaFuncionamentoArcoETerca("true");
            }
            if (localQ6.isFuncionamentoArcoEQuarta != null && localQ6.isFuncionamentoArcoEQuarta.size() > 0 && localQ6.isFuncionamentoArcoEQuarta.get(0).equals("true")) {
                localQ6.setDiaFuncionamentoArcoEQuarta("true");
            }
            if (localQ6.isFuncionamentoArcoEQuinta != null && localQ6.isFuncionamentoArcoEQuinta.size() > 0 && localQ6.isFuncionamentoArcoEQuinta.get(0).equals("true")) {
                localQ6.setDiaFuncionamentoArcoEQuinta("true");
            }
            if (localQ6.isFuncionamentoArcoESexta != null && localQ6.isFuncionamentoArcoESexta.size() > 0 && localQ6.isFuncionamentoArcoESexta.get(0).equals("true")) {
                localQ6.setDiaFuncionamentoArcoESexta("true");
            }
            if (localQ6.isFuncionamentoArcoESabado != null && localQ6.isFuncionamentoArcoESabado.size() > 0 && localQ6.isFuncionamentoArcoESabado.get(0).equals("true")) {
                localQ6.setDiaFuncionamentoArcoESabado("true");
            }
        }

         String retorno = "";
        if (ValidacaoCoordenacaoLocal.validaRotina(rotina)) {
            try {
                rotinaDao.saveRotinaQPCoordenacaoLocal(rotina, emf, utx);
                setUsuarioResponsavel(rotina.getUsuario().getNome());
                setCpfResponsavel(rotina.getUsuario().getCpf());
                retorno = "Rotina006CoordenacaoSalva";
            } catch (Exception ex) {
                String message = "Houve um erro na gravação dos dados. Sua rotina não foi salva. Por favor, tente novamente.";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                ex.printStackTrace();
                Logger.getLogger(Rotina006CoordenacaoLocalBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return retorno;

    }

    public void validarDados(String dadosValidos, Integer idRotinaEscolhida, EntityManagerFactory emf, UserTransaction utx){

        rotina = rotinaDao.getCoordenacaoLocalById(idRotinaEscolhida, emf);

        rotina.setUsrResponsavelValidacao(controller.obterUsuarioLogado().getId());
        rotina.setDadosValidos(dadosValidos);
        Usuario u = new Usuario();
        rotina.setDataValidacao(u.getDataAtual());
        rotina.setHoraValidacao(u.getHoraAtual());

        try {
            rotinaDao.validarDadosCoordenacaoLocal(rotina, emf, utx);
        }catch (Exception ex) {
                String message = "Houve um erro na gravação dos dados. Sua rotina não foi validada. Por favor, tente novamente.";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                ex.printStackTrace();
                Logger.getLogger(Rotina006CoordenacaoLocalBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @return the rotina
     */
    public Rotina006CoordenacaoLocal getRotina() {
        return rotina;
    }

    /**
     * @param rotina the rotina to set
     */
    public void setRotina(Rotina006CoordenacaoLocal rotina) {
        this.rotina = rotina;
    }

    /**
     * @return the listaArcos
     */
    public List<SelectItem> getListaArcos() {

        if (listaArcos != null && listaArcos.size() == 0) {
            listaArcos.add(new SelectItem("naoInformado", "Não Informado"));
            listaArcos.add(new SelectItem("semPrevisao", "Sem previsão de início"));
            List<Arco> lista = new ArrayList<Arco>();
            lista = arcoDAO.getAll(emf);
            for (Arco arco : lista) {
                listaArcos.add(new SelectItem(arco.getNome(), arco.getNome()));
            }
        }
        return listaArcos;
    }

    /**
     * @param listaArcos the listaArcos to set
     */
    public void setListaArcos(List<SelectItem> listaArcos) {
        this.listaArcos = listaArcos;
    }

    /**
     * @return the local
     */
    public Rotina006CoordenacaoLocalLocais getLocal() {
        return local;
    }

    /**
     * @param local the local to set
     */
    public void setLocal(Rotina006CoordenacaoLocalLocais local) {
        this.local = local;
    }

    /**
     * @return the localReferencia
     */
    public LocalReferenciaVO getLocalReferencia() {
        return localReferencia;
    }

    /**
     * @param localReferencia the localReferencia to set
     */
    public void setLocalReferencia(LocalReferenciaVO localReferencia) {
        this.localReferencia = localReferencia;
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
