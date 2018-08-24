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
import projovem.dao.MaterialDAO;
import projovem.dao.Rotina006DAO;
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
public class Rotina006ArcosOcupacionaisV3Bean implements Serializable {

    @Resource
    private UserTransaction utx;
    @PersistenceUnit(unitName = "projovemPU")
    private EntityManagerFactory emf;
    private InstrumentoController controller = new InstrumentoController();
    private Rotina006ArcosOcupacionaisV3 rotina = new Rotina006ArcosOcupacionaisV3();
    private List<SelectItem> listaArcos = new ArrayList<SelectItem>();
    private ArcoDAO arcoDAO = new ArcoDAO();
    private Rotina006DAO rotinaDao = new Rotina006DAO();
    private Rotina006ArcosQuest rotina006Questionario = new Rotina006ArcosQuest();
    private List<Rotina006ArcosQuest> questionarios = new ArrayList<Rotina006ArcosQuest>();
    private List<String> isArcoAFechado = new ArrayList<String>();
    private List<String> isArcoBFechado = new ArrayList<String>();
    private List<String> isArcoCFechado = new ArrayList<String>();
    private List<String> isArcoDFechado = new ArrayList<String>();
    private List<String> isArcoEFechado = new ArrayList<String>();
    private List<String> isMaterialSelecionado = new ArrayList<String>();
    private LocalReferenciaVO localReferencia = new LocalReferenciaVO();
    private List<Material> listaMateriais = new ArrayList<Material>();
    private List<Nucleo> listaNucleos = new ArrayList<Nucleo>();
    private String usuarioResponsavel;
    private String cpfResponsavel;
    private String arcoObservado;
    private Material materialEscolhido;
    private Boolean isRenderedQuestionario;

    public void arcoDefinido() {
        List<Material> listaMaterial = new ArrayList<Material>();
        MaterialDAO materialDAO = new MaterialDAO();
        listaMaterial = materialDAO.getByArco(rotina006Questionario.getArcoOcupacional(), emf);
        for (Material material : listaMaterial) {
            Material m = new Material();
            m.setArco(material.getArco());
            m.setId(material.getId());
            m.setNome(material.getNome());
            m.setSelecionado(material.getSelecionado());
            getListaMateriais().add(m);
        }
        //rotina006Questionario.setMaterialUtilizado(listaMaterialQuestionarios);
        if(getListaMateriais().size() != 0){
            isRenderedQuestionario = true;
        }else{
            isRenderedQuestionario = true;
        }
    }

    public LocalReferenciaVO getLocalReferencia() {
        return localReferencia;
    }

    public void setLocalReferencia(LocalReferenciaVO localReferencia) {
        this.localReferencia = localReferencia;
    }

    public void editar() {
        isRenderedQuestionario = true;
    }

    public void adicionarQuestionario(){
        System.out.println("Entrou aqui.....");
        if (!questionarios.contains(rotina006Questionario)) {
            for (Material material : listaMateriais) {
                if(material.getSelecionado() != null){
                    if(material.getSelecionado().equals("selecionado")){
                        if(rotina006Questionario.getMaterialUtilizado() != null){
                            rotina006Questionario.setMaterialUtilizado(material.getNome() + ";");
                        }else{
                            rotina006Questionario.setMaterialUtilizado(rotina006Questionario.getMaterialUtilizado() + material.getNome() + ";");
                        }
                    }
                }
            }
            questionarios.add(rotina006Questionario);
            rotina.setQuestionarioEducador(questionarios);
        }
        rotina006Questionario = new Rotina006ArcosQuest();
        listaMateriais.clear();
        isRenderedQuestionario = true;
    }

    public void adicionarMaterial() {
        int index = listaMateriais.indexOf(materialEscolhido);
        System.out.println(materialEscolhido.getNome());
        Material material = listaMateriais.get(index);

        if (material.getSelecionado() != null && material.getSelecionado().equals("selecionado")) {
            material.setSelecionado("");
        } else {

            if (material.getSelecionado() == null || material.getSelecionado().equals("")) {
                material.setSelecionado("selecionado");
            }
        }
    }

    public void removerMaterial() {
        questionarios.remove(rotina006Questionario);
        setRotina006Questionario(new Rotina006ArcosQuest());
    }

    /** Creates a new instance of Rotina006ArcosOcupacionaisV3Bean */
    public Rotina006ArcosOcupacionaisV3Bean() {
        localReferencia = new LocalReferenciaVO();
    }

