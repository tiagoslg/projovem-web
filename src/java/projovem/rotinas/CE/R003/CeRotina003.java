/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projovem.rotinas.CE.R003;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import projovem.entity.MaterialUtilizado;
import projovem.entity.Usuario;
import projovem.nucleo.Nucleo;

/**
 *
 * @author admprojovem
 */
@Entity
@Table
public class CeRotina003 implements Serializable {

    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Integer id;

    @Column(nullable = true, length = 250)
    private String nomeLocal;
    @Column(nullable = true, length = 250)
    private String enderecoLocal;
    @Column(nullable = true, length = 250)
    private String bairroLocal;
    @Column(nullable = true, length = 250)
    private String numeroLocal;
    @Column(nullable = true, length = 250)
    private String complementoLocal;
    @Column(nullable = true, length = 250)
    private String cidadeLocal;
    @Column(nullable = true, length = 250)
    private String ufLocal;
    @Column(nullable = true, length = 250)
    private String cepLocal;
    @Column(nullable = true, length = 250)
    private String telefoneLocal;

    //Cabeçalho
    @OneToOne
    private Usuario usuario;
    @OneToOne
    private Nucleo nucleo;
    @Column(nullable = true)
    private String dataInsercao;
    @Column(nullable = true)
    private String horaInsercao;
    @Column(nullable = true, length = 250)
    private String identificaEntradaUf;
    @Column(nullable = true, length = 250)
    private String identificaEntradaCoordenacao;
    @Column(nullable = true, length = 250)
    private String identificaEntradaMunicipio;
    @Column(nullable = true, length = 250)
    private String identificaEntradaEntrada;
    @Column(nullable = true, length = 3)
    private String identificaEntradaObservacao;

    @Column(nullable = true)
    private String dataVisita;
    @Column(nullable = true, length = 250)
    private String horaInicioVisita;
    @Column(nullable = true, length = 250)
    private String horaTerminoVisita;
    @Column(nullable = true, length = 250)
    private String Q1;
    @Column(nullable = true, length = 250)
    private String Q2;
    @Column(nullable = true, length = 250)
    private String Q3;
    @Column(nullable = true, length = 250)
    private String Q5;
    @Column(nullable = true, length = 250)
    private String Q6;
    @Column(nullable = true, length = 250)
    private String Q7;
    @Column(nullable = true, length = 250)
    private String Q8;
    @Column(nullable = true, length = 250)
    private String Q9;

    @Column(nullable = true, length = 250)
    private String Q11;
    @Column(nullable = true, length = 1000)
    private String Q11Complemento;

    @OneToMany(fetch=FetchType.LAZY)
    private List<MaterialUtilizado> materialUtilizado;
    
    @ManyToMany(fetch=FetchType.LAZY)
    private List<Nucleo> nucleoAtendido;

    private String dadosValidos;
    @Column(nullable = true)
    private Integer usrResponsavelValidacao;
    @Column(nullable = true)
    private String dataValidacao;
    @Column(nullable = true)
    private String horaValidacao;

    @Column(nullable = true)
    private String dadosEditados;
    @Column(nullable = true)
    private Integer usrResponsavelEdicao;
    @Column(nullable = true)
    private String dataEdicao;
    @Column(nullable = true)
    private String horaEdicao;

    @Column(nullable = true)
    private Integer versaoFormulario;

    public Integer getVersaoFormulario() {
        return versaoFormulario;
    }

    public void setVersaoFormulario(Integer versaoFormulario) {
        this.versaoFormulario = versaoFormulario;
    }

    public String getQ1() {
        return Q1;
    }

    public void setQ1(String Q1) {
        this.Q1 = Q1;
    }

    public String getQ11() {
        return Q11;
    }

    public void setQ11(String Q11) {
        this.Q11 = Q11;
    }

    public String getQ11Complemento() {
        return Q11Complemento;
    }

    public void setQ11Complemento(String Q11Complemento) {
        this.Q11Complemento = Q11Complemento;
    }

    public String getQ2() {
        return Q2;
    }

    public void setQ2(String Q2) {
        this.Q2 = Q2;
    }

