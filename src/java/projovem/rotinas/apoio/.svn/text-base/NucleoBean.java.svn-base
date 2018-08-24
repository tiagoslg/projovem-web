/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projovem.rotinas.apoio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.transaction.UserTransaction;
import projovem.controller.InstrumentoController;
import projovem.dao.CepDAO;
import projovem.dao.NucleoDAO;
import projovem.dao.UsuarioDAO;
import projovem.entity.Cep;
import projovem.nucleo.Nucleo;

/**
 *
 * @author admprojovem
 */
public class NucleoBean implements Serializable {

    @Resource
    private UserTransaction utx;
    @PersistenceUnit(unitName = "projovemPU")
    private EntityManagerFactory emf;
    private Nucleo nucleoEscolhido;
    private String ufEscolhida;
    private String coordenacaoEscolhida;
    private String municipioEscolhida;
    private String entradaEscolhida;
    private String rotinaEscolhida;
    private List<SelectItem> ufPossiveis = new ArrayList<SelectItem>();
    private List<SelectItem> coordenacoesPossiveis = new ArrayList<SelectItem>();
    private List<SelectItem> coordenacoesPossiveisCe = new ArrayList<SelectItem>();
    private List<SelectItem> municipiosPossiveis = new ArrayList<SelectItem>();
    private List<SelectItem> entradasPossiveis = new ArrayList<SelectItem>();
    private List<Nucleo> listaNucleos = new ArrayList<Nucleo>();
    private InstrumentoController controller = new InstrumentoController();
    private NucleoDAO nucleoDAO = new NucleoDAO();
    private boolean renderedCoordenacao = false;
    private boolean renderedIdentificaLocal = true;
    private boolean renderedListaNucleos = false;
    private boolean renderedEntrada = false;
    private boolean renderedMunicipio = false;
    private boolean renderedIdentificaLocalReferencia = false;
    private boolean renderedClassificacaoLocal = false;
    private boolean renderedQuestionario = false;
    private boolean renderedCepInformado = false;
    private boolean disableMunicipios = false;
    private CepDAO cepDao = new CepDAO();
    private LocalReferenciaVO local = new LocalReferenciaVO();
    private boolean renderedCampos = false;
    UsuarioDAO dao = new UsuarioDAO();
    private String tipoFormulario = "";

    public String cadastraNucleo() {
        coordenacaoEscolhida = "";
        return "cadastraNucleo";
    }

    public String cadastraNucleoCe() {

        coordenacaoEscolhida = "";
        return "cadastraNucleoCe";
    }

    public void cepInformado() {

        Cep cep = cepDao.getByCep(emf, local.getCepLocal());
        renderedCepInformado = false;
        if (cep != null && cep.getUf() != null && !cep.getUf().isEmpty()) {
            ufPossiveis = nucleoDAO.obterUfPossiveis(emf);
            boolean cepPermitido = false;
            for (SelectItem selectItem : ufPossiveis) {
                if (!cepPermitido && selectItem.getLabel().equals(cep.getUf())) {
                    cepPermitido = true;
                }
            }
            if (cepPermitido) {
                ufEscolhida = cep.getUf();

                if (tipoFormulario.equals("ESTADUAL")) {
                    obtemCoordenacoesEstaduais();
                } else {
                    obtemCoordenacoes();
                }

                coordenacaoEscolhida = nucleoDAO.obtemCoordenacaoByMunicipioAndUF(cep.getCidade(),cep.getUf(), emf);
                
                if (tipoFormulario.equals("ESTADUAL") && coordenacaoEscolhida.contains("Municipal") && !rotinaEscolhida.equals("Rotina004")) {

                    coordenacaoEscolhida = "";
                }

                
                if (coordenacaoEscolhida.isEmpty()) {
                    String message = "";
                    if (tipoFormulario.equals("ESTADUAL")) {
                        message = "O cep informado não é de uma coordenação Estadual";

                    } else {
                        message = "O município " + cep.getCidade() + " não é uma coordenação municipal";
                    }

                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
                } else {
                    if(rotinaEscolhida != null && !rotinaEscolhida.isEmpty()){
                        if(rotinaEscolhida.equals("Rotina004") && tipoFormulario.equals("ESTADUAL")){
                            if(!coordenacaoEscolhida.equals(getCoordenacoesPossiveis().get(0).getLabel())){
                                coordenacaoEscolhida = getCoordenacoesPossiveis().get(0).getLabel();
                                setRotinaEscolhida("Rotina004D");
                            }
                        }
                    }else{
                        setRotinaEscolhida("OutrasRotinas");
                    }

                    obtemMunicipios();
                    if(getRotinaEscolhida().equals("Rotina004D")){
                        municipioEscolhida = "";
                        setDisableMunicipios(false);
                    }else{
                        municipioEscolhida = cep.getCidade().toUpperCase();
                        setDisableMunicipios(true);
                    }
                    
                    obtemEntradas();
                    renderedCepInformado = true;


                    local.setCidadeLocal(cep.getCidade());

                    local.setEnderecoLocal(cep.getLogradouro());
                    local.setBairroLocal(cep.getBairro());
                }
            } else {
                String message = "O cep informado não corresponde a uma localidade de sua IR.";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
            }


        } else {
            String message = "O cep informado não existe ou não consta em nossa base de dados. Os CEPs de alguns locais foram alterados recentemente. Caso não encontre o CEP procurado, favor conferir o mesmo no site dos Correios (http://www.correios.com.br).";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
        }
    }