    public String salvarRotina() {

        System.out.println("salvando...");
        Usuario currentUser = controller.obterUsuarioLogado();
        rotina.setUsuario(currentUser);
        rotina.setDadosValidos("0");
        rotina.setDadosEditados("0");

        rotina = localReferencia.obterDadosLocal(rotina);

        rotina.setQ10Fechado("false");
        rotina.setQ11Fechado("false");
        rotina.setQ12Fechado("false");
        rotina.setQ13Fechado("false");
        rotina.setQ14Fechado("false");

        if (isArcoAFechado != null && isArcoAFechado.size() > 0 && isArcoAFechado.get(0).equals("fechado")) {
        rotina.setQ10Fechado("true");
        }
        if (isArcoBFechado != null && isArcoBFechado.size() > 0 && isArcoBFechado.get(0).equals("fechado")) {
        rotina.setQ11Fechado("true");
        }
        if (isArcoCFechado != null && isArcoCFechado.size() > 0 && isArcoCFechado.get(0).equals("fechado")) {
        rotina.setQ12Fechado("true");
        }
        if (isArcoDFechado != null && isArcoDFechado.size() > 0 && isArcoDFechado.get(0).equals("fechado")) {
        rotina.setQ13Fechado("true");
        }
        if (isArcoEFechado != null && isArcoEFechado.size() > 0 && isArcoEFechado.get(0).equals("fechado")) {
        rotina.setQ14Fechado("true");
        }

        //rotina006Questionario.setMaterialUtilizado(getListaMaterialUtilizado());
        //rotina.setQuestionarioEducador(questionarios);

        String retorno = "";
        if (ValidacaoArcosOcupacionaisV3.validaRotina(rotina)) {
            try {
                rotinaDao.saveRotinaQPArcosOcupacionaisV3(rotina, emf, utx);
                setUsuarioResponsavel(rotina.getUsuario().getNome());
                setCpfResponsavel(rotina.getUsuario().getCpf());
                retorno = "Rotina006ArcosOcupacionaisV3Salva";
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

        rotina = rotinaDao.getArcosOcupacionaisV3ById(idRotinaEscolhida, emf);

        rotina.setUsrResponsavelValidacao(controller.obterUsuarioLogado().getId());
        rotina.setDadosValidos(dadosValidos);
        Usuario u = new Usuario();
        rotina.setDataValidacao(u.getDataAtual());
        rotina.setHoraValidacao(u.getHoraAtual());
        
        try {
            rotinaDao.validarDadosArcosOcupacionaisV3(rotina, emf, utx);
        }catch (Exception ex) {
                String message = "Houve um erro na gravação dos dados. Sua rotina não foi validada. Por favor, tente novamente.";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                ex.printStackTrace();
                Logger.getLogger(Rotina006ArcosOcupacionaisBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Rotina006ArcosOcupacionaisV3 getRotina() {
        return rotina;
    }

    public void setRotina(Rotina006ArcosOcupacionaisV3 rotina) {
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

    public List<Rotina006ArcosQuest> getQuestionarios() {
        return questionarios;
    }

    public void setQuestionarios(List<Rotina006ArcosQuest> questionarios) {
        this.questionarios = questionarios;
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

    /**
     * @return the rotina006Questionario
     */
    public Rotina006ArcosQuest getRotina006Questionario() {
        return rotina006Questionario;
    }

    /**
     * @param rotina006Questionario the rotina006Questionario to set
     */
    public void setRotina006Questionario(Rotina006ArcosQuest rotina006Questionario) {
        this.rotina006Questionario = rotina006Questionario;
    }

    /**
     * @return the arcoObservado
     */
    public String getArcoObservado() {
        return arcoObservado;
    }

    /**
     * @param arcoObservado the arcoObservado to set
     */
    public void setArcoObservado(String arcoObservado) {
        this.arcoObservado = arcoObservado;
    }

    /**
     * @return the isMaterialSelecionado
     */
    public List<String> getIsMaterialSelecionado() {
        return isMaterialSelecionado;
    }

    /**
     * @param isMaterialSelecionado the isMaterialSelecionado to set
     */
    public void setIsMaterialSelecionado(List<String> isMaterialSelecionado) {
        this.isMaterialSelecionado = isMaterialSelecionado;
    }

    /**
     * @return the materialEscolhido
     */
    public Material getMaterialEscolhido() {
        return materialEscolhido;
    }

    /**
     * @param materialEscolhido the materialEscolhido to set
     */
    public void setMaterialEscolhido(Material materialEscolhido) {
        this.materialEscolhido = materialEscolhido;
    }

    /**
     * @return the isRenderedQuestionario
     */
    public Boolean getIsRenderedQuestionario() {
        return isRenderedQuestionario;
    }

    /**
     * @param isRenderedQuestionario the isRenderedQuestionario to set
     */
    public void setIsRenderedQuestionario(Boolean isRenderedQuestionario) {
        this.isRenderedQuestionario = isRenderedQuestionario;
    }

    /**
     * @return the listaMateriais
     */
    public List<Material> getListaMateriais() {
        return listaMateriais;
    }

    /**
     * @param listaMateriais the listaMateriais to set
     */
    public void setListaMateriais(List<Material> listaMateriais) {
        this.listaMateriais = listaMateriais;
    }
}