    public String getQ3() {
        return Q3;
    }

    public void setQ3(String Q3) {
        this.Q3 = Q3;
    }

    public String getQ5() {
        return Q5;
    }

    public void setQ5(String Q5) {
        this.Q5 = Q5;
    }

    public String getQ6() {
        return Q6;
    }

    public void setQ6(String Q6) {
        this.Q6 = Q6;
    }

    public String getQ7() {
        return Q7;
    }

    public void setQ7(String Q7) {
        this.Q7 = Q7;
    }

    public String getQ8() {
        return Q8;
    }

    public void setQ8(String Q8) {
        this.Q8 = Q8;
    }

    public String getQ9() {
        return Q9;
    }

    public void setQ9(String Q9) {
        this.Q9 = Q9;
    }

    public String getDataInsercao() {
        return dataInsercao;
    }

    public void setDataInsercao(String dataInsercao) {
        this.dataInsercao = dataInsercao;
    }

    public String getDataVisita() {
        return dataVisita;
    }

    public void setDataVisita(String dataVisita) {
        this.dataVisita = dataVisita;
    }

    public String getHoraInicioVisita() {
        return horaInicioVisita;
    }

    public void setHoraInicioVisita(String horaInicioVisita) {
        this.horaInicioVisita = horaInicioVisita;
    }

    public String getHoraInsercao() {
        return horaInsercao;
    }

    public void setHoraInsercao(String horaInsercao) {
        this.horaInsercao = horaInsercao;
    }

    public String getHoraTerminoVisita() {
        return horaTerminoVisita;
    }

