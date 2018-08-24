/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package projovem.rotinas.R006;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import projovem.entity.Usuario;

/**
 *
 * @author admprojovem
 */
@Entity
@Table
public class Rotina006CoordenacaoLocal implements Serializable{
    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Integer id;

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

    //Cabeçalho
    @OneToOne
    private Usuario usuario;
    @Column(nullable = true)
    private String dataVisita;
    @Column(nullable = true, length = 250)
    private String horaInicioVisita;
    @Column(nullable = true, length = 250)
    private String horaTerminoVisita;
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
    @Column(nullable = true, length = 250)
    private String tipoCordenacao;

    //Questoes
    @Column(nullable = true, length = 250)
    private String Q1;
    @Column(nullable = true, length = 250)
    private String Q2;

    @Column(nullable = true, length = 250)
    private String Q3a;
    @Column(nullable = true, length = 250)
    private String Q3b;
    @Column(nullable = true, length = 250)
    private String Q3c;
    @Column(nullable = true, length = 250)
    private String Q3d;
    @Column(nullable = true, length = 250)
    private String Q3e;

    @Column(nullable = true)
    private String Q4a;
    @Column(nullable = true)
    private String Q4b;
    @Column(nullable = true)
    private String Q4c;
    @Column(nullable = true)
    private String Q4d;
    @Column(nullable = true)
    private String Q4e;

    @Column(nullable = true, length = 250)
    private String Q5;
    @Column(nullable = true, length = 250)
    private String Q5complemento;

    @Column(nullable = true)
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

    @OneToMany
    private List<Rotina006CoordenacaoLocalLocais> listaLocais;

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the dataVisita
     */
    public String getDataVisita() {
        return dataVisita;
    }

    /**
     * @param dataVisita the dataVisita to set
     */
    public void setDataVisita(String dataVisita) {
        this.dataVisita = dataVisita;
    }

    /**
     * @return the horaInicioVisita
     */
    public String getHoraInicioVisita() {
        return horaInicioVisita;
    }

    /**
     * @param horaInicioVisita the horaInicioVisita to set
     */
    public void setHoraInicioVisita(String horaInicioVisita) {
        this.horaInicioVisita = horaInicioVisita;
    }

    /**
     * @return the horaTerminoVisita
     */
    public String getHoraTerminoVisita() {
        return horaTerminoVisita;
    }

    /**
     * @param horaTerminoVisita the horaTerminoVisita to set
     */
    public void setHoraTerminoVisita(String horaTerminoVisita) {
        this.horaTerminoVisita = horaTerminoVisita;
    }

    /**
     * @return the nomeLocal
     */
    public String getNomeLocal() {
        return nomeLocal;
    }

    /**
     * @param nomeLocal the nomeLocal to set
     */
    public void setNomeLocal(String nomeLocal) {
        this.nomeLocal = nomeLocal;
    }

    /**
     * @return the enderecoLocal
     */
    public String getEnderecoLocal() {
        return enderecoLocal;
    }

    /**
     * @param enderecoLocal the enderecoLocal to set
     */
    public void setEnderecoLocal(String enderecoLocal) {
        this.enderecoLocal = enderecoLocal;
    }

    /**
     * @return the bairroLocal
     */
    public String getBairroLocal() {
        return bairroLocal;
    }

    /**
     * @param bairroLocal the bairroLocal to set
     */
    public void setBairroLocal(String bairroLocal) {
        this.bairroLocal = bairroLocal;
    }

    /**
     * @return the numeroLocal
     */
    public String getNumeroLocal() {
        return numeroLocal;
    }

    /**
     * @param numeroLocal the numeroLocal to set
     */
    public void setNumeroLocal(String numeroLocal) {
        this.numeroLocal = numeroLocal;
    }

    /**
     * @return the complementoLocal
     */
    public String getComplementoLocal() {
        return complementoLocal;
    }

    /**
     * @param complementoLocal the complementoLocal to set
     */
    public void setComplementoLocal(String complementoLocal) {
        this.complementoLocal = complementoLocal;
    }

    /**
     * @return the cidadeLocal
     */
    public String getCidadeLocal() {
        return cidadeLocal;
    }

    /**
     * @param cidadeLocal the cidadeLocal to set
     */
    public void setCidadeLocal(String cidadeLocal) {
        this.cidadeLocal = cidadeLocal;
    }

    /**
     * @return the ufLocal
     */
    public String getUfLocal() {
        return ufLocal;
    }

    /**
     * @param ufLocal the ufLocal to set
     */
    public void setUfLocal(String ufLocal) {
        this.ufLocal = ufLocal;
    }

    /**
     * @return the cepLocal
     */
    public String getCepLocal() {
        return cepLocal;
    }

    /**
     * @param cepLocal the cepLocal to set
     */
    public void setCepLocal(String cepLocal) {
        this.cepLocal = cepLocal;
    }

