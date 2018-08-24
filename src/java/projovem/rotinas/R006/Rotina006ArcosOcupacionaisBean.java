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
import projovem.nucleo.Nucleo;
import projovem.rotinas.apoio.LocalReferenciaVO;

/**
 *
 * @author admprojovem
 */
public class Rotina006ArcosOcupacionaisBean implements Serializable {

    @Resource
    private UserTransaction utx;
    @PersistenceUnit(unitName = "projovemPU")
    private EntityManagerFactory emf;
    private InstrumentoController controller = new InstrumentoController();
    private Rotina006ArcosOcupacionais rotina = new Rotina006ArcosOcupacionais();
    private List<SelectItem> listaArcos = new ArrayList<SelectItem>();
    private ArcoDAO arcoDAO = new ArcoDAO();
    private Rotina006DAO rotinaDao = new Rotina006DAO();
    private Rotina006ArcosOcupacionaisMateriais arcoOcupacionalMaterial = new Rotina006ArcosOcupacionaisMateriais();
    private List<Rotina006ArcosOcupacionaisMateriais> materiais = new ArrayList<Rotina006ArcosOcupacionaisMateriais>();
    private List<String> isArcoAFechado = new ArrayList<String>();
    private List<String> isArcoBFechado = new ArrayList<String>();
    private List<String> isArcoCFechado = new ArrayList<String>();
    private List<String> isArcoDFechado = new ArrayList<String>();
    private List<String> isArcoEFechado = new ArrayList<String>();
    private LocalReferenciaVO localReferencia = new LocalReferenciaVO();
    private List<Nucleo> listaNucleos = new ArrayList<Nucleo>();
    private String usuarioResponsavel;
    private String cpfResponsavel;

    public LocalReferenciaVO getLocalReferencia() {
        return localReferencia;
    }

    public void setLocalReferencia(LocalReferenciaVO localReferencia) {
        this.localReferencia = localReferencia;
    }

    public void editar() {
    }

    public void adicionarMaterial() {
        System.out.println("Entrou aqui.....");
        if (!materiais.contains(arcoOcupacionalMaterial)) {
            materiais.add(arcoOcupacionalMaterial);
        }
        arcoOcupacionalMaterial = new Rotina006ArcosOcupacionaisMateriais();
    }

    public void removerMaterial() {
        materiais.remove(arcoOcupacionalMaterial);
        arcoOcupacionalMaterial = new Rotina006ArcosOcupacionaisMateriais();
    }

    /** Creates a new instance of Rotina006ArcosOcupacionaisBean */
    public Rotina006ArcosOcupacionaisBean() {
    }