    public void setHoraTerminoVisita(String horaTerminoVisita) {
        this.horaTerminoVisita = horaTerminoVisita;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdentificaEntradaCoordenacao() {
        return identificaEntradaCoordenacao;
    }

    public void setIdentificaEntradaCoordenacao(String identificaEntradaCoordenacao) {
        this.identificaEntradaCoordenacao = identificaEntradaCoordenacao;
    }

    public String getIdentificaEntradaEntrada() {
        return identificaEntradaEntrada;
    }

    public void setIdentificaEntradaEntrada(String identificaEntradaEntrada) {
        this.identificaEntradaEntrada = identificaEntradaEntrada;
    }

    public String getIdentificaEntradaMunicipio() {
        return identificaEntradaMunicipio;
    }

    public void setIdentificaEntradaMunicipio(String identificaEntradaMunicipio) {
        this.identificaEntradaMunicipio = identificaEntradaMunicipio;
    }

    public String getIdentificaEntradaUf() {
        return identificaEntradaUf;
    }

    public void setIdentificaEntradaUf(String identificaEntradaUf) {
        this.identificaEntradaUf = identificaEntradaUf;
    }

    public Nucleo getNucleo() {
        return nucleo;
    }

    public void setNucleo(Nucleo nucleo) {
        this.nucleo = nucleo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }



    /**
     * @return the materialUtilizado
     */
    public List<MaterialUtilizado> getMaterialUtilizado() {
        return materialUtilizado;
    }

    /**
     * @param materialUtilizado the materialUtilizado to set
     */
    public void setMaterialUtilizado(List<MaterialUtilizado> materialUtilizado) {
        this.materialUtilizado = materialUtilizado;
    }

    /**
     * @return the nucleoAtendido
     */
    public List<Nucleo> getNucleoAtendido() {
        return nucleoAtendido;
    }

    /**
     * @param nucleoAtendido the nucleoAtendido to set
     */
    public void setNucleoAtendido(List<Nucleo> nucleoAtendido) {
        this.nucleoAtendido = nucleoAtendido;
    }

    public String getBairroLocal() {
        return bairroLocal;
    }

    public void setBairroLocal(String bairroLocal) {
        this.bairroLocal = bairroLocal;
    }

    public String getCepLocal() {
        return cepLocal;
    }

    public void setCepLocal(String cepLocal) {
        this.cepLocal = cepLocal;
    }

    public String getCidadeLocal() {
        return cidadeLocal;
    }

    public void setCidadeLocal(String cidadeLocal) {
        this.cidadeLocal = cidadeLocal;
    }

    public String getComplementoLocal() {
        return complementoLocal;
    }

    public void setComplementoLocal(String complementoLocal) {
        this.complementoLocal = complementoLocal;
    }

    public String getEnderecoLocal() {
        return enderecoLocal;
    }

    public void setEnderecoLocal(String enderecoLocal) {
        this.enderecoLocal = enderecoLocal;
    }

    public String getNomeLocal() {
        return nomeLocal;
    }

    public void setNomeLocal(String nomeLocal) {
        this.nomeLocal = nomeLocal;
    }

    public String getNumeroLocal() {
        return numeroLocal;
    }

    public void setNumeroLocal(String numeroLocal) {
        this.numeroLocal = numeroLocal;
    }

    public String getTelefoneLocal() {
        return telefoneLocal;
    }

    public void setTelefoneLocal(String telefoneLocal) {
        this.telefoneLocal = telefoneLocal;
    }

    public String getUfLocal() {
        return ufLocal;
    }

    public void setUfLocal(String ufLocal) {
        this.ufLocal = ufLocal;
    }

    /**
     * @return the dadosValidos
     */
    public String getDadosValidos() {
        return dadosValidos;
    }

    /**
     * @param dadosValidos the dadosValidos to set
     */
    public void setDadosValidos(String dadosValidos) {
        this.dadosValidos = dadosValidos;
    }

    /**
     * @return the usrResponsavelValidacao
     */
    public Integer getUsrResponsavelValidacao() {
        return usrResponsavelValidacao;
    }

    /**
     * @param usrResponsavelValidacao the usrResponsavelValidacao to set
     */
    public void setUsrResponsavelValidacao(Integer usrResponsavelValidacao) {
        this.usrResponsavelValidacao = usrResponsavelValidacao;
    }

    /**
     * @return the dataValidacao
     */
    public String getDataValidacao() {
        return dataValidacao;
    }

    /**
     * @param dataValidacao the dataValidacao to set
     */
    public void setDataValidacao(String dataValidacao) {
        this.dataValidacao = dataValidacao;
    }

    /**
     * @return the horaValidacao
     */
    public String getHoraValidacao() {
        return horaValidacao;
    }

    /**
     * @param horaValidacao the horaValidacao to set
     */
    public void setHoraValidacao(String horaValidacao) {
        this.horaValidacao = horaValidacao;
    }

    /**
     * @return the identificaEntradaObservacao
     */
    public String getIdentificaEntradaObservacao() {
        return identificaEntradaObservacao;
    }

    /**
     * @param identificaEntradaObservacao the identificaEntradaObservacao to set
     */
    public void setIdentificaEntradaObservacao(String identificaEntradaObservacao) {
        this.identificaEntradaObservacao = identificaEntradaObservacao;
    }

    /**
     * @return the dadosEditados
     */
    public String getDadosEditados() {
        return dadosEditados;
    }

    /**
     * @param dadosEditados the dadosEditados to set
     */
    public void setDadosEditados(String dadosEditados) {
        this.dadosEditados = dadosEditados;
    }

    /**
     * @return the usrResponsavelEdicao
     */
    public Integer getUsrResponsavelEdicao() {
        return usrResponsavelEdicao;
    }

    /**
     * @param usrResponsavelEdicao the usrResponsavelEdicao to set
     */
    public void setUsrResponsavelEdicao(Integer usrResponsavelEdicao) {
        this.usrResponsavelEdicao = usrResponsavelEdicao;
    }

    /**
     * @return the dataEdicao
     */
    public String getDataEdicao() {
        return dataEdicao;
    }

    /**
     * @param dataEdicao the dataEdicao to set
     */
    public void setDataEdicao(String dataEdicao) {
        this.dataEdicao = dataEdicao;
    }

    /**
     * @return the horaEdicao
     */
    public String getHoraEdicao() {
        return horaEdicao;
    }

    /**
     * @param horaEdicao the horaEdicao to set
     */
    public void setHoraEdicao(String horaEdicao) {
        this.horaEdicao = horaEdicao;
    }


    
}
