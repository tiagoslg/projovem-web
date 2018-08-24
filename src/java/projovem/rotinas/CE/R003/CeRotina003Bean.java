/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projovem.rotinas.CE.R003;

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
import projovem.dao.CeRotina003DAO;
import projovem.dao.MaterialDAO;
import projovem.entity.Arco;
import projovem.entity.Material;
import projovem.entity.MaterialUtilizado;
import projovem.entity.Usuario;
import projovem.nucleo.Nucleo;
import projovem.rotinas.apoio.LocalReferenciaVO;

/**
 *
 * @author admprojovem
 */
public class CeRotina003Bean implements Serializable {

    @Resource
    private UserTransaction utx;
    @PersistenceUnit(unitName = "projovemPU")
    private EntityManagerFactory emf;
    private InstrumentoController controller = new InstrumentoController();
    private CeRotina003 rotina = new CeRotina003();
    private CeRotina003DAO rotinaDao = new CeRotina003DAO();
    private Nucleo nucleoEscolhido = new Nucleo();
    private List<SelectItem> listaArcos = new ArrayList<SelectItem>();
    private ArcoDAO arcoDAO = new ArcoDAO();
    private List<MaterialUtilizado> listaMaterialUtilizado = new ArrayList<MaterialUtilizado>();
    private List<Nucleo> listaNucleos = new ArrayList<Nucleo>();
    private LocalReferenciaVO local;
    private String usuarioResponsavel;
    private String cpfResponsavel;

    /** Creates a new instance of Rotina006Bean */
    public CeRotina003Bean() {
        local = new LocalReferenciaVO();
    }

    public void arcoDefinido() {
        listaMaterialUtilizado.clear();
        List<Material> listaMaterial = new ArrayList<Material>();
        MaterialDAO materialDAO = new MaterialDAO();
        listaMaterial = materialDAO.getByArco(rotina.getQ1(), emf);
        for (Material material : listaMaterial) {
            MaterialUtilizado m = new MaterialUtilizado();
            m.setMaterial(material);
            listaMaterialUtilizado.add(m);
        }

    }

    public String salvarRotina() {
        List<Nucleo> listaNucleosAtendidos = new ArrayList<Nucleo>();

        for (Nucleo nucleo : listaNucleos) {
            if (nucleo.getSelecionado() != null && nucleo.getSelecionado().equals("selecionado")) {
                listaNucleosAtendidos.add(nucleo);
            }
        }

        rotina = local.obterDadosLocal(rotina);

        rotina.setNucleoAtendido(listaNucleosAtendidos);
        Usuario currentUser = controller.obterUsuarioLogado();
        rotina.setUsuario(currentUser);
        rotina.setDadosValidos("0");
        rotina.setDadosEditados("0");

        rotina.setMaterialUtilizado(listaMaterialUtilizado);

        String retorno = "";
        if (ValidacaoCeR003.validaRotina(rotina)) {
            try {
                rotinaDao.saveCeRotina003(rotina, emf, utx);
                setUsuarioResponsavel(rotina.getUsuario().getNome());
                setCpfResponsavel(rotina.getUsuario().getCpf());
                retorno = "CeRotina003Salva";
            } catch (Exception ex) {
                String message = "Houve um erro na gravação dos dados. Sua rotia não foi salva. Por favor, tente novamente.";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                ex.printStackTrace();
                Logger.getLogger(CeRotina003Bean.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(CeRotina003Bean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public CeRotina003 getRotina() {
        return rotina;
    }

    public void setRotina(CeRotina003 rotina) {
        this.rotina = rotina;
    }

    public Nucleo getNucleoEscolhido() {
        return nucleoEscolhido;
    }

    public void setNucleoEscolhido(Nucleo nucleoEscolhido) {
        this.nucleoEscolhido = nucleoEscolhido;
    }

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
     * @return the listaMaterialUtilizado
     */
    public List<MaterialUtilizado> getListaMaterialUtilizado() {
        return listaMaterialUtilizado;
    }

    /**
     * @param listaMaterialUtilizado the listaMaterialUtilizado to set
     */
    public void setListaMaterialUtilizado(List<MaterialUtilizado> listaMaterialUtilizado) {
        this.listaMaterialUtilizado = listaMaterialUtilizado;
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
