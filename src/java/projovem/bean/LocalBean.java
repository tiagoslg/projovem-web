/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package projovem.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.servlet.http.HttpSession;
import javax.transaction.UserTransaction;
import projovem.dao.CepDAO;
import projovem.dao.LocalDAO;
import projovem.entity.Cep;
import projovem.entity.CepInformado;
import projovem.entity.Endereco;
import projovem.entity.Instrumento;
import projovem.entity.Local;
import projovem.entity.Usuario;
import projovem.vo.LocalVO;



/**
 *
 * @author admprojovem
 */
public class LocalBean implements Serializable {

    @Resource
    private UserTransaction utx ;
    @PersistenceUnit(unitName = "projovemPU")
    private EntityManagerFactory emf;

    private CepDAO cepDao = new CepDAO();
    private LocalDAO localDAO = new LocalDAO();

    private Endereco endereco = new Endereco();
    private Instrumento instrumento = new Instrumento();
    private LocalVO localVO = new LocalVO();
    

    private String cep;
    private String nomeNucleo;
    private String justificativa;


    
    private boolean renderedResultadoPesquisa;

    public void alterarDados(){
        endereco = localVO.getEndereco();
        nomeNucleo = localVO.getNome();
        cep = localVO.getEndereco().getCep().getNumero();
        renderedResultadoPesquisa= true;
    }
    public void salvarLocal(){
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);

        Object currentUser = session.getAttribute("currentUser");
        renderedResultadoPesquisa  = false;

        List<Endereco> enderecos = new ArrayList<Endereco>();
        endereco.getCep().setNumero(cep);
        enderecos.add(endereco);

        Local local = new Local();
        local.setId(localVO.getId());
        local.setNome(nomeNucleo);
        local.setEnderecos(enderecos);
        local.setJustificativa(justificativa);
        local.setUsuario((Usuario) currentUser);
        local.setTipoLocal(instrumento.getAplicadoEmLocaisDoTipo());

        localDAO.salvar(emf,utx,local);
    }
    public void pesquisarCep(){
        Cep cepPesquisado = new Cep();
        cepPesquisado=cepDao.getByCep(emf, cep);
        CepInformado cepInformado = new CepInformado();
        cepInformado.setBairro(cepPesquisado.getBairro());
        cepInformado.setCidade(cepPesquisado.getCidade());
        cepInformado.setLogradouro(cepPesquisado.getLogradouro());
        cepInformado.setUf(cepPesquisado.getUf());

        getEndereco().setCep(cepInformado);

        setRenderedResultadoPesquisa(true);
    }

    /**
     * @return the cep
     */
    public String getCep() {
        return cep;
    }

    /**
     * @param cep the cep to set
     */
    public void setCep(String cep) {
        this.cep = cep;
    }



    /**
     * @return the renderedResultadoPesquisa
     */
    public boolean isRenderedResultadoPesquisa() {
        return renderedResultadoPesquisa;
    }

    /**
     * @param renderedResultadoPesquisa the renderedResultadoPesquisa to set
     */
    public void setRenderedResultadoPesquisa(boolean renderedResultadoPesquisa) {
        this.renderedResultadoPesquisa = renderedResultadoPesquisa;
    }

    /**
     * @return the endereco
     */
    public Endereco getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    /**
     * @return the nomeNucleo
     */
    public String getNomeNucleo() {
        return nomeNucleo;
    }

    /**
     * @param nomeNucleo the nomeNucleo to set
     */
    public void setNomeNucleo(String nomeNucleo) {
        this.nomeNucleo = nomeNucleo;
    }

    /**
     * @return the justificativa
     */
    public String getJustificativa() {
        return justificativa;
    }

    /**
     * @param justificativa the justificativa to set
     */
    public void setJustificativa(String justificativa) {
        this.justificativa = justificativa;
    }

    /**
     * @return the instrumento
     */
    public Instrumento getInstrumento() {
        return instrumento;
    }

    /**
     * @param instrumento the instrumento to set
     */
    public void setInstrumento(Instrumento instrumento) {
        this.instrumento = instrumento;
    }

    /**
     * @return the localVO
     */
    public LocalVO getLocalVO() {
        return localVO;
    }

    /**
     * @param localVO the localVO to set
     */
    public void setLocalVO(LocalVO localVO) {
        this.localVO = localVO;
    }



    
    
}