    public String salvarRotina() {

        Usuario currentUser = controller.obterUsuarioLogado();
        rotina.setUsuario(currentUser);
        rotina.setDadosValidos("0");
        rotina.setDadosEditados("0");

        rotina = localReferencia.obterDadosLocal(rotina);
        rotina.setQ55(materiais);

        rotina.setQ9Fechado("false");
        rotina.setQ10Fechado("false");
        rotina.setQ11Fechado("false");
        rotina.setQ12Fechado("false");
        rotina.setQ13Fechado("false");

        if (isArcoAFechado != null && isArcoAFechado.size() > 0 && isArcoAFechado.get(0).equals("fechado")) {
        rotina.setQ9Fechado("true");
        }
        if (isArcoBFechado != null && isArcoBFechado.size() > 0 && isArcoBFechado.get(0).equals("fechado")) {
        rotina.setQ10Fechado("true");
        }
        if (isArcoCFechado != null && isArcoCFechado.size() > 0 && isArcoCFechado.get(0).equals("fechado")) {
        rotina.setQ11Fechado("true");
        }
        if (isArcoDFechado != null && isArcoDFechado.size() > 0 && isArcoDFechado.get(0).equals("fechado")) {
        rotina.setQ12Fechado("true");
        }
        if (isArcoEFechado != null && isArcoEFechado.size() > 0 && isArcoEFechado.get(0).equals("fechado")) {
        rotina.setQ13Fechado("true");
        }

        List<Nucleo> listaNucleosAtendidos = new ArrayList<Nucleo>();

        for (Nucleo nucleo : getListaNucleos()) {
            if (nucleo.getSelecionado() != null && nucleo.getSelecionado().equals("selecionado")) {
                listaNucleosAtendidos.add(nucleo);
            }
        }
        rotina.setNucleoAtendido(listaNucleosAtendidos);

        String retorno = "";
        if (ValidacaoArcosOcupacionais.validaRotina(rotina)) {
            try {
                rotinaDao.saveRotinaQPArcosOcupacionais(rotina, emf, utx);
                setUsuarioResponsavel(rotina.getUsuario().getNome());
                setCpfResponsavel(rotina.getUsuario().getCpf());
                retorno = "Rotina006ArcosOcupacionaisSalva";
            } catch (Exception ex) {
                String message = "Houve um erro na gravação dos dados. Sua rotia não foi salva. Por favor, tente novamente.";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                ex.printStackTrace();
                Logger.getLogger(Rotina006ArcosOcupacionaisBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return retorno;

    }

    public void validarDados(String dadosValidos, Integer idRotinaEscolhida, EntityManagerFactory emf, UserTransaction utx) {

        rotina = rotinaDao.getArcosOcupacionaisById(idRotinaEscolhida, emf);

        rotina.setUsrResponsavelValidacao(controller.obterUsuarioLogado().getId());
        rotina.setDadosValidos(dadosValidos);
        Usuario u = new Usuario();
        rotina.setDataValidacao(u.getDataAtual());
        rotina.setHoraValidacao(u.getHoraAtual());
        
        try {
            rotinaDao.validarDadosArcosOcupacionais(rotina, emf, utx);
        }catch (Exception ex) {
                String message = "Houve um erro na gravação dos dados. Sua rotina não foi validada. Por favor, tente novamente.";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                ex.printStackTrace();
                Logger.getLogger(Rotina006ArcosOcupacionaisBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Rotina006ArcosOcupacionais getRotina() {
        return rotina;
    }

    public void setRotina(Rotina006ArcosOcupacionais rotina) {
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

    public Rotina006ArcosOcupacionaisMateriais getArcoOcupacionalMaterial() {
        return arcoOcupacionalMaterial;
    }

    public void setArcoOcupacionalMaterial(Rotina006ArcosOcupacionaisMateriais arcoOcupacionalMaterial) {
        this.arcoOcupacionalMaterial = arcoOcupacionalMaterial;
    }

    public List<Rotina006ArcosOcupacionaisMateriais> getMateriais() {
        return materiais;
    }

    public void setMateriais(List<Rotina006ArcosOcupacionaisMateriais> materiais) {
        this.materiais = materiais;
    }

    public List<String> getIsArcoAFechado() {
        return isArcoAFechado;
    }

    public void setIsArcoAFechado(List<String> isArcoAFechado) {
        this.isArcoAFechado = isArcoAFechado;
    }

    public List<String> getIsArcoBFechado() {
        return isArcoBFechado;
    }

    public void setIsArcoBFechado(List<String> isArcoBFechado) {
        this.isArcoBFechado = isArcoBFechado;
    }

    public List<String> getIsArcoCFechado() {
        return isArcoCFechado;
    }

    public void setIsArcoCFechado(List<String> isArcoCFechado) {
        this.isArcoCFechado = isArcoCFechado;
    }

    public List<String> getIsArcoDFechado() {
        return isArcoDFechado;
    }

    public void setIsArcoDFechado(List<String> isArcoDFechado) {
        this.isArcoDFechado = isArcoDFechado;
    }

    public List<String> getIsArcoEFechado() {
        return isArcoEFechado;
    }

    public void setIsArcoEFechado(List<String> isArcoEFechado) {
        this.isArcoEFechado = isArcoEFechado;
    }

    /**
     * @return the listaNucleos
     */
    public List<Nucleo> getListaNucleos() {
        return listaNucleos;
    }

    /**
     * @param listaNucleos the listaNucleos to set
     */
    public void setListaNucleos(List<Nucleo> listaNucleos) {
        this.listaNucleos = listaNucleos;
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