    public void pesquisarCep() {
        Cep cepPesquisado = new Cep();
        cepPesquisado = cepDao.getByCep(emf, local.getCepLocal());

        local.setEnderecoLocal(cepPesquisado.getLogradouro());
        local.setBairroLocal(cepPesquisado.getBairro());
        local.setCidadeLocal(cepPesquisado.getCidade().toUpperCase());
        local.setUfLocal(cepPesquisado.getUf().toUpperCase());
        renderedCampos = true;
        setRenderedClassificacaoLocal(true);
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
     * @return the renderedCampos
     */
    public boolean isRenderedCampos() {
        return renderedCampos;
    }

    /**
     * @param renderedCampos the renderedCampos to set
     */
    public void setRenderedCampos(boolean renderedCampos) {
        this.renderedCampos = renderedCampos;
    }

    public NucleoBean() {
    }

    public void entradaSelecionada() {
        renderedIdentificaLocalReferencia = true;
        if (tipoFormulario.equals("ESTADUAL")) {
            obtemNucleosCe();
        } else {
            obtemNucleos();
        }


    }

    public void seleciona() {
        renderedIdentificaLocal = false;
    }

    public void selecionaCE() {
        int index = listaNucleos.indexOf(nucleoEscolhido);
        Nucleo nucleoSelecionado = listaNucleos.get(index);
        //listaNucleos.remove(index);
        if (nucleoSelecionado.getSelecionado() != null && nucleoSelecionado.getSelecionado().equals("selecionado")) {
            nucleoSelecionado.setSelecionado("");
        } else {

            if (nucleoSelecionado.getSelecionado() == null || nucleoSelecionado.getSelecionado().equals("")) {
                nucleoSelecionado.setSelecionado("selecionado");
            }
        }


        //listaNucleos.add(nucleoSelecionado);
    }

    public void alterarNucleoSelecionado() {
        renderedIdentificaLocal = true;
    }

    public void obtemCoordenacoes() {
        renderedCoordenacao = true;

        renderedMunicipio = false;
        renderedIdentificaLocalReferencia = false;
        renderedEntrada = false;
        setCoordenacoesPossiveis(nucleoDAO.obtemCoordenacoesByUF(ufEscolhida, emf));
    }

    public void obtemCoordenacoesEstaduais() {
        obtemCoordenacoes();
        setCoordenacoesPossiveis(nucleoDAO.obtemCoordenacoesEstaduaisByUF(ufEscolhida, emf));
    }

    public void obtemMunicipios() {
        
        renderedMunicipio = true;
        renderedEntrada = false;
        renderedIdentificaLocalReferencia = false;
        setMunicipiosPossiveis(nucleoDAO.obtemMunicipiosByCoordenacao(coordenacaoEscolhida, emf));
        
    }

    public void obtemEntradas() {
        renderedEntrada = true;
        renderedIdentificaLocalReferencia = false;
        if(getRotinaEscolhida() == null){
            setRotinaEscolhida("outrasRotinas");
        }
        System.out.println(getRotinaEscolhida());
        if(getRotinaEscolhida().equals("Rotina004D")){
            entradasPossiveis = nucleoDAO.obtemEntradasByCoordenacao(coordenacaoEscolhida, emf);
        }else{
            entradasPossiveis = nucleoDAO.obtemEntradasByMunicipio(municipioEscolhida, emf);
        }
    }
    public void obtemEntradasPorCoordenacao() {
        renderedEntrada = true;
        renderedIdentificaLocalReferencia = false;
        entradasPossiveis = nucleoDAO.obtemEntradasByCoordenacao(coordenacaoEscolhida, emf);
    }

    public void obtemEntradasCe() {
        renderedEntrada = true;
        renderedIdentificaLocalReferencia = false;
        entradasPossiveis = nucleoDAO.obtemEntradasByCoordenacao(coordenacaoEscolhida, emf);
        ufEscolhida = nucleoDAO.obtemUfByCoordenacoesEstaduais(coordenacaoEscolhida, emf);
    }

    public void obtemNucleosCe() {
        renderedIdentificaLocalReferencia = true;
        listaNucleos = nucleoDAO.obtemNucleosByMunicipio(municipioEscolhida, emf);
    }

    public void obtemNucleos() {
        listaNucleos = nucleoDAO.obtemNucleosByCoordenacao(coordenacaoEscolhida, emf);
    }
    public void obtemNucleosPorEntrada() {
        listaNucleos = nucleoDAO.obtemNucleosByCoordenacaoAndEntrada(coordenacaoEscolhida,entradaEscolhida, emf);
    }

    public String getCoordenacaoEscolhida() {
        return coordenacaoEscolhida;
    }

    public void setCoordenacaoEscolhida(String coordenacaoEscolhida) {
        this.coordenacaoEscolhida = coordenacaoEscolhida;
    }

    public String getMunicipioEscolhida() {
        return municipioEscolhida;
    }

    public void setMunicipioEscolhida(String municipioEscolhida) {
        this.municipioEscolhida = municipioEscolhida;
    }

    public Nucleo getNucleoEscolhido() {
        return nucleoEscolhido;
    }

    public void setNucleoEscolhido(Nucleo nucleoEscolhido) {
        this.nucleoEscolhido = nucleoEscolhido;
    }

    public String getUfEscolhida() {
        return ufEscolhida;
    }

    public void setUfEscolhida(String ufEscolhida) {
        this.ufEscolhida = ufEscolhida;
    }

    public List<SelectItem> getUfPossiveis() {

        ufPossiveis = nucleoDAO.obterUfPossiveis(emf);


        return ufPossiveis;
    }

    public void setUfPossiveis(List<SelectItem> ufPossiveis) {
        this.ufPossiveis = ufPossiveis;
    }

    /**
     * @return the coordenacoesPossiveis
     */
    public List<SelectItem> getCoordenacoesPossiveis() {
        return coordenacoesPossiveis;
    }

    /**
     * @param coordenacoesPossiveis the coordenacoesPossiveis to set
     */
    public void setCoordenacoesPossiveis(List<SelectItem> coordenacoesPossiveis) {
        this.coordenacoesPossiveis = coordenacoesPossiveis;
    }

    /**
     * @return the municipiosPossiveis
     */
    public List<SelectItem> getMunicipiosPossiveis() {
        return municipiosPossiveis;
    }

    /**
     * @param municipiosPossiveis the municipiosPossiveis to set
     */
    public void setMunicipiosPossiveis(List<SelectItem> municipiosPossiveis) {
        this.municipiosPossiveis = municipiosPossiveis;
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
     * @return the renderedCoordenacao
     */
    public boolean isRenderedCoordenacao() {
        return renderedCoordenacao;
    }

    /**
     * @param renderedCoordenacao the renderedCoordenacao to set
     */
    public void setRenderedCoordenacao(boolean renderedCoordenacao) {
        this.renderedCoordenacao = renderedCoordenacao;
    }

    public boolean isRenderedIdentificaLocal() {
        return renderedIdentificaLocal;
    }

    public void setRenderedIdentificaLocal(boolean renderedIdentificaLocal) {
        this.renderedIdentificaLocal = renderedIdentificaLocal;
    }

    /**
     * @return the renderedListaNucleos
     */
    public boolean isRenderedListaNucleos() {

        renderedListaNucleos = listaNucleos.size() > 0;

        return renderedListaNucleos;
    }

    /**
     * @param renderedListaNucleos the renderedListaNucleos to set
     */
    public void setRenderedListaNucleos(boolean renderedListaNucleos) {
        this.renderedListaNucleos = renderedListaNucleos;
    }

    public String getEntradaEscolhida() {
        return entradaEscolhida;
    }

    public void setEntradaEscolhida(String entradaEscolhida) {
        this.entradaEscolhida = entradaEscolhida;
    }

    public List<SelectItem> getEntradasPossiveis() {
        return entradasPossiveis;
    }

    public void setEntradasPossiveis(List<SelectItem> entradasPossiveis) {
        this.entradasPossiveis = entradasPossiveis;
    }

    public boolean isRenderedEntrada() {
        return renderedEntrada;
    }

    public void setRenderedEntrada(boolean renderedEntrada) {
        this.renderedEntrada = renderedEntrada;
    }

    public boolean isRenderedMunicipio() {
        return renderedMunicipio;
    }

    public void setRenderedMunicipio(boolean renderedMunicipio) {
        this.renderedMunicipio = renderedMunicipio;
    }

    /**
     * @return the renderedIdentificaLocalReferencia
     */
    public boolean isRenderedIdentificaLocalReferencia() {
        return renderedIdentificaLocalReferencia;
    }

    /**
     * @param renderedIdentificaLocalReferencia the renderedIdentificaLocalReferencia to set
     */
    public void setRenderedIdentificaLocalReferencia(boolean renderedIdentificaLocalReferencia) {
        this.renderedIdentificaLocalReferencia = renderedIdentificaLocalReferencia;
    }

    /**
     * @return the renderedClassificacaoLocal
     */
    public boolean isRenderedClassificacaoLocal() {
        return renderedClassificacaoLocal;
    }

    /**
     * @param renderedClassificacaoLocal the renderedClassificacaoLocal to set
     */
    public void setRenderedClassificacaoLocal(boolean renderedClassificacaoLocal) {
        this.renderedClassificacaoLocal = renderedClassificacaoLocal;
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
     * @return the coordenacoesPossiveisCe
     */
    public List<SelectItem> getCoordenacoesPossiveisCe() {
        if (coordenacoesPossiveisCe != null && coordenacoesPossiveisCe.size() == 0) {
            renderedCoordenacao = true;

            renderedMunicipio = false;
            renderedIdentificaLocalReferencia = false;
            renderedEntrada = false;


            coordenacoesPossiveisCe = (nucleoDAO.obtemCoordenacoesEstaduaisByIR(dao.getUsuarioLogado().getIr().toUpperCase(), emf));
        }
        return coordenacoesPossiveisCe;
    }

    /**
     * @param coordenacoesPossiveisCe the coordenacoesPossiveisCe to set
     */
    public void setCoordenacoesPossiveisCe(List<SelectItem> coordenacoesPossiveisCe) {
        this.coordenacoesPossiveisCe = coordenacoesPossiveisCe;
    }

    /**
     * @return the renderedCepInformado
     */
    public boolean isRenderedCepInformado() {
        return renderedCepInformado;
    }

    /**
     * @param renderedCepInformado the renderedCepInformado to set
     */
    public void setRenderedCepInformado(boolean renderedCepInformado) {
        this.renderedCepInformado = renderedCepInformado;
    }

    /**
     * @return the tipoFormulario
     */
    public String getTipoFormulario() {
        return tipoFormulario;
    }

    /**
     * @param tipoFormulario the tipoFormulario to set
     */
    public void setTipoFormulario(String tipoFormulario) {
        this.tipoFormulario = tipoFormulario;
    }

    /**
     * @return the rotinaEscolhida
     */
    public String getRotinaEscolhida() {
        return rotinaEscolhida;
    }

    /**
     * @param rotinaEscolhida the rotinaEscolhida to set
     */
    public void setRotinaEscolhida(String rotinaEscolhida) {
        this.rotinaEscolhida = rotinaEscolhida;
    }

    /**
     * @return the disableMunicipios
     */
    public boolean isDisableMunicipios() {
        return disableMunicipios;
    }

    /**
     * @param disableMunicipios the disableMunicipios to set
     */
    public void setDisableMunicipios(boolean disableMunicipios) {
        this.disableMunicipios = disableMunicipios;
    }
}