    /**
     * @return the telefoneLocal
     */
    public String getTelefoneLocal() {
        return telefoneLocal;
    }

    /**
     * @param telefoneLocal the telefoneLocal to set
     */
    public void setTelefoneLocal(String telefoneLocal) {
        this.telefoneLocal = telefoneLocal;
    }

    /**
     * @return the tipoCordenacao
     */
    public String getTipoCordenacao() {
        return tipoCordenacao;
    }

    /**
     * @param tipoCordenacao the tipoCordenacao to set
     */
    public void setTipoCordenacao(String tipoCordenacao) {
        this.tipoCordenacao = tipoCordenacao;
    }

    /**
     * @return the Q1
     */
    public String getQ1() {
        return Q1;
    }

    /**
     * @param Q1 the Q1 to set
     */
    public void setQ1(String Q1) {
        this.Q1 = Q1;
    }

    /**
     * @return the Q2
     */
    public String getQ2() {
        return Q2;
    }

    /**
     * @param Q2 the Q2 to set
     */
    public void setQ2(String Q2) {
        this.Q2 = Q2;
    }

    /**
     * @return the Q3a
     */
    public String getQ3a() {
        return Q3a;
    }

    /**
     * @param Q3a the Q3a to set
     */
    public void setQ3a(String Q3a) {
        this.Q3a = Q3a;
    }

    /**
     * @return the Q3b
     */
    public String getQ3b() {
        return Q3b;
    }

    /**
     * @param Q3b the Q3b to set
     */
    public void setQ3b(String Q3b) {
        this.Q3b = Q3b;
    }

    /**
     * @return the Q3c
     */
    public String getQ3c() {
        return Q3c;
    }

    /**
     * @param Q3c the Q3c to set
     */
    public void setQ3c(String Q3c) {
        this.Q3c = Q3c;
    }

    /**
     * @return the Q3d
     */
    public String getQ3d() {
        return Q3d;
    }

    /**
     * @param Q3d the Q3d to set
     */
    public void setQ3d(String Q3d) {
        this.Q3d = Q3d;
    }

    /**
     * @return the Q3e
     */
    public String getQ3e() {
        return Q3e;
    }

    /**
     * @param Q3e the Q3e to set
     */
    public void setQ3e(String Q3e) {
        this.Q3e = Q3e;
    }

    /**
     * @return the Q4a
     */
    public String getQ4a() {
        return Q4a;
    }

    /**
     * @param Q4a the Q4a to set
     */
    public void setQ4a(String Q4a) {
        this.Q4a = Q4a;
    }

    /**
     * @return the Q4b
     */
    public String getQ4b() {
        return Q4b;
    }

    /**
     * @param Q4b the Q4b to set
     */
    public void setQ4b(String Q4b) {
        this.Q4b = Q4b;
    }

    /**
     * @return the Q4c
     */
    public String getQ4c() {
        return Q4c;
    }

    /**
     * @param Q4c the Q4c to set
     */
    public void setQ4c(String Q4c) {
        this.Q4c = Q4c;
    }

    /**
     * @return the Q4d
     */
    public String getQ4d() {
        return Q4d;
    }

    /**
     * @param Q4d the Q4d to set
     */
    public void setQ4d(String Q4d) {
        this.Q4d = Q4d;
    }

    /**
     * @return the Q4e
     */
    public String getQ4e() {
        return Q4e;
    }

    /**
     * @param Q4e the Q4e to set
     */
    public void setQ4e(String Q4e) {
        this.Q4e = Q4e;
    }

    /**
     * @return the Q5
     */
    public String getQ5() {
        return Q5;
    }

    /**
     * @param Q5 the Q5 to set
     */
    public void setQ5(String Q5) {
        this.Q5 = Q5;
    }

    /**
     * @return the Q5complemento
     */
    public String getQ5complemento() {
        return Q5complemento;
    }

    /**
     * @param Q5complemento the Q5complemento to set
     */
    public void setQ5complemento(String Q5complemento) {
        this.Q5complemento = Q5complemento;
    }

    /**
     * @return the listaLocais
     */
    public List<Rotina006CoordenacaoLocalLocais> getListaLocais() {
        return listaLocais;
    }

    /**
     * @param listaLocais the listaLocais to set
     */
    public void setListaLocais(List<Rotina006CoordenacaoLocalLocais> listaLocais) {
        this.listaLocais = listaLocais;
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

    /**
     * @return the dataInsercao
     */
    public String getDataInsercao() {
        return dataInsercao;
    }

    /**
     * @param dataInsercao the dataInsercao to set
     */
    public void setDataInsercao(String dataInsercao) {
        this.dataInsercao = dataInsercao;
    }

    /**
     * @return the horaInsercao
     */
    public String getHoraInsercao() {
        return horaInsercao;
    }

    /**
     * @param horaInsercao the horaInsercao to set
     */
    public void setHoraInsercao(String horaInsercao) {
        this.horaInsercao = horaInsercao;
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
